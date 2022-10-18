package com.robosoft.springbootfileupload.service;

import com.robosoft.springbootfileupload.modal.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file);

    Attachment getAttachment(String fileId) throws Exception;
}
