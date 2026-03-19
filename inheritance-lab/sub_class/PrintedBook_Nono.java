package sub_class;

import parent_class.Book_Jagunap;

public class PrintedBook_Nono extends Book_Jagunap {

    private static int amountOfPrintedBooks;

    private String coverType; // Hardcover or Paperback

    // Default constructor
    public PrintedBook_Nono(){
        super();

        title = "Physical Book";
        author = "Nono";
        pageCount = 200;

        coverType = "Hardcover";
        amountOfPrintedBooks++;
    }

    // Parameterized constructor
    public PrintedBook_Nono(String title, String author, int pageCount, String coverType){
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.coverType = coverType;
        amountOfPrintedBooks++;
    }

    // GETTERS:
    public String getPrintedBookTitle(){
        return this.title;
    }

    public String getPrintedBookAuthor(){
        return this.author;
    }

    public int getPrintedBookPageCount(){
        return this.pageCount;
    }

    public String getCoverType(){
        return this.coverType;
    }

    // SETTERS:
    public void setPrintedBookTitle(String newTitle){
        if(newTitle.isBlank())
            System.out.println("Printed book title can't be blank, title did not change.");
        else
            this.title = newTitle;
    }

    public void setCoverType(String newCover){
        if(newCover.isBlank())
            System.out.println("Cover type can't be blank, value did not change.");
        else
            this.coverType = newCover;
    }

    // Override method
    @Override
    public void printInfo(){
        System.out.println(title + " by " + author + " | Cover: " + coverType);
    }

    // New behavior
    public void flipPages(){
        System.out.println(title + " pages are being flipped...");
    }

    // Static method
    public static void countPrintedBooks(){
        System.out.println("The amount of printed books is: " + amountOfPrintedBooks);
    }
}