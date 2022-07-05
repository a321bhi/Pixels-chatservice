package com.pixels.chatservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixels.chatservice.doa.MessageRepo;
import com.pixels.chatservice.message.Message;

@Service
public class MessageServiceImpl  implements MessageService{

	@Autowired
	MessageRepo messageRepo;
	
	@Override
	public Optional<List<Message>> findByUsername(String username) {
		return messageRepo.findByUsername(username);
	}

	@Override
	public Message addMessage(Message message) {
		return messageRepo.save(message);
	}

}
