package org.eun.e_blog.user.repository;

import org.eun.e_blog.user.entity.Friend;
import org.eun.e_blog.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    Optional<Friend> findByIdAndDeletedAtIsNull(Long assignID );
}
