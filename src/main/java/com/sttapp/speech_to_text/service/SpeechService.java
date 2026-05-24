package com.sttapp.speech_to_text.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sttapp.speech_to_text.dto.TranscriptResponse;
import com.sttapp.speech_to_text.model.Transcription;

@Service
public class SpeechService {

    private final List<Transcription> history =
            new ArrayList<>();

    public TranscriptResponse convertToText(
            String fileName
    ) {

        String transcript =
                "Transcription generated for: "+fileName;

        history.add(
                new Transcription(
                        fileName,
                        transcript
                )
        );

        return new TranscriptResponse(
                "success",
                fileName,
                transcript
        );
    }

    public List<Transcription> getHistory() {
        return history;
    }
}