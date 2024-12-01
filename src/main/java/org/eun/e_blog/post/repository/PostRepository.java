package org.eun.e_blog.post.repository;

import org.eun.e_blog.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
