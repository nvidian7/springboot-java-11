package io.github.nvidian7.application.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {

    @GetMapping("/")
    public Object healthCheck() {
        return "Hello, world!";
    }

}
