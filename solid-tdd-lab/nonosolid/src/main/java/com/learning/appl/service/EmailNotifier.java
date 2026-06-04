package com.learning.appl.service;

/**
 * EmailNotifier — SOLID: OCP + LSP
 * Another Notifier implementation added without modifying existing code.
 * Simulates sending email (real SMTP wiring would go here).
 */
public class EmailNotifier implements Notifier {

    private final String recipientEmail;

    public EmailNotifier(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void notify(String message) {
        // In production: use JavaMailSender or SendGrid here
        System.out.printf("[EMAIL -> %s] %s%n", recipientEmail, message);
    }

    public String getRecipientEmail() { return recipientEmail; }
}
