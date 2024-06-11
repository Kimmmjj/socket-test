package com.light.tokimmmjj;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatPreHandler implements ChannelInterceptor { //메시지 처리 전에 실행되는 채널 인터셉터 클래스

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        return message;
    }


}
