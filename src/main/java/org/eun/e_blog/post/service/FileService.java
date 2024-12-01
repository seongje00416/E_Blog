package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.post.repository.FileRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
}
