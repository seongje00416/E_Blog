package org.eun.e_blog.post.repository;

import org.eun.e_blog.post.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
