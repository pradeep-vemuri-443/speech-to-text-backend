package com.sttapp.speech_to_text.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sttapp.speech_to_text.dto.UploadResponse;

@Service
public class AssemblyService {

    private final WebClient webClient;

    @Value("${assembly.api.key}")
    private String apiKey;

    public AssemblyService(
            WebClient webClient
    ) {
        this.webClient = webClient;
    }

    public String uploadFile(
            String path
    ) {

        UploadResponse response =
                webClient
                        .post()
                        .uri("/v2/upload")
                        .header(
                                "authorization",
                                apiKey
                        )
                        .bodyValue(
                                new FileSystemResource(
                                        path
                                )
                        )
                        .retrieve()
                        .bodyToMono(
                                UploadResponse.class
                        )
                        .block();

        return response.upload_url;

    }
    public String testConnection() {
    return "Assembly configured";
}

}