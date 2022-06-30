package com.alibaba.smart.framework.engine.behavior.impl;

import com.alibaba.smart.framework.engine.behavior.base.AbstractActivityBehavior;
import com.alibaba.smart.framework.engine.bpmn.assembly.task.ScriptTask;
import com.alibaba.smart.framework.engine.common.util.QlExpressUtil;
import com.alibaba.smart.framework.engine.common.util.StringUtil;
import com.alibaba.smart.framework.engine.context.ExecutionContext;
import com.alibaba.smart.framework.engine.exception.EngineException;
import com.alibaba.smart.framework.engine.extension.annoation.ExtensionBinding;
import com.alibaba.smart.framework.engine.extension.constant.ExtensionConstant;

import com.alibaba.smart.framework.engine.pvm.PvmActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtensionBinding(group = ExtensionConstant.ACTIVITY_BEHAVIOR, bindKey = ScriptTask.class)
/**
 * @author zilong.jiangzl 2020-07-17
 */
public class ScriptTaskBehavior extends AbstractActivityBehavior<ScriptTask> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScriptTaskBehavior.class);

    public ScriptTaskBehavior() {
        super();
    }

    @Override
    protected void hookExecution(ExecutionContext context, PvmActivity pvmActivity) {
        ScriptTask task = (ScriptTask) pvmActivity.getModel();
        if("qlexpress".equals(task.getScriptFormat()) || "mvel".equals(task.getScriptFormat())){
            if (null != task.getScript()) {
                Object result = QlExpressUtil.eval(task.getScript(),context.getRequest(),  false);
                if(StringUtil.isNotEmpty(task.getResultVariable())){
                    context.getRequest().put(task.getResultVariable(),result);
                }
            }else{
                throw new EngineException("empty qlexpress script found for "+task.getId());
            }
        }
    }

}
