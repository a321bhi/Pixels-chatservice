package com.pixels.chatservice.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.pixels.chatservice.message.Message;
import com.pixels.chatservice.service.SequenceGeneratorService;

@Component
public class MessageModelListener extends AbstractMongoEventListener<Message> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public MessageModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Message> event) {
        if (event.getSource().getMessageId() < 1) {
            event.getSource().setMessageId(sequenceGenerator.generateSequence(Message.SEQUENCE_NAME));
        }
    }


}