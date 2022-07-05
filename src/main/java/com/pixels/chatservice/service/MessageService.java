package com.pixels.chatservice.service;

import java.util.List;
import java.util.Optional;

import com.pixels.chatservice.message.Message;

public interface MessageService {
	public Optional<List<Message>> findByUsername(String username);
	public Message addMessage(Message message);
}
