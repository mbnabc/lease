package com.liurunqing.lease.web.admin.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String fileUpload(MultipartFile file);
}
