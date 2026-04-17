/**
 * Author: Ablis, Margreleigne M.
 * Classes used by: Rajan Kurt Gedoria
 * First Implementation CLass
 */

package implementations;

import abstract_classes.Flashlight_Gedoria;
import interfaces.LightSystem_Gedoria;

public class StageLight_Ablis extends Flashlight_Gedoria implements LightSystem_Gedoria {
    // Attributes
    private int brightnessLevel; // how bright the stage light is (0-100)
    private String lightColor; // the color of the light (e.g., "Red", "Blue", "Green")
    private boolean lightStatus; // on or off

    // default constructor
    public StageLight_Ablis() {
        super("StageLight Pro", 100);
        setModel("StageLight Pro");
        setBrightnessLevel(100);
        setLightColor("Blue");
        setLightStatus(false);
    }

    // parameterized constructor
    public StageLight_Ablis(String model, int batteryLevel, int brightness, String lightColor, boolean lightStatus) {
        super(model, batteryLevel);
        setModel(model);
        setBrightnessLevel(brightness);
        setLightColor(lightColor);
        setLightStatus(lightStatus);
    }

    // override
    // -- from abstract class
    @Override
    public void showBatteryStatus() {
        System.out.println("Battery Level: " + batteryLevel + "%");
    }

    // -- from interface
    @Override
    public void showModel(String model) {
        System.out.println("Stage Light Model: " + model);
    }

    @Override
    public void turnOn() {
        this.lightStatus = true;
        System.out.println("Stage light is now ON.");
    }

    @Override
    public void turnOff() {
        this.lightStatus = false;
        System.out.println("Stage light is now OFF.");
    }

    // Getters
    public String getModel() {
        return model;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public String getLightColor() {
        return lightColor;
    }

    public boolean isLightStatus() {
        return lightStatus;
    }

    // Setters with Validation Rule
    public void setModel(String model) {
        if (model.isBlank()) {
            System.out.println("Invalid model name. Please enter a valid model name.");
        } else {
            this.model = model;
        }
    }

    public void setBrightnessLevel(int brightnessLevel) {
        if (brightnessLevel >= 0 && brightnessLevel <= 100) {
            this.brightnessLevel = brightnessLevel;
        } else {
            System.out.println("Invalid brightness level. Please enter a value between 0 and 100.");
        }
    }

    public void setLightColor(String lightColor) {
        if (lightColor.isBlank()) {
            System.out.println("Invalid light color. Please enter a valid color.");
        } else {
            this.lightColor = lightColor;
        }
    }

    public void setLightStatus(boolean lightStatus) {
        this.lightStatus = lightStatus;
    }

    // Overloaded describe methods
    public void describe() {
        System.out.println("Model: " + model);
        System.out.println("Brightness: " + brightnessLevel);
        System.out.println("Light color: " + lightColor);
    }

    public void describe(String title) {
        System.out.println(title);
        describe();
    }

    public void describe(String title, String description) {
        System.out.println(title);
        describe();
        System.out.println(description);
    }
}
