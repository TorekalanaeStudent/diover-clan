package sub_class;

import parent_class.UserTypes_Caneda;

// Child Class 1 of UserTypes_Caneda, created by John Kyle Obedoza

public class Student_Obedoza extends UserTypes_Caneda {
  
    // Child Specific attribute 
    private String nickName;
    private String iconColor;

    public Student_Obedoza (String userName, String userCode, String userType, boolean userActivity, String nickName) {
        super(userName, userCode, userType, userActivity);

        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    // Child Specific method 1
    public void displayNickName() {
        if (getUserActivity()) {
            System.out.println(nickName + " is active!");
        } else {
            System.out.println(nickName + " is offline!");
        }
    }

    // Override parent method 
    @Override
    public void checkUserActivity() {
        if (getUserActivity()) {
            System.out.println("Do not Disturb...");
        } else {
            System.out.println("Sleeping!");
        }
    }




}