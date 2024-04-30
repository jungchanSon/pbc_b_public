package jungchan.poebuildcost.controller.temp;

import jakarta.validation.Valid;
import jungchan.poebuildcost.controller.temp.resp.TradeResponse;
import jungchan.poebuildcost.entity.item.Item;
import jungchan.poebuildcost.form.PobCodeForm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import reactor.core.publisher.Mono;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@CrossOrigin(originPatterns = "*")
@RequiredArgsConstructor
public class TmpController {

    RestTemplate restTemplate = new RestTemplate();

    private WebClient webClient = WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @RequestMapping(value = "/tmp", method = RequestMethod.POST)
    public ResponseEntity pobCode(@RequestBody TmpDto tmpDto, BindingResult result) throws DataFormatException, IOException, ParserConfigurationException, SAXException {
        long startMs = System.currentTimeMillis();
        System.out.println("tmpDto = " + tmpDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TmpDto> entity = new HttpEntity<>(tmpDto, headers);
        String url = "https://www.pathofexile.com/api/trade/search/Necropolis";
//        try{
//            String s = restTemplate.postForObject(url, entity, String.class);
//            System.out.println("s = " + s);
//            return ResponseEntity.ok().body(s);
//
//        } catch (Exception e){
//            System.out.println("e = " + e.getMessage());
//            return ResponseEntity.ok().body(tmpDto);
//
//        }
        try {
            Mono<TradeResponse> tradeResponseMono = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(tmpDto)
                    .retrieve()
                    .bodyToMono(TradeResponse.class);
            TradeResponse block = tradeResponseMono.block();
            System.out.println("block = " + block);



            return ResponseEntity.ok().body(block);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());

            return ResponseEntity.ok().body(e.getMessage());
        }

//        return restTemplate.postForObject(url, entity, String.class);
//        long endMs = System.currentTimeMillis();
//
//        log.info("[pobCode] response for /pobCode={}ms", endMs - startMs);
    }
}
