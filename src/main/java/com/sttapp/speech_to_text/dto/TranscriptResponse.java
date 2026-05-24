package com.sttapp.speech_to_text.dto;

public class TranscriptResponse {

    private String status;
    private String file;
    private String transcript;

    public TranscriptResponse(
            String status,
            String file,
            String transcript
    ) {
        this.status = status;
        this.file = file;
        this.transcript = transcript;
    }

    public String getStatus() {
        return status;
    }

    public String getFile() {
        return file;
    }

    public String getTranscript() {
        return transcript;
    }
}