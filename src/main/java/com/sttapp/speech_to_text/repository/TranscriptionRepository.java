package com.sttapp.speech_to_text.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sttapp.speech_to_text.model.Transcription;

public interface TranscriptionRepository
extends JpaRepository<
        Transcription,
        Long
> {
}