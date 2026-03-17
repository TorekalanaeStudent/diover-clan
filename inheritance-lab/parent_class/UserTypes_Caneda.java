package parent_class;

public class UserTypes_Caneda {


//Attributes
    protected String userName;
    protected String userCode;
    protected String userType;
    protected boolean userActivity;

//Default Constructor
    public UserTypes_Caneda(){
        userName = "N/A";    
        userCode = "N/A";
        userType = "N/A";
        userActivity = false;
    }

//Paremeterized Constructor 
    public UserTypes_Caneda(String userName, String userCode, String userType, boolean userActivity ){
        this.userName = userName;
        this.userCode = userCode;
        this.userType = userType;
        this.userActivity = userActivity;
     }
//Getters
    
    //Getter #1
    public String getUserName() {
        return userName;
    }
    //Getter #2
    public String getUserCode() {
        return userCode;
    }
    //Getter #3
    public String getUserType() {
        return userType;
    }
    //Getter #4
    public boolean getUserActivity() {
        return userActivity;
    }

//Setters
    
    //Setter #1
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public void setUserActivity(boolean userActivity) {
        this.userActivity = userActivity;
    }

//Behaviors 
    
    //Behavior #1
    public void userCorrectionInputs (String userName, String userCode, String userType, boolean userActivity) {
    //Checks if userName is empty

    if (userName == null) {
        System.out.println("The User Has No Name");
        this.userName = "Unknown";
    } else {
        System.out.println("Username has been implemented");
        this.userName = userName;
    }

    if (userCode == null) {
        System.out.println("Invalid Code");
        this.userCode = "0000";
    } else {
        this.userCode = userCode;
    }

    if (userType == null) {
        System.out.println("No User Type");
        this.userType = "Guest";
    } else {
        this.userType = userType;
    }

    this.userActivity = userActivity;
    }
    
    //Behavior #2 
    public void checkUserActivity () {
        if (!userActivity){
            System.out.println("User Offline");
        }
        else {
            System.out.println("User Online");
        }
    }

}
