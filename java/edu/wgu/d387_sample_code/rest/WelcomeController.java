package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    @GetMapping
    public List<String> getWelcomeMessages() {
        List<String> messages = new ArrayList<>();

        Thread englishThread = new Thread(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("Messages", Locale.US);
            messages.add(bundle.getString("welcomeMessage"));
        });

        Thread frenchThread = new Thread(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("Messages", Locale.CANADA_FRENCH);
            messages.add(bundle.getString("welcomeMessage"));
        });

        englishThread.start();
        frenchThread.start();

        try {
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return messages;
    }
}

