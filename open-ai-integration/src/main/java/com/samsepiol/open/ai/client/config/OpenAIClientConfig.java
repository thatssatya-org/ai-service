package com.samsepiol.open.ai.client.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "open-ai-client-config")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OpenAIClientConfig {
    String apiKey;
}
