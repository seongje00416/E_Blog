package org.eun.e_blog.post.repository;

import org.eun.e_blog.post.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    Page<Reply> findAllByPostIDAndDeletedAtIsNull( Long postID, Pageable pageable );
}
