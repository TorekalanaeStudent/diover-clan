/**
 * Author: Ablis, Margreleigne M.
 * Classes used by: Rajan Kurt Gedoria
 * Second Implementation CLass
 */

package implementations;

import abstract_classes.Flashlight_Gedoria;
import interfaces.LightSystem_Gedoria;

public class SpotLight_Ablis extends Flashlight_Gedoria implements LightSystem_Gedoria {
    // Attributes
    private String lightIntensity; // intensity level: Narrow, Medium, Wide
    private int lightAngle; // the angle of the spotlight (0-40)
    private boolean lightStatus; // on or off

    // default constructor
    public SpotLight_Ablis() {
        super("SpotLight A", 80);
        setModel("SpotLight A");
        setLightIntensity("Medium");
        setLightAngle(30);
        setLightStatus(false);
    }

    // parameterized constructor
    public SpotLight_Ablis(String model, int batteryLevel, String lightIntensity, int lightAngle, boolean lightStatus) {
        super(model, batteryLevel);
        setModel(model);
        setLightIntensity(lightIntensity);
        setLightAngle(lightAngle);
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
        System.out.println("Spot Light Model: " + model);
    }

    @Override
    public void turnOn() {
        this.lightStatus = true;
        System.out.println("Spot light is now ON.");
    }

    @Override
    public void turnOff() {
        this.lightStatus = false;
        System.out.println("Spot light is now OFF.");
    }

    // Getters
    public String getModel() {
        return model;
    }

    public String getLightIntensity() {
        return lightIntensity;
    }

    public int getLightAngle() {
        return lightAngle;
    }

    public boolean isLightStatus() {
        return lightStatus;
    }

    // Setters
    public void setModel(String model) {
        if (model.isBlank()) {
            System.out.println("Model cannot be blank.");
        } else {
            this.model = model;
        }
    }

    public void setLightIntensity(String LightIntensity) {
        if (LightIntensity.equalsIgnoreCase("Narrow") || LightIntensity.equalsIgnoreCase("Medium") || LightIntensity.equalsIgnoreCase("Wide")) {
            this.lightIntensity = LightIntensity;
        } else {
            System.out.println("Invalid light intensity. Please choose from: Narrow, Medium, Wide.");
        }
    }

    public void setLightAngle(int lightAngle) {
        if (lightAngle >= 0 && lightAngle <= 40) {
            this.lightAngle = lightAngle;
        } else {
            System.out.println("Invalid light angle. Please enter a value between 0 and 40.");
        }
    }

    public void setLightStatus(boolean lightStatus) {
        this.lightStatus = lightStatus;
    }

    // Overloaded describe methods
    public void describe() {
        System.out.println("Model: " + model);
        System.out.println("Intensity: " + lightIntensity);
        System.out.println("Angle: " + lightAngle);
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