package sub_class;

import parent_class.UserTypes_Caneda;

public class GuestUser_Malig extends UserTypes_Caneda {

    // constructor
    public GuestUser_Malig(String userName, String userCode, String userType, boolean userActivity) {
        super(userName, userCode, userType, userActivity);
    }

    // new behavior
    public void viewContent() {
        System.out.println("Guest is viewing limited content");
    }

    // override method
    @Override
    public void checkUserActivity() {
        if (!getUserActivity()) {
            System.out.println("Guest is OFFLINE");
        } else {
            System.out.println("Guest is ONLINE (limited access)");
        }
    }
}