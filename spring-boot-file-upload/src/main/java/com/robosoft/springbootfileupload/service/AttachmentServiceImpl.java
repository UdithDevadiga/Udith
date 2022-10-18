package com.robosoft.springbootfileupload.service;

import com.robosoft.springbootfileupload.modal.Attachment;
import com.robosoft.springbootfileupload.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{
    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }
    @Override
    public Attachment saveAttachment(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new Exception("File name contains invalid sequence"+fileName);
            }
            Attachment attachment = new Attachment(fileName,file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);

        } catch (Exception e) {
            throw new RuntimeException("Could not save file : "+fileName);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository.findById(fileId).orElseThrow(()->new Exception("File Not Found with ID "+fileId));
    }
}
