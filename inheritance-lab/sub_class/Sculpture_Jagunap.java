package sub_class;
import parent_class.ArtPiece_Cardeno;

public class Sculpture_Jagunap extends ArtPiece_Cardeno {

    private String material;

    // default constructor
    public Sculpture_Cardeno() {
        super("David", "Michelangelo", "marble");
        this.material = "Carrara marble";
    }

    // parameterized constructor
    public Sculpture_Cardeno(String title, String artist, String medium, String material) {
        super(title, artist, medium);
        this.material = material;
    }

    // NEW behavior (child-exclusive)
    public void inspectMaterial() {
        System.out.println(title + " is made of " + material + ".");
    }

    // overridden method
    @Override
    public void description() {
        System.out.println("[Sculpture] " + title + " by " + artist + 
                           ", carved from: " + material);
    }
}
``