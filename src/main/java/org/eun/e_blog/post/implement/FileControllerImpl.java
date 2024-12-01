package org.eun.e_blog.post.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.post.controller.FileController;
import org.eun.e_blog.post.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/file")
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {
    private final FileService fileService;
}
