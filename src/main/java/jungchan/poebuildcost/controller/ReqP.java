package jungchan.poebuildcost.controller;

import com.google.gson.Gson;
import jakarta.validation.Valid;
import jungchan.poebuildcost.form.PobUrlForm;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;

@RestController()
public class ReqP {

    String ts = "{\n" +
            "        query: {\n" +
            "            // name: \"The Pariah\",\n" +
            "            stats: [{\n" +
            "                type: \"and\",\n" +
            "                filters: reqFilter\n" +
            "            }]\n" +
            "        },\n" +
            "        sort: {\n" +
            "            \"price\": \"asc\"\n" +
            "        }\n" +
            "    }";

    @PostMapping(value = "/t")
    public void pobUrl(@RequestBody String obj, BindingResult result) {
        System.out.println("obj = " + obj);
        String url = "https://www.pathofexile.com/api/trade/search/Necropolis";


        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        final HttpEntity<?> entity = new HttpEntity<>(header);

        Object res = new RestTemplate().postForObject(
                url,
                obj,
                Object.class,
                MediaType.APPLICATION_JSON
        );
        System.out.println("res = " + res);

        //TODO: url to base64
    }
}
