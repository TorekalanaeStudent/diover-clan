public class Book {
    String title;
    String author;
    double price;

    public static String store = "School Marketplace";

    public Book() {
        this.title = "I Want to Die But I Want to Eat Tteokbokki";
        this.author = "Baek Se Hee";
        this.price = 350.00;
    }

    public Book(String title) {
        this.title = title;
        this.author = "Baek Se Hee";
        this.price = 350.00;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getStore() {
        return store;
    }

}
