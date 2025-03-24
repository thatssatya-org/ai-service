package com.samsepiol.open.ai.support.api;

import com.samsepiol.open.ai.client.OpenAIServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/open-ai")
@RequiredArgsConstructor
public class OpenAISupportController {
    private final OpenAIServiceClient openAIServiceClient;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok(openAIServiceClient.ping());
    }
}
