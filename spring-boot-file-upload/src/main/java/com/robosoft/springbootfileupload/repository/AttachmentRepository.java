package com.robosoft.springbootfileupload.repository;

import com.robosoft.springbootfileupload.modal.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
