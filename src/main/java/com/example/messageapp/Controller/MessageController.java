package com.example.messageapp.Controller;


import com.example.messageapp.Model.Message;
import com.example.messageapp.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageService service;

    @GetMapping("/getById/{id}")
    public Message getById(@PathVariable int id){
        Message message=service.getById(id);
        return message ;
    }
    @PostMapping("/add")
    public Message insert(@RequestBody Message message){
        Message message1=service.insert(message);
        return message1;
    }
    @GetMapping("getAll")
    public List<Message>allDetails(){
        List<Message>messages=service.allDetails();
        return messages;
    }
    @PutMapping("/update/{id}")
    public Message update(@PathVariable int id,@RequestBody Message message) {
        Message message1 = service.update(id, message);
        return message1;
    }
    @DeleteMapping("/delete/{id}")
    public  String delete(@PathVariable int id){
        String response=service.delete(id);
        return response;
    }
}