package com.audiomaster.util;

import com.audiomaster.plugin.channel;
import com.audiomaster.plugin.compressor;
import com.audiomaster.plugin.equalizer;
import com.audiomaster.plugin.processor;
import com.audiomaster.plugin.type.EqType;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

class XmlWriterTest {

    @Test
    void test() throws ParserConfigurationException, TransformerException, IOException, URISyntaxException {
        XmlWriter xmlWriter = new XmlWriter();
        List<processor> processorList = new ArrayList<>();
        processorList.add(new equalizer(EqType.LOWSHELF, 0.1, 0.5, 1.2));
        processorList.add(new equalizer(EqType.LOWSHELF, 0.1, 0.5, 1.2));
        processorList.add(new equalizer(EqType.LOWSHELF, 0.1, 0.5, 1.2));
        processorList.add(new equalizer(EqType.LOWSHELF, 0.1, 0.5, 1.2));
        processorList.add(new equalizer(EqType.LOWSHELF, 0.1, 0.5, 1.2));
        processorList.add(new compressor(0.1,0.1, 0.1, 0.1, 0.1));

        channel channel = new channel(processorList);
        xmlWriter.toXmlKnob(channel);
    }
}