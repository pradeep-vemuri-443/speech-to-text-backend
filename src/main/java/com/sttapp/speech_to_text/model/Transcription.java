package com.sttapp.speech_to_text.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transcription {

    @Id
    @GeneratedValue(
            strategy =
            GenerationType.IDENTITY
    )
    private Long id;

    private String fileName;

    private String transcript;

    private String uploadedAt;

    public Transcription() {
    }

    public Transcription(
            String fileName,
            String transcript
    ) {

        this.fileName = fileName;

        this.transcript = transcript;

        this.uploadedAt =
                java.time.LocalDateTime
                        .now()
                        .toString();

    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTranscript() {
        return transcript;
    }

    public String getUploadedAt() {
        return uploadedAt;
    }
}