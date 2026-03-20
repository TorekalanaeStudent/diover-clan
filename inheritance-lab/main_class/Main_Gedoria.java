package main_class;

import parent_class.Appliances_Arban;
import sub_class.SmartTV_Gedoria;
import sub_class.WashingMachine_Gedoria;

public class Main_Gedoria {

    public static void main(String[] args) {

        System.out.println("First Subclass (Smart TV)");

        Appliances_Arban tv1 = new SmartTV_Gedoria("Smart TV", "Samsung", 5, false, 55, "4K");

        tv1.on();      // inherited method
        tv1.action();  // overridden method
        tv1.off();

        System.out.println();

        // Another Smart TV object
        SmartTV_Gedoria tv2 = new SmartTV_Gedoria("Smart TV", "LG", 3, true, 65, "8K");

        tv2.displaySmartTVInfo(); // subclass method
        tv2.action();

        System.out.println();

        // The 2nd Subclass
        System.out.println("Second Subclass (Washing Machine)");

        Appliances_Arban wm1 = new WashingMachine_Gedoria("Washing Machine", "Whirlpool", 4, false, 7, "Automatic");

        wm1.on();
        wm1.action(); // overridden
        wm1.off();

        System.out.println();

        WashingMachine_Gedoria wm2 = new WashingMachine_Gedoria("Washing Machine", "Panasonic", 2, true, 10, "Semi-Automatic");

        wm2.displayWashingMachineInfo();
        wm2.action();
    }
}