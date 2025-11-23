package com.carlosruanpucrs.tc2_microservico_jud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String JUD_BLOQUEIO_EXCHANGE = "jud.bloqueio.exchange";
    public static final String JUD_BLOQUEIO_QUEUE = "jud.bloqueio.queue";
    public static final String JUD_BLOQUEIO_RK = "jud.bloqueio.rk";

    public static final String JUD_BLOQUEIO_CONFIRMACAO_EXCHANGE = "jud.bloqueio.confirmacao.exchange";
    public static final String JUD_BLOQUEIO_CONFIRMACAO_QUEUE = "jud.bloqueio.confirmacao.queue";
    public static final String JUD_BLOQUEIO_CONFIRMACAO_RK = "jud.bloqueio.confirmacao.rk";

    @Bean
    public DirectExchange judBloqueioExchange() {
        return new DirectExchange(JUD_BLOQUEIO_EXCHANGE);
    }

    @Bean
    public Queue judBloqueioQueue() {
        return new Queue(JUD_BLOQUEIO_QUEUE);
    }

    @Bean
    public Binding judBloqueioBinding() {
        return BindingBuilder.bind(judBloqueioQueue())
                .to(judBloqueioExchange())
                .with(JUD_BLOQUEIO_RK);
    }

    @Bean
    public DirectExchange judBloqueioConfirmacaoExchange() {
        return new DirectExchange(JUD_BLOQUEIO_CONFIRMACAO_EXCHANGE);
    }

    @Bean
    public Queue judBloqueioConfirmacaoQueue() {
        return new Queue(JUD_BLOQUEIO_CONFIRMACAO_QUEUE);
    }

    @Bean
    public Binding judBloqueioConfirmacaoBinding() {
        return BindingBuilder.bind(judBloqueioConfirmacaoQueue())
                .to(judBloqueioConfirmacaoExchange())
                .with(JUD_BLOQUEIO_CONFIRMACAO_RK);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}