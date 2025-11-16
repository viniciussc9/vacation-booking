package edu.wgu.d387_sample_code.rest;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayMessage implements Runnable {

    private final Locale locale;

    public DisplayMessage(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void run() {
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);
        String message = bundle.getString("welcomeMessage");
        System.out.println(message);  // run console for test
    }
}

