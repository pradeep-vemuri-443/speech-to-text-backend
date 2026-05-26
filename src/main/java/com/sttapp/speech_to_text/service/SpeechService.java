package com.sttapp.speech_to_text.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sttapp.speech_to_text.dto.TranscriptResponse;
import com.sttapp.speech_to_text.model.Transcription;
import com.sttapp.speech_to_text.repository.TranscriptionRepository;

@Service
public class SpeechService {

    @Autowired
    private TranscriptionRepository repository;

    public TranscriptResponse convertToText(
            String fileName
    ) {

        String transcript =
                "Transcription generated for: "
                        + fileName;

        repository.save(
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

        return repository.findAll();

    }
    public Object getById(
        Long id
        ) {

        return repository
                .findById(id)
                .orElse(
                        null
                );

        }
        public String delete(
                Long id
        ) {
                repository.deleteById(id);
                return "Deleted";
        }

}