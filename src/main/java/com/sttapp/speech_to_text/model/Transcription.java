package com.sttapp.speech_to_text.model;

public class Transcription {

    private String fileName;

    private String transcript;

    public Transcription(
            String fileName,
            String transcript
    ) {
        this.fileName = fileName;
        this.transcript = transcript;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTranscript() {
        return transcript;
    }
}