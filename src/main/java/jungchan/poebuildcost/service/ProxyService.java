package jungchan.poebuildcost.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

@Service
public class ProxyService {

    private final String PROXY_HOST;
    private final int PROXY_PORT;
    private final String PROXY_USERNAME;
    private final String PROXY_PASSWORD;

    public ProxyService(@Value("${app.PROXY_HOST}") String PROXY_HOST,
                        @Value("${app.PROXY_PORT}") int PROXY_PORT,
                        @Value("${app.PROXY_USERNAME}") String PROXY_USERNAME,
                        @Value("${app.PROXY_PASSWORD}") String PROXY_PASSWORD) {
        this.PROXY_HOST = PROXY_HOST;
        this.PROXY_PORT = PROXY_PORT;
        this.PROXY_USERNAME = PROXY_USERNAME;
        this.PROXY_PASSWORD = PROXY_PASSWORD;
    }

    public WebClient createWebClient() {

        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(tcpClient -> tcpClient
                        .proxy(proxy -> proxy
                                .type(ProxyProvider.Proxy.HTTP)
                                .host(PROXY_HOST)
                                .port(PROXY_PORT)
                                .username(PROXY_USERNAME)
                                .password(user -> PROXY_PASSWORD)
                        ));

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
