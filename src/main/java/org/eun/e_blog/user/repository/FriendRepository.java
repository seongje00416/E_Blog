package org.eun.e_blog.user.repository;

import org.eun.e_blog.user.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
