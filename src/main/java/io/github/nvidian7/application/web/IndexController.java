package io.github.nvidian7.application.web;

import io.github.nvidian7.application.entity.Account;
import io.github.nvidian7.application.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class IndexController {

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

}
