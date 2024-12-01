package org.eun.e_blog.post.repository;

import org.eun.e_blog.post.entity.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<PostFile, Long> {
}
