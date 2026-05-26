package com.sttapp.speech_to_text.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AssemblyService {

    @Value("${assembly.api.key}")
    private String apiKey;

    public String testConnection() {

        return "Assembly configured";

    }

}