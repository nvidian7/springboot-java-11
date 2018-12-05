package io.github.nvidian7.application.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class IndexController {

    @GetMapping("/")
    public Object healthCheck() {
        return "Hello, world!";
    }

    @GetMapping("/{id}")
    private Mono<String> exampleResource(@PathVariable String id) {
        return Mono.just("Hello " + id);
    }

}
