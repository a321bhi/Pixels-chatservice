package com.pixels.chatservice.doa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pixels.chatservice.message.Message;

@Repository
public interface MessageRepo extends MongoRepository<Message, Long>{

	@Query("{$or:[{'usernameTo':?0},{'usernameFrom':?0} ]}")
	public Optional<List<Message>> findByUsername(String username);
}
