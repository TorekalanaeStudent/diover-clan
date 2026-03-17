package sub_class;

import parent_class.UserTypes_Caneda;

public class Student_Obedoza extends UserTypes_Caneda {
  
    // Child Specific attribute 
    private String nickName;
    private String iconColor;

    public Student_Obedoza (String userName, String userCode, String userType, boolean userActivity) {
        super();

        // Attribues for super
        this.userName = "Kyle_Obedoza";
        this.userType = "Student";
        this.userActivity = true;

        this.nickName = "KoyKoy";
        this.iconColor = "Green";
    }

    // Child Specific method 1
    public void displyNickName() {
        if (userActivity == true) {
            System.out.println(nickname + "is active!");
        } else {
            System.out.println(nickname + "is offline!");
        }
    }

    // Override parent method 
    @Override
    public void checkUserActivity() {
        if (userActivity == true) {
            System.out.println("Do not Disturb...");
        } else {
            System.out.println("Sleeping!");
        }
    }




}