package com.example.messageapp.Service;


import com.example.messageapp.Model.Message;
import com.example.messageapp.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository repo;
    public Message getById(int id) {
        Message message=repo.findById(id).get();
        return message;
    }

    public Message insert(Message message) {
        repo.save(message);
        return message;
    }

    public List<Message> allDetails() {
        List<Message> messages=repo.findAll();
        return messages;
    }

    public Message update(int id, Message message) {
        Message message1= repo.findById(id).get();
        message1.setId(message.getId());
        message1.setFirstName(message.getFirstName());
        message1.setLastName(message.getLastName());
        repo.save(message1);
        return message1;
    }

    public String delete(int id) {
        repo.deleteById(id);
        return "data fetched by id is deleted";
    }
}
