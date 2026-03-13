public class Main_Cardeno {
    public static void main(String[] args) {

        // using the Books class by Malig
        Books book1 = new Books(); 
        book1.setTitle("Object Oriented Programming");   
        book1.setAuthor("Sir Ramon Capunpon");      
        book1.setPages(150);             
        // call behaviors
        book1.borrowBook(); 
        book1.returnBook();  
        // test invalid inputs
        book1.setPages(-50); 
        book1.setTitle("");  
        // to print book info 
        System.out.println("Book: " + book1.getTitle() + ", Pages: " + book1.getPages() + ", Available: " + book1.isAvailable());

        // using LibraryComputer class by Canillo
        LibraryComputer comp1 = new LibraryComputer();
        comp1.setUsed(true);
        comp1.setColor("Pink");
        comp1.setStatus(true);
        comp1.setPrice(5); // invalid
        comp1.setLibStatus(10); // invalid
        // to print computer info
        System.out.println("Computer used: " + comp1.getUsed() + ", Color: " + comp1.getColor() + ", Broken: " + comp1.getStatus() + ", Price: " + comp1.getPrice() + ", Library: " + comp1.getLibStatus());
    }
}