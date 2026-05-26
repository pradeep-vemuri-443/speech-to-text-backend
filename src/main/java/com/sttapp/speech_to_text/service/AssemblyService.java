package com.sttapp.speech_to_text.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sttapp.speech_to_text.dto.TranscriptResult;
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
    public TranscriptResult transcribe(
        String uploadUrl
    ) {

        java.util.Map<String, Object> body =
                java.util.Map.of(
                        "audio_url",
                        uploadUrl,
                        "speech_models",
                        java.util.List.of(
                                "universal-2"
                        )
                );

        return webClient
                .post()
                .uri(
                        "/v2/transcript"
                )
                .header(
                        "authorization",
                        apiKey
                )
                .bodyValue(
                        body
                )
                .retrieve()
                .bodyToMono(
                        TranscriptResult.class
                )
                .block();

    }
    public String getTranscript(
        String id
    ) {

        while (true) {

            TranscriptResult result =
                    webClient
                            .get()
                            .uri(
                                    "/v2/transcript/" + id
                            )
                            .header(
                                    "authorization",
                                    apiKey
                            )
                            .retrieve()
                            .bodyToMono(
                                    TranscriptResult.class
                            )
                            .block();

            if (
                    "completed"
                            .equals(
                                    result.status
                            )
            ) {

                return result.text;

            }

            if (
                    "error"
                            .equals(
                                    result.status
                            )
            ) {

                return "Transcription failed";

            }

            try {

                Thread.sleep(
                        3000
                );

            }

            catch (
                    Exception e
            ) {

            }

        }

    }
    public String testConnection() {
    return "Assembly configured";
}

}