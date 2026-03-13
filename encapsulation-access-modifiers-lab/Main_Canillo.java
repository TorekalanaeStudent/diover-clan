public class Main_Canillo {
    public static void main(String[] args) {
        // Object creations:
        System.out.println("Creation of Onte's Electric Kettle Objects:");

        // default
        ElectricKettle kettle1 = new ElectricKettle();
        // parameterized constructor
        ElectricKettle kettle2 = new ElectricKettle("Philips", 2000);

        // using getters and setters:

        System.out.println("Kettle 1 brand: " + kettle1.getBrand());
        kettle2.setBrand("Panasonic");
        System.out.println("Kettle 2 brand: " + kettle2.getBrand());

        //  behaviors (1)
        System.out.println("\nKettle 1 Pouring");
        kettle1.unlockLid();
        kettle1.pourLiquid(500);

        //  behaviors (2) with validation
        System.out.println("\nKettle 2 Pouring");
        kettle2.lockLid();
        kettle2.pourLiquid(1500);

        // cant have 0 temprature
        kettle1.setTemperatureCel(0);

        System.out.println("\nCreation of Malig's Books Objects:");
        // default
        Books book1 = new Books();
        // parameterized constructor
        Books book2 = new Books("Bible", "God", 1500);
       
        // getters and setters:
        System.out.println("Using getters and setters");
        book1.setTitle("Malig's Diary");
        System.out.println("Book 1 title: " + book1.getTitle());
        System.out.println("Book 2 title: " + book2.getTitle());

        // using behaviors
        System.out.println("\nUsing behaviors (method):");
        book1.borrowBook();
        book2.borrowBook();

        // validation
        System.out.println("\nValidation Testing:");
        book1.setPages(-50);
        book2.setAuthor("");

        System.out.println("\nAll in all its good, I like it W Onte"
        + "\nSame with Malig, good code Ws");
    }
}