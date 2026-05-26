package com.sttapp.speech_to_text.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AssemblyConfig {

    @Bean
    public WebClient webClient() {

        return WebClient.builder()
                .baseUrl(
                        "https://api.assemblyai.com"
                )
                .build();

    }

}