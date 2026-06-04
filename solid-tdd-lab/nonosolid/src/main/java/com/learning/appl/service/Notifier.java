package com.learning.appl.service;

/**
 * Notifier — SOLID: Interface Segregation Principle (ISP)
 * Small, focused interface. Clients only implement what they need.
 */
public interface Notifier {
    void notify(String message);
}
