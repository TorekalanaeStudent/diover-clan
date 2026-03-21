package sub_class;

import parent_class.UserTypes_Caneda;

public class RegularUser_Malig extends UserTypes_Caneda {

    public RegularUser_Malig(String userName, String userCode, String userType, boolean userActivity) {
        super(userName, userCode, userType, userActivity);
    }

    public void browse() {
        System.out.println("User is browsing content");
    }

    @Override
    public void checkUserActivity() {
        if (!userActivity) {
            System.out.println("User is OFFLINE");
        } else {
            System.out.println("User is ONLINE");
        }
    }
}