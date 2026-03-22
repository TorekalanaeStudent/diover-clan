package main_class;

import parent_class.UserTypes_Caneda;
import sub_class.GuestUser_Malig;
import sub_class.RegularUser_Malig;

/*
ANSWERS:

1. What is the IS-A relationship in your program?
// GuestUser_Malig IS-A UserTypes_Caneda
// RegularUser_Malig IS-A UserTypes_Caneda

2. Which method was overridden?
// The method checkUserActivity() was overridden in both GuestUser_Malig and RegularUser_Malig

3. What happens during dynamic binding?
// Even if the reference type is UserTypes_Caneda,
// the method executed depends on the actual object type
// (GuestUser_Malig or RegularUser_Malig)

4. What methods were inherited from the parent class?
// userCorrectionInputs() and checkUserActivity()

5. What new behavior did the subclass introduce?
// GuestUser_Malig -> viewContent()
// RegularUser_Malig -> browse()
*/

public class Main_Malig {

    public static void main(String[] args) {

        // Dynamic Binding
        UserTypes_Caneda u1 = new GuestUser_Malig("Guest1", "G001", "Guest", true);
        UserTypes_Caneda u2 = new RegularUser_Malig("User1", "U001", "User", false);

        // Overridden methods
        u1.checkUserActivity();
        u2.checkUserActivity();

        // Inherited method
        u1.userCorrectionInputs(null, "123", null, true);

        // Subclass-specific methods
        GuestUser_Malig guest = new GuestUser_Malig("Visitor", "G999", "Guest", true);
        guest.viewContent();

        RegularUser_Malig user = new RegularUser_Malig("Member", "U999", "User", true);
        user.browse();
    }
}