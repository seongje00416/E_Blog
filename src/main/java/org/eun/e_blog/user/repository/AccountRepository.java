package org.eun.e_blog.user.repository;

import org.eun.e_blog.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmailAndPasswordAndDeletedAtIsNull(String email, String password);
}
