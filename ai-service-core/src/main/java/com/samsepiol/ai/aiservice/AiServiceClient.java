package com.samsepiol.ai.aiservice;

import com.samsepiol.ai.aiservice.request.AIClientRequest;
import com.samsepiol.ai.aiservice.response.AIResponse;

import java.util.concurrent.CompletableFuture;

public interface AiServiceClient {
    AIResponse getResponse(AIClientRequest request);

    CompletableFuture<AIResponse> getAsyncResponse(AIClientRequest request);
}
