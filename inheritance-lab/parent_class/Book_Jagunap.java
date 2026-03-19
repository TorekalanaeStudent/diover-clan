package parent_class;

public class Book_Jagunap {

    // Attributes
    protected String title;
    protected String author;
    protected int pageCount;

    // Default constructor
    public Book_Jagunap() {
        title = "Untitled";
        author = "Unknown";
        pageCount = 0;
    }

    // Parameterized constructor
    public Book_Jagunap(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    // Behavior 1
    public void read() {
        System.out.println("Reading the book: " + title);
    }

    // Behavior 2 (can be overridden)
    public void printInfo() {
        System.out.println(title + " by " + author);
    }

    // Extra behavior
    public void openBook() {
        System.out.println("Opening the book...");
    }

}
``