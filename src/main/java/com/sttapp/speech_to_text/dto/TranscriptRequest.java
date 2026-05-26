package com.sttapp.speech_to_text.dto;

public class TranscriptRequest {

    private String audio_url;

    public TranscriptRequest() {
    }

    public TranscriptRequest(
            String audio_url
    ) {
        this.audio_url =
                audio_url;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(
            String audio_url
    ) {
        this.audio_url =
                audio_url;
    }

}