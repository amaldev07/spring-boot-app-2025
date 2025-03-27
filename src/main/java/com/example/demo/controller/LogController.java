package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostMapping
    public ResponseEntity<Void> logFromUI(@RequestBody Map<String, Object> logMessage) {
        String level = (String) logMessage.get("level");
        String message = (String) logMessage.get("message");
        String timestamp = (String) logMessage.get("timestamp");
        String additionalInfo = logMessage.toString();

        // Log based on received level
        switch (level) {
            case "ERROR":
                logger.error("UI: {}, timestamp: {}, details: {}", message, timestamp, additionalInfo);
                break;
            case "WARN":
                logger.warn("UI: {}, timestamp: {}, details: {}", message, timestamp, additionalInfo);
                break;
            default:
                logger.info("UI: {}, timestamp: {}, details: {}", message, timestamp, additionalInfo);
                break;
        }

        return ResponseEntity.ok().build();
    }
}