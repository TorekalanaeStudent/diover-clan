package main_class;

import parent_class.Appliances_Arban;
import sub_class.SmartTV_Gedoria;
import sub_class.AirPurifier_Gedoria;

/*
1.) This line of code shows the IS-A relationship because a SmartTV and AirPurifier are types of Appliances:
Appliances_Arban tv1 = new SmartTV_Gedoria(...);
Appliances_Arban ap1 = new AirPurifier_Gedoria(...);

2.) This method was overridden
public void action()

3.) The reference type is Appliances_Arban, Java calls the actual method of the object:
tv1.action();

4.) The subclasses inherited the following methods from Appliances_Arban:
on()
off()
action()

5.) The subclasses introduced their own new behaviors:
SmartTV_Gedoria
displaySmartTVInfo()

AirPurifier_Gedoria
displayAirPurifierInfo()
*/

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
        System.out.println("Second Subclass (Air Purifier)");

        Appliances_Arban ap1 = new AirPurifier_Gedoria("Air Purifier", "Xiaomi", 4, false, 80, "HEPA");

        ap1.on();
        ap1.action(); // overridden
        ap1.off();

        System.out.println();

        AirPurifier_Gedoria ap2 = new AirPurifier_Gedoria("Air Purifier", "Philips", 2, true, 60, "Carbon");

        ap2.displayAirPurifierInfo();
        ap2.action();
    }
}