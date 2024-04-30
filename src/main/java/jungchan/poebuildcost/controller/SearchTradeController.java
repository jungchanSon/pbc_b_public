package jungchan.poebuildcost.controller;

import jungchan.poebuildcost.controller.temp.SearchTradeReqForm;
import jungchan.poebuildcost.controller.temp.resp.TradeResponse;
import jungchan.poebuildcost.service.ProxyService;
import jungchan.poebuildcost.service.SearchPriceService;
import jungchan.poebuildcost.service.SearchTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.zip.DataFormatException;

@Slf4j
@RequiredArgsConstructor
@RestController()
@RequestMapping("/api")
@CrossOrigin(originPatterns = "*")
public class SearchTradeController {

    private final ProxyService proxyService;
    private final SearchTradeService searchTradeService;
    private final SearchPriceService searchPriceService;

    @RequestMapping(value = "/trade/search", method = RequestMethod.POST)
    public ResponseEntity searchTrade(@RequestBody SearchTradeReqForm searchTradeReqForm, BindingResult result) throws DataFormatException, IOException, ParserConfigurationException, SAXException {

        WebClient webClient = proxyService.createWebClient();
        TradeResponse searchResult = searchTradeService.searchItem(webClient, searchTradeReqForm);
        if (searchResult == null) {
            return ResponseEntity.badRequest().body("Fail search");
        }
        log.info("[search result]{}={}", searchResult.getId(), searchResult.getTotal());
        return ResponseEntity.ok().body(searchResult);
    }
}
