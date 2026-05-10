public class Books {
 
    // Private attributes
    private String title;
    private String author;
    private int pages;
    private boolean available;
 
    // Static attribute
    private static int totalBooks = 0;
 
    // Default constructor
    public Books() {
        title = "Unknown";
        author = "Unknown";
        pages = 1;
        available = true;
        totalBooks++;
    }
 
    // Parameterized constructor
    public Books(String title, String author, int pages) {
        setTitle(title);
        setAuthor(author);
        setPages(pages);
        available = true;
        totalBooks++;
    }
 
    // Getter methods
    public String getTitle() {
        return title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public int getPages() {
        return pages;
    }
 
    public boolean isAvailable() {
        return available;
    }
 
    public static int getTotalBooks() {
        return totalBooks;
    }
 
    // Setter methods with validation
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Invalid title.");
        }
    }
 
    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Invalid author.");
        }
    }
 
    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            System.out.println("Pages must be greater than 0.");
        }
    }
 
    // Behavior 1
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
 
    // Behavior 2
    public void returnBook() {
        available = true;
        System.out.println("Book returned successfully.");
    }
}