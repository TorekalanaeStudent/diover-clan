/*
class = RAM Stick product  
properties = model, speed, capacity, type, and manufacturer
stock = checks the number of RAM sticks available
attributes are in private and values can be accessed through getters and setters

Class Created by Ablis
*/

public class RamStick {
    // Attributes
    private String model;
    private int speed;// MHz
    private int capacity;// GB
    private String type;//DDR4, DDR5, etc.
    private String manufacturer;
    private boolean isAvailable;
  
    private static int stock = 0;
  
    // default constructor
    public RamStick() {
        model = "Unknown";
        speed = 0;
        capacity = 0;
        type = "Unknown";
        manufacturer = "Unknown";
        isAvailable = true;
        stock++;
      
    }
  
    // parameterized constructor
    public RamStick(String model, int speed, int capacity, String type, String manufacturer) {
        this.model = model;
        this.speed = speed;
        this.capacity = capacity;
        this.type = type;
        this.manufacturer = manufacturer;
        this.isAvailable = true;
        stock++;
    }
  
    // overloaded constructor
    public RamStick(String model, String manufacturer) {
      this.model = model;
      speed = 0;
      capacity = 0;
      type = "Unknown";
      this.manufacturer = manufacturer;
      isAvailable = true;
      stock++;
    }

    // display method
    public void displayInfo() {
      System.out.println("Model: " + model);
      System.out.println("Speed (MHz): " + speed);
      System.out.println("Capacity (GB): " + capacity);
      System.out.println("Type: " + type);
      System.out.println("Manufacturer: " + manufacturer);
      System.out.println("Available: " + isAvailable);
      System.out.println();
    }

    // method with parameters
    public void setInfo(String model, int speed, int capacity, String type, String manufacturer) {
      this.model = model;
      this.speed = speed;
      this.capacity = capacity;
      this.type = type;
      this.manufacturer = manufacturer;
  }

    // static method
    public static void displayTotalStock() {
      System.out.println("RAM Sticks Available: " + stock);
  }
  
    // getters
    public String getModel() {
      return model;
  }
    public int getSpeed() {
      return speed;
  }

    public int getCapacity() {
      return capacity;
  }
    public String getType() {
      return type;
  }
    public String getManufacturer() {
      return manufacturer;
  }
    public boolean isAvailable() {
      return isAvailable;
  }

    //setters
    public void setModel(String model) {
      this.model = model;
   }

    public void setSpeed(int speed) {
      if (speed >= 0) {
         this.speed = speed;
    } else {
        System.out.println("Invalid speed. Value must be greater than 0.");
      }
 }

    public void setCapacity(int capacity) {
      if (capacity >= 0) {
          this.capacity = capacity;
      } else {
          System.out.println("InvalidN Number. Capacity must be greater than 0.");
      }
  }

    public void setType(String type) {
      this.type = type;
  }

    public void setManufacturer(String manufacturer) {
       this.manufacturer = manufacturer;
  }

    public void setAvailable(boolean isAvailable) {
      this.isAvailable = isAvailable;
  }

}