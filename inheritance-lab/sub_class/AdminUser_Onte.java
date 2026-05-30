package sub_class;

import parent_class.UserTypes_Caneda;

public class AdminUser_Onte extends UserTypes_Caneda {
    //Static Attribute 
    private static int totalAdmins;
    
    //Normal Attribute
    private String adminLevel;

    //Default Constructor
    public AdminUser_Onte() {
        super(); // calls parent default constructor

        adminLevel = "level 1"; // Default admin level
        totalAdmins++;
    }
    public AdminUser_Onte(String userName, String userCode, String userType, boolean userActivity, String adminLevel) {
        super(userName, userCode, userType, userActivity);
        setAdminLevel(adminLevel);
        totalAdmins++;
    }
    //Getters
    public String getAdminLevel() {
        return adminLevel;
    }
    public static int getTotalAdmins() {
        return totalAdmins;
    }
    //Setters with Validation
    public void setAdminLevel(String adminLevel){
        if (adminLevel == null) {
            System.out.println("Invalid admin level. Defaulting to level 1.");
            this.adminLevel = "level 1";
        } 
        else {
            if (adminLevel.trim().isEmpty()) { // Check for empty string
                System.out.println("Invalid admin level. Defaulting to level 1."); 
                this.adminLevel = "level 1";
            }
            else{
                this.adminLevel = adminLevel; // Set valid admin level
            }
        }
    }
    //Override 
    @Override
    public void checkUserActivity() {
        if (userActivity) {
            System.out.println("Admin active: managing system.");
        } else {
            System.out.println("Admin Inactive.");
        }
    }
    // New Behavior
    public void manageUsers() {
        System.out.println("Admin is managing users.");
    }
}