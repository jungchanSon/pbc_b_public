package jungchan.poebuildcost.service;

import jungchan.poebuildcost.entity.trade.resp.TradeResponse;
import jungchan.poebuildcost.entity.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SearchPriceService {

    private final ProxyService proxyService;

    public Price searchPrice(String itemId, String resultId) {
        WebClient webClient = proxyService.createWebClient();
        String SEARCHPRICEURL = "https://www.pathofexile.com/api/trade/fetch/" + resultId + "?query=" + itemId;

        try {
            Mono<Object> responseMono = webClient.get()
                    .uri(SEARCHPRICEURL)
                    .retrieve()
                    .bodyToMono(Object.class);
            Object block = responseMono.block();


            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
