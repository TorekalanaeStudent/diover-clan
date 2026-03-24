package component_class;


public class AppraisalSystem_Caneda{

//private attributes:
    private String nameOfItem;
    private int itemValue;
    private String userBuyerName;

//normal attributes:    
    boolean userActivity;
    boolean hasBeenAppraised;
//constructors; 

//default
public AppraisalSystem_Caneda() {
    nameOfItem = "N/A";
    itemValue = 0;
    userBuyerName = "N/A";
    userActivity = false;
}

//parameterized 
public AppraisalSystem_Caneda(String nameOfItem, int itemValue, String setUserBuyerName, boolean userActivity) {
    this.nameOfItem = nameOfItem;
    this.itemValue = itemValue;
    this.userBuyerName = userBuyerName;
    this.userActivity = userActivity;
}

//Setters

public void setNameOfItem (String nameOfItem) {
    this.nameOfItem = nameOfItem;
}

public void setItemValue (int itemValue) {
    if (itemValue <= 0 ) {
        System.out.println("User has inputed no value or wrong value");
    }
    else {
        this.itemValue = itemValue;
        System.out.println("Item Value Has Been Inputed");
    }
}

public void setUserBuyerName(String userBuyerName) {
    this.userBuyerName = userBuyerName;
    System.out.println("");
}

public void setUserActivity(boolean userActivity) {
    this.userActivity = userActivity;
}

//getters 

public String getNameItem() {
    return nameOfItem;
}

public int getItemValue() {
    return itemValue;
}
public String getUserBuyerName() {
    return userBuyerName;
}  
public boolean getUserActivity() {
    return userActivity;
}

//Behaviors 

//Behavior #1

public void itemAppraisal() {
int valueThreshold = 5000;
    if(itemValue >= valueThreshold) {
        System.out.println("Item has a value of "+itemValue+(itemValue*0.25)+" after being appraised 25 percent up its market! ");
        hasBeenAppraised = true;
    }
    else{
        System.out.println("Item has only a value of "+itemValue+" not being able to be appraised further");
        hasBeenAppraised = false;
    } 
}

public void isitemAppraised (){
    if(hasBeenAppraised) {
        System.out.println(nameOfItem + "has been appraised already");
    }
    else {
        System.out.println(nameOfItem + "has not been appraised yet");
    }
 }

}
