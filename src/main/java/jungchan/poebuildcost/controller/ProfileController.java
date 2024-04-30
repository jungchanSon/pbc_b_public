package jungchan.poebuildcost.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(originPatterns = "https://*.poebuildcost.com")
public class ProfileController {

    private final Environment env;

    @GetMapping("/profile")
    public String getProfile(){
        String s = Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");

        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
