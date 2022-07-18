package com.pixels.chatservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pixels.chatservice.message.Message;
import com.pixels.chatservice.service.MessageServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/chat")
public class MessagesController {

	@Autowired
	MessageServiceImpl messageServiceImpl;

	@PostMapping("/get-all-chats")
	public List<Message> getChats(@RequestParam String username) {
		Optional<List<Message>> listOfMessageOpt = messageServiceImpl.findByUsername(username);
		if (listOfMessageOpt.isPresent()) {
			return listOfMessageOpt.get();
		} else {
			return null;
		}
	}

}
