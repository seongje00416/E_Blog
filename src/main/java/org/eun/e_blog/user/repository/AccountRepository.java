package org.eun.e_blog.user.repository;

import org.eun.e_blog.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
