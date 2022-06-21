package com.alibaba.smart.framework.engine.bpmn.assembly.task.parser;

import com.alibaba.smart.framework.engine.bpmn.assembly.task.ScriptText;
import com.alibaba.smart.framework.engine.extension.annoation.ExtensionBinding;
import com.alibaba.smart.framework.engine.extension.constant.ExtensionConstant;
import com.alibaba.smart.framework.engine.xml.parser.AbstractElementParser;
import com.alibaba.smart.framework.engine.xml.parser.ParseContext;
import com.alibaba.smart.framework.engine.xml.util.XmlParseUtil;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.Serializable;

@ExtensionBinding(group = ExtensionConstant.ELEMENT_PARSER, bindKey = ScriptText.class)
public class ScriptTextParser extends AbstractElementParser<ScriptText> implements Serializable {

    @Override
    public Class<ScriptText> getModelType() {
        return ScriptText.class;
    }

    @Override
    public ScriptText parseElement(XMLStreamReader reader, ParseContext context) throws XMLStreamException {
        ScriptText child = new ScriptText();
        child.setResultVariable(XmlParseUtil.getString(reader, "resultVariable"));
        child.setScript(reader.getElementText());

        return child;
    }

}