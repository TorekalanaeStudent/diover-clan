package parent_class;

public class UserTypes_Caneda {


//Attributes
    String userName;
    String userCode;
    String userType;
    boolean userActivity;

//Default Constructor
    UserTypes_Caneda(){
        userName = "N/A";    
        userCode = "N/A";
        userType = "N/A";
        userActivity = false;
    }

//Paremeterrized Constructor 
    UserTypes_Caneda(String userName, String userCode, String userType, Boolean userActivity ){
        this.userName = userName;
        this.userCode = userCode;
        this.userType = userType;
        this.userActivity = userActivity;
     }
//Getters
    
    //Getter #1
    String getUserName() {
        return userName;
    }
    //Getter #2
    String getUserCode() {
        return userCode;
    }
    //Getter #3
    String getUserType() {
        return userType;
    }
    //Getter #4
    boolean getUserActivity() {
        return userActivity;
    }

//Setters
    
    //Setter #1
    void setUserName(String userName) {
        this.userName = userName;
    }
    void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    void setUserType(String userType) {
        this.userType = userType;
    }
    void setUserActivity(Boolean userActivity) {
        this.userActivity = userActivity;
    }

//Behaviors 
    
    //Behavior #1
    void userCorectionInputs (String userName, String userCode, String userType, Boolean userActivity) {
    //Checks if userName is empty

    if (userName == null){
        System.out.println("The User Has No Name");
        }
    else {
        System.out.println("Username has Been inplemented");
     }

    //Checks if userCode is empty
    if (userCode == null) {
         System.out.println("The User Has Inputed Invalid Code");
     }
    else {
         System.out.println("User Inputed Code");
     }

    //Checks if userType is empty
    if (userType == null) {
        System.out.println("The User Has Inputed User Type");
        }
     else {
         System.out.println("Sucessfuly Inputed User Type");

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