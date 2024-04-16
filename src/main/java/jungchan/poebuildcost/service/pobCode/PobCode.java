package jungchan.poebuildcost.service.pobCode;

import jakarta.validation.Valid;
import jungchan.poebuildcost.form.PobCodeForm;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public interface PobCode {
    Document pobCode(@Valid PobCodeForm pobCodeForm) throws DataFormatException, IOException, ParserConfigurationException, SAXException;
}
