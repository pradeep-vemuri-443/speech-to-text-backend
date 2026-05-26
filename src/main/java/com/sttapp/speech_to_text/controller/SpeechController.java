package com.sttapp.speech_to_text.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sttapp.speech_to_text.service.SpeechService;

@RestController
@RequestMapping("/api/speech")
public class SpeechController {

    @Autowired
    private SpeechService speechService;

    @PostMapping("/upload")
    public Object upload(
            @RequestParam("file")
            MultipartFile file
    ) throws IOException {

        String uploadDir =
                System.getProperty("user.dir")
                        + "\\uploads\\";

        File savedFile =
                new File(
                        uploadDir
                                + file.getOriginalFilename()
                );

        file.transferTo(savedFile);

        return speechService.convertToText(
                file.getOriginalFilename()
        );
    }
    @GetMapping("/history")
    public Object history() {
        return speechService.getHistory();
    }
    @GetMapping(
        "/history/{id}"
    )
    public Object getOne(
        @PathVariable
        Long id
     ) {
        return speechService
        .getById(id);
     }
     @DeleteMapping(
        "/history/{id}"
     )
     public Object delete(
        @PathVariable
        Long id
      ) {
        return speechService
                .delete(id);
        }
        @GetMapping(
        "/count"
        )
        public Object count() {

        return java.util.Map.of(
                "count",
                speechService.count()
        );

        }
}