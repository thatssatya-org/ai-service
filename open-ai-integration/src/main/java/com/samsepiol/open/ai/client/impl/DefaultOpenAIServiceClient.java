package com.samsepiol.open.ai.client.impl;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.samsepiol.open.ai.client.OpenAIServiceClient;
import com.samsepiol.open.ai.client.config.OpenAIClientConfig;
import org.springframework.stereotype.Service;

@Service
public class DefaultOpenAIServiceClient implements OpenAIServiceClient {
    private final OpenAIClient openAIClient;

    public DefaultOpenAIServiceClient(OpenAIClientConfig clientConfig) {
        this.openAIClient = OpenAIOkHttpClient.builder()
                .apiKey(clientConfig.getApiKey())
                .build();
    }

    @Override
    public String ping() {
        var responseCreateParams = ResponseCreateParams.builder()
                .input("Hello, my name is Issac Newton.")
                .model(ChatModel.GPT_3_5_TURBO)
                .build();
        return openAIClient.responses().create(responseCreateParams).output().getFirst().asMessage().content().getFirst().asOutputText().text();
    }
}
