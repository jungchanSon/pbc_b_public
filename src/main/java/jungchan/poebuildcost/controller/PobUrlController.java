package jungchan.poebuildcost.controller;

import jakarta.validation.Valid;
import jungchan.poebuildcost.form.PobUrlForm;
import jungchan.poebuildcost.service.PobUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pobUrl")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"https://*.poebuildcost.com", "https://poebuildcost.com"})
public class PobUrlController {

    private final PobUrlService pobUrlService;

    @PostMapping(value = "pobUrl")
    public void pobUrl(@Valid PobUrlForm pobUrlForm, BindingResult result) {
        //TODO: url to base64
    }
}
