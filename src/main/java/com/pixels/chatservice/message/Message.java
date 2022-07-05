package com.pixels.chatservice.message;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat_collection")
public class Message {
	@Transient
	public static final String SEQUENCE_NAME = "message_sequence";
	@Id
	private long messageId;
	private String message;
	private String usernameFrom;
	private String usernameTo;
	private Date timeSent;

	@Override
	public String toString() {
		return "Message [message=" + message + ", usernameFrom=" + usernameFrom + ", usernameTo=" + usernameTo
				+ ", timeSent=" + timeSent + "]";
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsernameFrom() {
		return usernameFrom;
	}

	public void setUsernameFrom(String usernameFrom) {
		this.usernameFrom = usernameFrom;
	}

	public String getUsernameTo() {
		return usernameTo;
	}

	public void setUsernameTo(String usernameTo) {
		this.usernameTo = usernameTo;
	}

	public Date getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}

	public Message(long messageId, String message, String usernameFrom, String usernameTo, Date timeSent) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.usernameFrom = usernameFrom;
		this.usernameTo = usernameTo;
		this.timeSent = timeSent;
	}

	public Message(String message, String usernameFrom, String usernameTo, Date timeSent) {
		super();
		this.message = message;
		this.usernameFrom = usernameFrom;
		this.usernameTo = usernameTo;
		this.timeSent = timeSent;
	}

	public Message() {
		super();
	}

}
