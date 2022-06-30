package com.alibaba.smart.framework.engine.common.expression.evaluator;

import java.util.Map;

import com.alibaba.smart.framework.engine.common.util.QlExpressUtil;

/**
 * Created by 高海军 帝奇 74394 on 2017 February  15:51.
 */
public class QlExpressEvaluator implements ExpressionEvaluator {

    @Override
    public Object eval(String expression, Map<String, Object> vars,boolean needCached) {
        return QlExpressUtil.eval(expression,vars,  needCached);
    }
}
