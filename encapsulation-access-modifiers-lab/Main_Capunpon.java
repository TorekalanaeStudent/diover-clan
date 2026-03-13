public class Main_Capunpon {

public static void main(String[] args) {
    // Using LibraryComputer by Canillo
    LibraryComputer libComp = new LibraryComputer();
    libComp.setUsed(true);
    libComp.setColor("Lolo Mo.");
    libComp.setStatus(false);
    libComp.setStatus(false);
    libComp.setQuantity(-100);
    libComp.setQuantity(13);
    // Computer should only be used when not broken
    libComp.setStatus(false); 
    libComp.setUsed(true);

    LibraryComputer libComp2 = new LibraryComputer(); 

    // User cannot know for sure which computer is being used. 
    libComp.compDetails();

    // setStatus is vague. Cannot properly show if comp is broken or not.
    System.out.println("Computer status is " + libComp.getStatus());
    // Will print "Computer status is false." 

    libComp2.compDetails();
    //All objects are Computer #3 Multiverse? 

}

}