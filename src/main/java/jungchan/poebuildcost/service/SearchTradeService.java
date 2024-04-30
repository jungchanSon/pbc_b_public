package jungchan.poebuildcost.service;

import jungchan.poebuildcost.controller.temp.SearchTradeReqForm;
import jungchan.poebuildcost.controller.temp.resp.TradeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SearchTradeService {

    @Value("${app.POETRADEURL}")
    private String POETRADEURL;

    public TradeResponse searchItem(WebClient webClient, SearchTradeReqForm searchTradeReqForm){
        try {
            Mono<TradeResponse> tradeResponseMono = webClient.post()
                    .uri(POETRADEURL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(searchTradeReqForm)
                    .retrieve()
                    .bodyToMono(TradeResponse.class);
            TradeResponse tradeResponse = tradeResponseMono.block();
            return tradeResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
