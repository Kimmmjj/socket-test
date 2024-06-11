package com.light.tokimmmjj;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template; //웹소켓 메시징을 위한 템플릿, 메시지를 전송할 때 사용

    @MessageMapping("/message/{chatRoomId}")
    public void sendMessage(@DestinationVariable("chatRoomId") Long roomId, MessageDto messageDto) {

        template.convertAndSend("/sub/" + roomId, messageDto);

    }
}
