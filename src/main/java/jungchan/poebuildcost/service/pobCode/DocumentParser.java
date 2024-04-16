package jungchan.poebuildcost.service.pobCode;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface DocumentParser {

    Document getDocument(byte[] pobByteCode) throws ParserConfigurationException, IOException, SAXException;

}
