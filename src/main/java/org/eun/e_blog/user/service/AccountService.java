package org.eun.e_blog.user.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.user.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
}
