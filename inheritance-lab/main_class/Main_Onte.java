package main_class;
import parent_class.UserTypes_Caneda;
import sub_class.AdminUser_Onte;
import sub_class.GuestUser_Onte;

/**
 * Q&A 
 * 1. What is the IS-A relationship in your program?
 *  - Both AdminUser_Onte and GuestUser_Onte are types of UserTypes_Caneda. 
 *  - Example: An admin is a user; a guest is a user. 
 *    This shows the IS-A relationship because both AdminUser_Onte and GuestUser_Onte are child classes of UserTypes_Caneda.
 * 
 * 2. Which method was overridden?
 *  - The method checkUserActivity() was overridden in both AdminUser_Onte and GuestUser_Onte.
 * 
 * 3. What happens during dynamic binding?
 *  - When a parent reference points to a child object, Java runs the child’s overridden method at runtime.
 * 
 * 4. What methods were inherited from the parent class?
 *  - Both AdminUser_Onte and GuestUser_Onte inherited the following methods from UserTypes_Caneda.
 *  - But the private methods and constructors were not inherited.
 * 
 * 5. What new behavior did the subclass introduce?
 *  - for AdminUser_Onte, the new behavior is manageUsers() which is for admin users.
 *  - for GuestUser_Onte, the new behavior is requestAccess() which is for guest users.
 */

public class Main_Onte {
    public static void main(String[] args) {
        // Object Creation
        AdminUser_Onte admin = new AdminUser_Onte("Vince", "080808", "Admin", true, "Level 3");
        GuestUser_Onte guest = new GuestUser_Onte("Onte", "123456", "Guest", true, 45);

        // Admin User : Child Specific Behavior and Overridden Methods
        System.out.println("=== Admin User ===");
        admin.manageUsers();
        admin.checkUserActivity(); // Overridden method

        // Guest User : Child Specific Behavior and Overridden Methods
        System.out.println("\n=== Guest User ===");
        guest.requestAccess();
        guest.checkUserActivity(); // Overridden method

        // Dynamic Binding Demonstration
        System.out.println("\n=== Dynamic Binding Demonstration ===");
        UserTypes_Caneda user; // Parent class reference

        // Admin User Dynamic Binding
        user = new AdminUser_Onte("Gian", "808080", "Admin", false, "Level 2");
        user.checkUserActivity(); // Runs AdminUser_Onte's version

        // Guest User Dynamic Binding
        user = new GuestUser_Onte("Zenon", "654321", "Guest", true, 20);
        user.checkUserActivity(); // Runs GuestUser_Onte's version

        // Show total objects created for each subclass
        System.out.println("\nTotal Admins created: " + AdminUser_Onte.getTotalAdmins());
        System.out.println("Total Guests created: " + GuestUser_Onte.getTotalGuests());
    }
}