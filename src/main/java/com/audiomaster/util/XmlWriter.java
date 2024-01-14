package com.audiomaster.util;

import com.audiomaster.plugin.channel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class XmlWriter {

    public void toXmlKnob(channel channel) throws ParserConfigurationException, TransformerException, IOException, URISyntaxException {
        // Document 생성(문서 생성)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        document.setXmlStandalone(true);  // standalone="no" 제거

        // Processor (Eq + Drc)
        Element processor = document.createElement("processor");
        document.appendChild(processor);

        // Eq
        List<List<String>> listProcessor = channel.toElement();
        Element paramEqXml = document.createElement("equaliser");
        processor.appendChild(paramEqXml);

        for(List<String> iter : listProcessor) {
            Element EqBand = document.createElement(iter.get(0));
            paramEqXml.appendChild(EqBand);

            Element Gain = document.createElement("Gain");
            Gain.setTextContent(iter.get(1));
            Element Freq = document.createElement("Freq");
            Freq.setTextContent(iter.get(2));
            Element qValue = document.createElement("Q");
            qValue.setTextContent(iter.get(3));
            EqBand.appendChild(Gain);
            EqBand.appendChild(Freq);
            EqBand.appendChild(qValue);
        }

        // XML 생성
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("encoding", "UTF-8");  // setOutputProperty  : 출력형태 만들 때 사용
        transformer.setOutputProperty("indent", "yes");  // indent  : 들여쓰기
        transformer.setOutputProperty("doctype-public", "yes");  // document.setXmlStandalone(true); 하면 개행이 안 되기 때문에 추가

        Source source = new DOMSource(document);
        File file = new File("C:\\spring\\audio-mastering\\src\\main\\resources\\param", "test.xml");
        StreamResult result = new StreamResult(file);

        transformer.transform(source, result);
    }
}
