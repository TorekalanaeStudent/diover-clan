package component_class;


public class AppraisalSystem_Caneda() {

//private attributes:
    private String nameOfItem;
    private int itemValue;
    private String userBuyerName;

//normal attributes:    
    boolean userActivity;
    boolean hasBeenAppraised;
//constructors; 

//default
public class AppraisalSystem_Caneda() {
    nameOfItem = "N/A";
    itemValue = 0;
    userBuyerName = "N/A";
    userActivity = False;
}

//parameterized 
public class AppraisalSystem_Caneda(String nameOfItem, String itemValue, String setUserBuyerName, boolean userActivity) {
    this.nameOfItem = nameOfItem;
    this.itemValue = itemValue;
    this.userBuyerName = userBuyerName;
    this.userActivity = userActivity;
}
//Setters

public String setNameOfItem (String nameOfItem) {
    this.nameOfItem = nameOfItem;
}

public int setItemValue (int itemValue) {
    if (itemValue <= 0 ) {
    System.out.println("User has inputed no value or wrong value");
    }
    else {
    this.itemValue = itemValue;
    System.out.println("Item Value Has Been Inputed");
    }
}

public String setUserBuyerName(String userBuyerName) {
    this.userBuyerName = userBuyerName;
    System.out.println("");
}

public boolean setUserActivity(boolean userActivity) {
    this.userActivity = userActivity;
}

//getters 

public void getNameItem() {
    return nameOfItem;
}

public void getItemValue() {
    return itemValue;
}
public void getUserBuyerName() {
    return userBuyerName;
}  
public void getUserActivity() {
    return userActivity;
}

//Behaviors 

//Behavior #1

public void itemAppraisal() {
int valueThreshold = 5000;
    if(itemValu >= valueThreshold) {
        System.out.println("Item has a value of "+itemValue+(itemValue*0.25)+" after being appraised 25 percent up its market! ");
        hasBeenAppraised = true;
    }
    else{
        System.out.println("Item has only a value of "+itemValue+" not being able to be appraised further");
        hasBeenAppraised = false;
    } 
}

public void isitemAppraised (){
    if(hasBennAppraised) {
        System.out.println(nameOfItem + "has been appraised already");
    }
    else {
        System.out.println(nameOfItem + "has not been appraised yet");
    }
 }

}