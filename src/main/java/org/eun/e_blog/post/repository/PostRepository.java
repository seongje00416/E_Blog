package org.eun.e_blog.post.repository;

import org.eun.e_blog.post.entity.Post;
import org.eun.e_blog.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByIdAndDeletedAtIsNull( Long postID );
    Page<Post> findAllByUserIdAndDeletedAtIsNull( Long userID, Pageable pageable );
}
