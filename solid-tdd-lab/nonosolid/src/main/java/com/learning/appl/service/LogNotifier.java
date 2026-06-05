package com.learning.appl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogNotifier — SOLID: LSP
 * Substitutes Notifier anywhere; logs to console instead of sending email.
 * Swapping from LogNotifier to EmailNotifier requires 0 changes in ProductService.
 */
public class LogNotifier implements Notifier {

    private static final Logger log = LoggerFactory.getLogger(LogNotifier.class);

    @Override
    public void notify(String message) {
        log.info("[NOTIFICATION] {}", message);
    }
}
