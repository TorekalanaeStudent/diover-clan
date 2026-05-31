package com.trespeces.demo.app.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - AirLaunch is one implementation of LaunchMethod
// GRASP: High Cohesion - only responsible for air launch logic
@Component("airLaunch")
public class AirLaunch implements LaunchMethod {

    @Override
    public void execute(double cost) {
        System.out.println("Launching missile via air. Cost: " + cost);
    }

    @Override
    public String getLaunchType() {
        return "AIR";
    }
}