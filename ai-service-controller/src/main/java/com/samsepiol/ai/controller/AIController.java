package com.samsepiol.ai.controller;

import com.samsepiol.ai.aiservice.response.AIResponse;
import com.samsepiol.ai.controller.mapper.ServiceRequestMapper;
import com.samsepiol.ai.controller.request.AIApiRequest;
import com.samsepiol.ai.service.AIService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ai")
@RequiredArgsConstructor
public class AIController {
    private final AIService aiService;

    @PostMapping
    public ResponseEntity<AIResponse> getResponse(
            @Valid @RequestParam(defaultValue = "1") Integer count,
            @NotNull @Valid @RequestBody AIApiRequest request) {

        var serviceRequest = ServiceRequestMapper.MAPPER.to(request, count);

        return ResponseEntity
                .ok()
                .body(aiService.getResponse(serviceRequest));
    }

}
