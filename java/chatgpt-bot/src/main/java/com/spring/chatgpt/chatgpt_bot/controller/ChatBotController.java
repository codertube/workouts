package com.spring.chatgpt.chatgpt_bot.controller;

import com.spring.chatgpt.chatgpt_bot.dto.ChatGPTRequest;
import com.spring.chatgpt.chatgpt_bot.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class ChatBotController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public ChatGPTResponse chat(@RequestParam("prompt") String prompt) {
        ChatGPTRequest chatGPTRequest = new ChatGPTRequest(model, prompt);
        return restTemplate.postForObject(apiUrl, chatGPTRequest, ChatGPTResponse.class);
    }
}
