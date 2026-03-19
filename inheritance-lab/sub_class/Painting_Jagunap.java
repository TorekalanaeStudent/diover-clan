package sub_class;
import parent_class.ArtPiece_Cardeno;

public class Painting_Jagunap extends ArtPiece_Cardeno {

    protected String style;

    // default constructor
    public Painting_Cardeno() {
        super("Mona Lisa", "Leonardo da Vinci", "oil on poplar panel");
        this.style = "Renaissance";
    }

    // parameterized constructor
    public Painting_Cardeno(String title, String artist, String medium, String style) {
        super(title, artist, medium);
        this.style = style;
    }

    // NEW behavior (child-exclusive)
    public void analyzeBrushwork() {
        System.out.println(title + " features brushwork in " + style + " style.");
    }

    // overridden method
    @Override
    public void description() {
        System.out.println("[Painting] " + title + " by " + artist + 
                           ", medium: " + medium + ", style: " + style);
    }
}