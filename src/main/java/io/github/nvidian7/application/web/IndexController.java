package io.github.nvidian7.application.web;

import io.github.nvidian7.application.entity.Account;
import io.github.nvidian7.application.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    private final static String CURRENT_TIME_API_URL = "http://worldclockapi.com/api/json/utc/now";

    private final AccountRepository accountRepository;

    @GetMapping("/")
    public Object healthCheck() {
        return "Hello, world!";
    }

    @GetMapping("/{id}")
    private Mono<Account> getAccount(@PathVariable String id) {
        return Mono.justOrEmpty(accountRepository.findById(id));
    }

    @PutMapping("/{id}")
    private Mono<Account> putAccount(@PathVariable String id, @RequestParam String name) {
        Account account = Account.builder().id(id).name(name).build();
        account = accountRepository.save(account);
        return Mono.just(account);
    }

    @GetMapping("/now")
    private Mono<Object> now() {
        return WebClient.create(CURRENT_TIME_API_URL).get().retrieve().bodyToMono(Object.class);
    }

}
