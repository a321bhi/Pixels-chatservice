package com.pixels.chatservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pixels.chatservice.message.Message;
import com.pixels.chatservice.service.MessageServiceImpl;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

	@Autowired
	MessageServiceImpl messageServiceImpl;

	@MessageMapping("/chat/{username}")
	@SendTo("/topic/{username}")
	public Message greeting(Message message, @DestinationVariable String username) throws Exception {
		messageServiceImpl.addMessage(message);
		return message;
	}

}
