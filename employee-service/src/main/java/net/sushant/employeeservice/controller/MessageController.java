package net.sushant.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RefreshScope
@RestController
public class MessageController {
    
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/users/message")
    public String Message() {
        return message;
    }
    
}
