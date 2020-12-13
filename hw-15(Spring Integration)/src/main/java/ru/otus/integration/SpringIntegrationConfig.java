package ru.otus.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class SpringIntegrationConfig {

    @Bean
    public MessageChannel ordersChannel() {
        return MessageChannels.queue(100).get();
    }

    @Bean
    public MessageChannel goodsChannel() {
        return MessageChannels.direct().get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(100).maxMessagesPerPoll(1).get();
    }

    @Bean
    public IntegrationFlow shopFlow() {
        return IntegrationFlows.from("ordersChannel")
                .split()
                .handle("shopService", "process")
                .aggregate()
                .channel("goodsChannel")
                .get();
    }

    @Bean
    public IntegrationFlow errorFlow() {
        return IntegrationFlows.from("errorChannel")
                .handle("orderErrorHandler", "handleFailedOrder")
                .get();
    }

}
