package com.horasphere.websockettest.interfaces.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.horasphere.websockettest.interfaces.dto.MessageWrapper;
import com.horasphere.websockettest.interfaces.dto.SimpleMessage;

@Controller
public class WebSocketController {
	
    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public MessageWrapper greeting(SimpleMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new MessageWrapper("New Message: " + message.getMessage());
    }    
}
