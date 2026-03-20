package sub_class;
import parent_class.UserTypes_Caneda;
public class GuestUser_Onte extends UserTypes_Caneda {
    // Static Attribute
    private static int totalGuests;
    // Normal Attribute
    private int sessionDuration; // in minutes
    // Default Constructor
    public GuestUser_Onte() {
        super(); // calls parent default constructor
        sessionDuration = 30; // Default session duration
        totalGuests++;
    }
    // Parameterized Constructor
    public GuestUser_Onte(String userName, String userCode, String userType, boolean userActivity, int sessionDuration) {
        super(userName, userCode, userType, userActivity);
        setSessionDuration(sessionDuration); // Use setter for validation
        totalGuests++;
    }
    // Getters
    public int getSessionDuration() {
        return sessionDuration;
    }
    public static int getTotalGuests() {
        return totalGuests;
    }
    // Setters with Validation
    public void setSessionDuration(int sessionDuration) {
        if (sessionDuration <= 0) {
            System.out.println("Invalid session duration. Defaulting to 30 minutes.");
            this.sessionDuration = 30; // Default session duration
        } else {
            this.sessionDuration = sessionDuration;
        }
    }
    // Override
    @Override
    public void checkUserActivity() {
        if (userActivity) {
            System.out.println("Guest browsing for " + sessionDuration + " minutes.");
        } else {    
            System.out.println("Guest Inactive.");
        }
    }
    // New Behavior
    public void requestAccess() {
        System.out.println("Guest is requesting access.");
    }
}