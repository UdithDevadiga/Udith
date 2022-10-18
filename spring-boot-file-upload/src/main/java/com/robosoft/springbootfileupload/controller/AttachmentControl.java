package com.robosoft.springbootfileupload.controller;

import com.robosoft.springbootfileupload.modal.Attachment;
import com.robosoft.springbootfileupload.modal.ResponseData;
import com.robosoft.springbootfileupload.service.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentControl {
    private AttachmentService attachmentService;

    public AttachmentControl(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) {
        Attachment attachment = null;
        String downloadURL = "";
        attachment = attachmentService.saveAttachment(file);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(attachment.getId()).toUriString();
        return new ResponseData(attachment.getFileName(), downloadURL, file.getContentType(), file.getSize());
    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType())).header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\""+attachment.getFileName()+"\"").body(new ByteArrayResource(attachment.getData()));
    }
}
