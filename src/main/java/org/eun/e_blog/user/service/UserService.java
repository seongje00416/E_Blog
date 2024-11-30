package org.eun.e_blog.user.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.user.dto.request.UpdateUserRequest;
import org.eun.e_blog.user.dto.response.GetUserDetailResponse;
import org.eun.e_blog.user.entity.User;
import org.eun.e_blog.user.exception.UserNotFoundException;
import org.eun.e_blog.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public GetUserDetailResponse getUserDetail( Long userID ) {
        User user = userRepository.findByIdAndDeletedAtIsNull( userID ).orElseThrow( UserNotFoundException::new );
        return GetUserDetailResponse.of( user );
    }

    @Transactional
    public void deleteUser( Long userID ) {
        User user = userRepository.findByIdAndDeletedAtIsNull( userID ).orElseThrow( UserNotFoundException::new );
        user.delete(LocalDateTime.now());
    }

    @Transactional
    public void updateUser(Long userID, UpdateUserRequest updateUserRequest ){
        User user = userRepository.findByIdAndDeletedAtIsNull( userID ).orElseThrow( UserNotFoundException::new );
        user.update(updateUserRequest.userName() );
    }
}
