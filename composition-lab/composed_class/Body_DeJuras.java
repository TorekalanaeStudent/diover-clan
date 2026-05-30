package composed_class;

import component_class.Earwax_Cardeno;
import component_class.Finger_Nono;
import component_class.Kulangot;

/** 
    @author @cdejuras (De Juras, Clint Norbert P.)
*/

public class Body_DeJuras{

// Attributes
    private String name;
    private int age;
    
    private Earwax_Cardeno ear;
    private Finger_Nono finger;
    private Kulangot kul;

// Default Constructor
    public Body_DeJuras(){
        name = "Seth Go";
        age = 19;
        ear = new Earwax_Cardeno(20, "Yellow", "Wet", false);
        finger = new Finger_Nono("Index", 17);
        kul = new Kulangot("Green", "Small", true);
    }

// Parameterized Constructor
    public Body_DeJuras(String name, int age, Earwax_Cardeno ear, Finger_Nono finger, Kulangot kul){
        this.name = name;
        this.age = age;
        this.ear = ear;
        this.finger = finger;
        this.kul = kul;
    }

// Setters
    public void setEar(Earwax_Cardeno ear){
        this.ear = ear;
    }

    public void setFinger(Finger_Nono finger){
        this.finger = finger;
    }

    public void setKulangot(Kulangot kul){
        this.kul = kul;
    }

// Getters
    public Earwax_Cardeno getEar(){
        return ear;
    }

    public Finger_Nono getFinger(){
        return finger;
    }

    public Kulangot getKul(){
        return kul;
    }

// Behaviors
    public void showInfo(){
        System.out.println("=== Body Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        System.out.println("\n--- Components ---");
        ear.showInfo();
        kul.describe();
    }
}
