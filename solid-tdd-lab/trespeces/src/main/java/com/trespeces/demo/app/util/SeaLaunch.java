package com.trespeces.demo.app.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - SeaLaunch is another implementation of LaunchMethod
// GRASP: High Cohesion - only responsible for sea launch logic
@Component("seaLaunch")
public class SeaLaunch implements LaunchMethod {

    @Override
    public void execute(double cost) {
        System.out.println("Launching missile via sea. Cost: " + cost);
    }

    @Override
    public String getLaunchType() {
        return "SEA";
    }
}