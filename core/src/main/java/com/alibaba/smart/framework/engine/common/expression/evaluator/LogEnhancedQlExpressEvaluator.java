package com.alibaba.smart.framework.engine.common.expression.evaluator;

import java.util.Map;

import com.alibaba.smart.framework.engine.common.util.QlExpressUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 高海军 帝奇 74394 on 2017 February  15:51.
 */
public class LogEnhancedQlExpressEvaluator implements ExpressionEvaluator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogEnhancedQlExpressEvaluator.class);


    private static final String START_TAG = "${";
    private static final String END_TAG = "}";

    @Override
    public Object eval(String expression, Map<String, Object> vars,boolean needCached) {

        LOGGER.info("BEFORE: PvmActivityTask thread id  is {}, each param  is {} ,{} ",Thread.currentThread().getId(),expression,vars);

        Object result = QlExpressUtil.eval(expression,vars,needCached);

        LOGGER.info("AFTER: PvmActivityTask thread id  is {}, each param is {} , {} , {} ",Thread.currentThread().getId(),expression,vars,result);

        return result;

    }
}
