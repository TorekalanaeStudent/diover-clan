package component_class;

public class Bibig_Malig{
    //Private Attributes
private String currentState;
private int wordsPerMinute;
private boolean isBusy;

public Bibig_Malig (String currentState, int wordsPerMinute){
this.currentState = currentState;
setWordsPerMinute (wordsPerMinute);
this.isBusy = false;
 }
    
//Getters
public String getCurrentState(){
    return currentState;
 }

public int getWordsPerMinute(){
    return wordsPerMinute;
 }

public boolean isBusy(){
    return isBusy;
 }

//Setters with validation
public setWordsPerMinute(int wpm){
    if (wpm>=0){
        this.wordsPerMinute = wpm;
    } else {
        System.out.println("Invalid Speed");
    }
 }

//Behaviors
public void talk(){
    isBusy = true;
    currentState = "Talking";
    System.out.println("Bibig is Talking" + wordsPerMinute + "WPM.");
 }
public void eat(){
    isBusy = true 
    currentState = "Eating";
    System.out.println("Bibig is eating. Bawal magsalita.");
 }
public void shutUp(){
    isBusy = false;
    currentState = "Tahimik";
    System.out.println("Bibig is now quiet.");
 }

}

