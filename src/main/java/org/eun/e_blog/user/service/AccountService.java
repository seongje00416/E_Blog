package org.eun.e_blog.user.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.user.dto.request.CreateUserAccountRequest;
import org.eun.e_blog.user.entity.Account;
import org.eun.e_blog.user.entity.User;
import org.eun.e_blog.user.repository.AccountRepository;
import org.eun.e_blog.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createUserAccount(CreateUserAccountRequest createUserAccountRequest ){
        int birthYear = Integer.parseInt( createUserAccountRequest.birthday().substring( 0, 4 ) );
        int birthMonth = Integer.parseInt( createUserAccountRequest.birthday().substring( 4, 6 ) );
        int birthDay = Integer.parseInt( createUserAccountRequest.birthday().substring( 6, 8 ) );
        User user = User.builder()
                .userName(createUserAccountRequest.name() )
                .nickName(createUserAccountRequest.nickName() )
                .gender( createUserAccountRequest.gender() )
                .birthday( LocalDate.of( birthYear, birthMonth, birthDay ) )
                .build();
        Long userID = this.userRepository.save( user ).getId();
        Account account = Account.builder()
                .email(createUserAccountRequest.email() )
                .password(createUserAccountRequest.password() )
                .userID( userID )
                .build();
        this.accountRepository.save( account );
    }
}
