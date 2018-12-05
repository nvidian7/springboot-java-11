package io.github.nvidian7.application.repository;

import io.github.nvidian7.application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
