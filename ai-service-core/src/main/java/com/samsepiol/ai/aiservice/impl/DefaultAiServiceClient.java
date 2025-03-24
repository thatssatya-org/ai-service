package com.samsepiol.ai.aiservice.impl;

import com.samsepiol.ai.aiservice.AiServiceClient;
import com.samsepiol.ai.aiservice.config.AIClientConfig;
import com.samsepiol.ai.aiservice.request.AIClientRequest;
import com.samsepiol.ai.aiservice.response.AIResponse;
import com.samsepiol.library.core.exception.LibraryException;
import com.samsepiol.library.http.client.HttpClient;
import com.samsepiol.library.http.request.ApiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Primary
@Service
@RequiredArgsConstructor
public class DefaultAiServiceClient implements AiServiceClient {
    private static final String SERVICE = "aiService";
    private static final String CHAT_API = "chat";

    private final HttpClient httpClient;
    private final AIClientConfig aiClientConfig;

    @Override
    public AIResponse getResponse(AIClientRequest request) {
        try {
            var apiRequest = ApiRequest.builder()
                    .service(SERVICE)
                    .api(CHAT_API)
                    .body(request)
                    .headers(aiClientConfig.getHeaders())
                    .build();

            return httpClient.execute(apiRequest, AIResponse.class);
        } catch (LibraryException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompletableFuture<AIResponse> getAsyncResponse(AIClientRequest request) {
        try {
            var apiRequest = ApiRequest.builder()
                    .service(SERVICE)
                    .api(CHAT_API)
                    .body(request)
                    .headers(aiClientConfig.getHeaders())
                    .build();

            return httpClient.executeAsync(apiRequest, AIResponse.class);
        } catch (LibraryException e) {
            throw new RuntimeException(e);
        }
    }
}
