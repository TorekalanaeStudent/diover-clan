package main_class;

import parent_class.UserTypes_Caneda;
import sub_class.AdminUser_Malig;

/*
ANSWERS:

1. What is the IS-A relationship in your program?
// This line of code shows the IS-A relationship because AdminUser_Malig is a UserTypes_Caneda
// Example: UserTypes_Caneda user = new AdminUser_Malig(...);

2. Which method was overridden?
// The method checkUserActivity() was overridden in the AdminUser_Malig class

3. What happens during dynamic binding?
// During dynamic binding, the method that gets executed is based on the actual object type,
// not the reference type. Even if the reference is UserTypes_Caneda,
// the AdminUser_Malig version of checkUserActivity() runs.

4. What methods were inherited from the parent class?
// The methods userCorrectionInputs() and checkUserActivity() were inherited from the parent class

5. What new behavior did the subclass introduce?
// The subclass introduced a new method called manageSystem()
*/

public class Main_Malig {

    public static void main(String[] args) {

        // 🔥 Dynamic Binding
        UserTypes_Caneda user = new AdminUser_Malig("Admin1", "A001", "Admin", true);

        // Calls overridden method
        user.checkUserActivity();

        // Calls inherited method
        user.userCorrectionInputs(null, "123", null, true);

        // Call subclass-specific method
        AdminUser_Malig admin = new AdminUser_Malig("Boss", "A999", "Admin", true);
        admin.manageSystem();
    }
}