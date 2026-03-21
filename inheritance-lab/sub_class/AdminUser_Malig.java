package sub_class;

import parent_class.UserTypes_Caneda;

public class AdminUser_Malig extends UserTypes_Caneda {

    public AdminUser_Malig(String userName, String userCode, String userType, boolean userActivity) {
        super(userName, userCode, userType, userActivity);
    }

    public void manageSystem() {
        System.out.println("Admin is managing the system");
    }

    @Override
    public void checkUserActivity() {
        if (!getUserActivity()) {
            System.out.println("Admin is OFFLINE");
        } else {
            System.out.println("Admin is ONLINE with full access");
        }
    }
}