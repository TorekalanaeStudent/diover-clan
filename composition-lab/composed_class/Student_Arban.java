package composed_class;

import component_class.Handkerchief_Gedoria;
import component_class.Finger_Nono;
import component_class.Kulangot;
 
 // attributes
public class Student_Arban {
    private String studentName;
    private Finger_Nono finger;
    private Handkerchief_Gedoria handkerchief;
    private Kulangot kulangot;

//constructor

public Student_Arban(String studentName, Finger_Nono finger, Handkerchief_Gedoria handkerchief, Kulangot kulangot){
    this.studentName = studentName;
    this.finger = finger;
    this.handkerchief = handkerchief;
    this.kulangot = kulangot;
}

//getters and setters

public String getStudentName(){
    return studentName;
}
public Finger_Nono getFinger(){
    return finger;
}
public Handkerchief_Gedoria getHandkerchief(){
    return handkerchief;  
}
public Kulangot getKulangot(){
    return kulangot;
}
public void setStudentName(String studentName){
    this.studentName = studentName;
}
public void setFinger(Finger_Nono finger){
  this.finger = finger;
}
public void setHandkerchief(Handkerchief_Gedoria handkerchief){
    this.handkerchief = handkerchief;
}
public void setKulangot(Kulangot kulangot){
    this.kulangot = kulangot;
}

// behavior 

public void pickNose(){
    System.out.println (studentName + " is picking their nose");
    finger.bend();
    kulangot.roll();
}
public void cleanUsingHandkerchief(){
    System.out.println(studentName + " is cleaning his nose using handkerchief");
    handkerchief.use();
    handkerchief.fold();
}
}
