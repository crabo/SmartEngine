package com.alibaba.smart.framework.engine.bpmn.assembly.task;

import javax.xml.namespace.QName;

import com.alibaba.smart.framework.engine.bpmn.constant.BpmnNameSpaceConstant;
import com.alibaba.smart.framework.engine.model.assembly.impl.AbstractTask;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author crabo 2022-06-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ScriptTask extends AbstractTask {

    public final static QName qtype = new QName(BpmnNameSpaceConstant.NAME_SPACE, "scriptTask");
    private static final long serialVersionUID = 2155118199015424897L;

    private String scriptFormat;
    private String script;
    private String resultVariable; //将script执行结果等级在此变量名

    @Override
    public String toString() {
        return super.getId();
    }

}
