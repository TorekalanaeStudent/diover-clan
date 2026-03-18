package parent_class;

public class ArtPiece_Cardeno {
    // attributes 
    protected String title;
    protected String artist;
    protected String medium; 
    
    // constructor - default
    public ArtPiece_Cardeno() {
        this.title = "The Starry Night";
        this.artist = "Vincent Van Gogh";
        this.medium = "oil on canvas";
    }
    // constructor - parameterized
    public ArtPiece_Cardeno(String title, String artist, String medium) {
        this.title = title;
        this.artist = artist;
        this.medium = medium;
    }

    // behaviors
    public void display() {
        System.out.println(title + " by " + artist + " is now on display.");
    }

    public void evaluate() {
        System.out.println(title + " is being evaluated.");
    }

    public void description() { // can be overridden
        System.out.println("This art piece is titled " + title + " , created by " + artist + " using " + medium + ".");
    }
}