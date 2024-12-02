package org.eun.e_blog.user.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.user.dto.request.UpdateUserRequest;
import org.eun.e_blog.user.dto.response.GetUserDetailResponse;
import org.eun.e_blog.user.entity.Friend;
import org.eun.e_blog.user.entity.FriendAssign;
import org.eun.e_blog.user.entity.User;
import org.eun.e_blog.user.exception.UserNotFoundException;
import org.eun.e_blog.user.repository.FriendRepository;
import org.eun.e_blog.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

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

    @Transactional
    public void addFriend( Long userID, Long friendID ) {
        User user = userRepository.findByIdAndDeletedAtIsNull( userID ).orElseThrow( UserNotFoundException::new );
        User friend = userRepository.findByIdAndDeletedAtIsNull( friendID ).orElseThrow( UserNotFoundException::new );
        Friend friendRequest = Friend.builder()
                .userID( userID )
                .friendID( friendID )
                .friendAssign( FriendAssign.ASSIGN_WAIT )
                .build();
        friendRepository.save( friendRequest );
    }
}
