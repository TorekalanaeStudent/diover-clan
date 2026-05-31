package com.trespeces.demo.app.util;

// GRASP: Polymorphism - interface allows multiple launch implementations
// GRASP: Protected Variations - future launch types won't break existing code
public interface LaunchMethod {
    void execute(double cost);
    String getLaunchType();
}