package sub_class;

import parent_class.Book_Jagunap;

public class EBook_Nono extends Book_Jagunap {

    private static int amountOfEBooks;

    private double fileSize;

    // Default constructor
    public EBook_Nono(){
        super();

        title = "Java Basics";
        author = "Nono";
        pageCount = 150;

        fileSize = 4.5;
        amountOfEBooks++;
    }

    // Parameterized constructor
    public EBook_Nono(String title, String author, int pageCount, double fileSize){
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.fileSize = fileSize;
        amountOfEBooks++;
    }

    // GETTERS:
    public String getEBookTitle(){
        return this.title;
    }

    public String getEBookAuthor(){
        return this.author;
    }

    public int getEBookPageCount(){
        return this.pageCount;
    }

    public double getFileSize(){
        return this.fileSize;
    }

    // SETTERS:
    public void setEBookTitle(String newTitle){
        if(newTitle.isBlank())
            System.out.println("EBook title can't be blank, title did not change.");
        else
            this.title = newTitle;
    }

    public void setEBookAuthor(String newAuthor){
        if(newAuthor.isBlank())
            System.out.println("Author can't be blank, author did not change.");
        else
            this.author = newAuthor;
    }

    // Override method
    @Override
    public void printInfo(){
        System.out.println(title + " by " + author + " | File size: " + fileSize + "MB");
    }

    // New behavior
    public void download(){
        System.out.println(title + " is being downloaded...");
    }

    // Static method
    public static void countEBooks(){
        System.out.println("The amount of EBooks is: " + amountOfEBooks);
    }
}