package parent_class;

public class UserTypes {


//Attributes
    String userName;
    String userCode;
    String userType;
    boolean userActivity;

//Default Constructor
    UserTypes(){
        userName = "N/A";    
        userCode = "N/A";
        userType = "N/A";
        userActivity = false;
    }

//Paremeterrized Constructor 
    UserTypes(String userName, String userCode, String userType, Boolean userActivity ){
        this.userName = userName;
        this.userCode = userCode;
        this.userType = userType;
        this.userActivity = userActivity;
     }
//Behaviors 
    
    //Behavior #1
    void userCorectionInputs () {
    //Checks if userName is empty
    if (userName == null){
        System.out.println("The User Has No Name");
        }
    else {
        System.out.println("Username has Been inplemented");
        this.userName = userName;
     }

    //Checks if userCode is empty
    if (userCode == null) {
         System.out.println("The User Has Inputed Invalid Code");
     }
    else {
         System.out.println("User Inputed Code");
         this.userCode = userCode;
     }

    //Checks if userType is empty
    if (userType == null) {
        System.out.println("The User Has Inputed User Type");
        }
     else {
         System.out.println("Sucessfuly Inputed User Type");
         this.userType = userType;
        }
    }
    //Behavior #2 
    void checkUserActivity () {
        if (userActivity == false){
            System.out.println("User Offline");
        }
        else {
            System.out.println("User Online");
        }
    }

}