package com.alibaba.smart.framework.engine.common.util;

import java.util.Map;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * 注意：低精度数值计算
 */
public abstract class QlExpressUtil {


    private static final String START_TAG = "${";
    private static final String END_TAG = "}";

    static ExpressRunner lowPreciseRunner;
    static ExpressRunner getRunner(){
        if(lowPreciseRunner==null){
            synchronized (QlExpressUtil.class){
                if(lowPreciseRunner==null)
                    lowPreciseRunner = new ExpressRunner(false, true);
            }
        }
        return lowPreciseRunner;
    }

    public static Object eval(String expression, Map<String, Object> vars,boolean needCached) {

        String processedExp = expression.trim();
        // 兼容Activiti ${nrOfCompletedInstances >= 1} 这种 JUEL 表达式;通过下面的调用去掉首尾.
        if(processedExp.startsWith(START_TAG)){
            processedExp =  StringUtil.removeStart(processedExp, START_TAG);
            processedExp =  StringUtil.removeEnd(processedExp, END_TAG);
        }

        DefaultContext<String,Object> context = new DefaultContext<String,Object>();

        context.putAll(vars);
        try {
            return getRunner().execute(expression, context, null, needCached, false);
        }catch (Exception ex){
            throw new RuntimeException("表达式执行失败："+expression,ex);
        }
    }
}