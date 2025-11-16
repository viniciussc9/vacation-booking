package edu.wgu.d387_sample_code.rest;

import java.util.Locale;

public class MessageRunner {
    public static void main(String[] args) {
        Thread englishThread = new Thread(new DisplayMessage(Locale.US));
        Thread frenchThread = new Thread(new DisplayMessage(Locale.CANADA_FRENCH));

        englishThread.start();
        frenchThread.start();
    }
}
