package jungchan.poebuildcost.service.pobCode;

import jakarta.validation.Valid;
import jungchan.poebuildcost.form.PobCodeForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Service
@Slf4j
@RequiredArgsConstructor
public class PobCodeService implements PobCode{

    private final Decoder base64decoder;
    private final Decompressor spaceDecompressor;
    private final DocumentParser documentParser;

    @Override
    public Document pobCode(@Valid PobCodeForm pobCodeForm) throws DataFormatException, IOException, ParserConfigurationException, SAXException {

        String pobCode = pobCodeForm.getPobCode();

        byte[] decodedPobCode = base64decoder.decode(pobCode);
        byte[] pobByteCode = spaceDecompressor.decompressSpace(decodedPobCode);
        Document document = documentParser.getDocument(pobByteCode);

        return document;
    }
}
