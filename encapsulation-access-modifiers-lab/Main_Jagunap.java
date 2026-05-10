// Main_Jagunap.java (created by Janelle Jagunap)
 
public class Main_Jagunap {
    public static void main(String[] args) {
        
        // Object for Nono 's class
        System.out.println("Created an object From Nono's class c\n");
        System.out.println("=== SELLER SYSTEM DEMO ===\n");
 
        // 1) Create object using default constructor
        SellerEncap n1 = new SellerEncap();
        System.out.println("Created Seller (Default):");
        n1.displaySeller();
        System.out.println();
 
        // 2) Create object using second constructor
        SellerEncap n2 = new SellerEncap("Mary Angeline Nono", "Mary's Crafts");
        System.out.println("Created Seller (Name + ShopName):");
        n2.displaySeller();
        System.out.println();
 
        // 3) Create object using main constructor
        SellerEncap n3 = new SellerEncap("Faye Cardeño", "Faye's Electronics", 4.5);
        System.out.println("Created Seller (Full Parameters):");
        n3.displaySeller();
        System.out.println();
 
        // === Getter demonstration ===
        System.out.println("Checking seller name and shop:");
        System.out.println("Name: " + n3.getName());
        System.out.println("Shop: " + n3.getShopName());
        System.out.println("Rating: " + n3.getRating() + "\n");
 
        // === Setter with validation ===
        System.out.println("Attempting to set INVALID rating (7.8)...");
        n3.setRating(7.8);   // invalid rating (should trigger validation)
        System.out.println("Rating after invalid update: " + n3.getRating() + "\n");
 
        System.out.println("Setting VALID rating (4.8)...");
        n3.setRating(4.8);
        System.out.println("New Rating: " + n3.getRating() + "\n");
 
        // === Behavior: adding products ===
        System.out.println("--- Adding Products to Seller ---");
        n3.addProduct();
        n3.addProduct();
        n3.addProduct();
        System.out.println("Products added. Current product count: " + n3.getProductCount() + "\n");
 
        // Re-display updated seller
        System.out.println("Updated Seller Info:");
        n3.displaySeller();
        System.out.println();
 
        // === Static behavior ===
        SellerEncap.printTotalSellers();

        // Object for Cardeño's class

        System.out.println("Created an object from Cardeño's class c\n");
        System.out.println("=== STUDY SESSION SYSTEM DEMO ===\n");
 
        // 1) Create object using default constructor
        StudySessionEncap f1 = new StudySessionEncap();
        System.out.println("Created Session (Default):");
        f1.displaySession();
        System.out.println();
 
        // 2) Create object using parameterized constructor
        StudySessionEncap f2 = new StudySessionEncap("Programming", 3, "Janelle");
        System.out.println("Created Session (Parameterized):");
        f2.displaySession();
        System.out.println();
 
        // === GETTERS DEMO ===
        System.out.println("Checking session details using getters:");
        System.out.println("Student: " + f2.getStudentName());
        System.out.println("Subject: " + f2.getSubject());
        System.out.println("Hours: " + f2.getHours());
        System.out.println("Status: " + f2.getStatus());
        System.out.println("School: " + StudySessionEncap.getSchool());
        System.out.println();
 
        // === VALIDATION TESTS ===
        System.out.println("Attempting to set INVALID subject (empty)...");
        f2.setSubject("");
        System.out.println("Subject after invalid update: " + f2.getSubject() + "\n");
 
        System.out.println("Attempting to set INVALID student name (null)...");
        f2.setStudentName(null);
        System.out.println("Name after invalid update: " + f2.getStudentName() + "\n");
 
        System.out.println("Attempting to set INVALID hours (-3)...");
        f2.setHours(-3);
        System.out.println("Hours after invalid update: " + f2.getHours() + "\n");
 
        // === VALID SETTER ACTION ===
        System.out.println("Setting valid hours (5)...");
        f2.setHours(5);
        System.out.println("New Hours: " + f2.getHours() + "\n");
 
        // === BEHAVIOR TESTING ===
        System.out.println("Ending study session...");
        f2.endSession();
        System.out.println("New Status: " + f2.getStatus() + "\n");
 
        // Re-display updated session
        System.out.println("Updated Session Details:");
        f2.displaySession();
    }
}