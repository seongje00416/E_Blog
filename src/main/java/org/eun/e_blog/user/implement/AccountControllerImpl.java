package org.eun.e_blog.user.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.user.controller.AccountController;
import org.eun.e_blog.user.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/account" )
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;
}
