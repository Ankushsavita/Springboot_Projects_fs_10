package org.geek;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to send out Mail!");

        MailHandler mailHandler = new MailHandler();
        mailHandler.sendMail();
    }
}