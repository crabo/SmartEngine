package com.alibaba.smart.framework.engine.bpmn.assembly.task;

import javax.xml.namespace.QName;

import com.alibaba.smart.framework.engine.bpmn.constant.BpmnNameSpaceConstant;
import com.alibaba.smart.framework.engine.model.assembly.NoneIdBasedElement;
import lombok.Data;

@Data
public class ScriptText implements NoneIdBasedElement {

    public final static QName qtype = new QName(BpmnNameSpaceConstant.NAME_SPACE, "script");
    private static final long serialVersionUID = 2155118199015424007L;

    private String script;
    private String resultVariable; //将script执行结果等级在此变量名
}
