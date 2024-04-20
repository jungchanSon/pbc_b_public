package jungchan.poebuildcost.controller;

import jakarta.validation.Valid;
import jungchan.poebuildcost.entity.item.Item;
import jungchan.poebuildcost.form.PobCodeForm;
import jungchan.poebuildcost.repository.MongoDocumentEntity.Pseudo;
import jungchan.poebuildcost.repository.PseudoRepo;
import jungchan.poebuildcost.service.DocumentManager;
import jungchan.poebuildcost.service.pobCode.PobCode;
import jungchan.poebuildcost.service.PobDocumentManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class PobCodeController {

    private final PobCode pobCodeService;
    private final DocumentManager pobDocumentManager;

    @RequestMapping(value = "/pobCode", method = RequestMethod.POST)
    public ResponseEntity pobCode(@Valid PobCodeForm pobCodeForm, BindingResult result) throws DataFormatException, IOException, ParserConfigurationException, SAXException {

        Document document = pobCodeService.pobCode(pobCodeForm);
        ArrayList<Item> items = pobDocumentManager.parseItems(document);
        return ResponseEntity.ok().body(items);
    }
}
