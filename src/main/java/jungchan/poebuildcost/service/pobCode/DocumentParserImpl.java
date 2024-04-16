package jungchan.poebuildcost.service.pobCode;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class DocumentParserImpl implements DocumentParser {
    @Override
    public Document getDocument(byte[] pobByteCode) throws ParserConfigurationException, IOException, SAXException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pobByteCode);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        return documentBuilder.parse(byteArrayInputStream);
    }
}
