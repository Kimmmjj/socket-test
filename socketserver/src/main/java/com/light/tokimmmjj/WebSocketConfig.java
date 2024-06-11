package com.light.tokimmmjj;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final ChatPreHandler chatPreHandler; //채팅 전처리 핸들러 객체를 주입

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { //STOMP 엔드포인트를 등록, 클라이언트에서 웹소켓 연결을 수립할 수 있도록 함
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //메시지 브로커를 구성, 클라이언트로부터 메시지를 수신할 주제 및 메시지를 발행할 주제를 설정

        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) { //클라이언트로부터의 입력 채널을 구성, 클라이언트에서 서버로 메시지를 보내기 전에 수행
        registration.interceptors(chatPreHandler);
    }


}