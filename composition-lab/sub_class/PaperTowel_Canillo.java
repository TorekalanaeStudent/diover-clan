package sub_class;

import component_class.Tissue_Ovejera;

/** 
    @author @TorekalanaeStudent (Canillo, Diover Vincent L.)
*/
public class PaperTowel_Canillo extends Tissue_Ovejera{

    private String paperTowelType;

    // DEFAULT CONSTRUCTOR
    public PaperTowel_Canillo(){
        super("Sanicare", 100, false);
        setPaperTowelType(); // default is "Multi-ply"
    }

    // PARAMETERIZED CONSTRUCTOR
    public PaperTowel_Canillo(String brand, int sheetCount, boolean isMoist, String towelType){
        super(brand, sheetCount, isMoist);
        setPaperTowelType(towelType); // Recycled, Multi-ply, Ultra-Absorbent, Cloth | Default: Multi-ply
    }

    public String getPaperTowelType(){
        return paperTowelType;
    }

    public void setPaperTowelType(String towelType){
        // use of ternary operator
        this.paperTowelType = (towelType.isBlank() || towelType == null) ? "Multi-ply" : towelType;
    }

    // Overloading
    public void setPaperTowelType(){
        this.paperTowelType = "Multi-ply";
    }

    @Override
    public void useTissue(int amount){
        int stocks = getSheetCount();

        if(amount <= 0){
            System.out.println("You must input at least 1 tissue. You cannot use tissue defense!");
        } else if(amount > stocks){
            System.out.println("You're using more tissues than you have in stock! Please add more tissues!!");
        } else{
            setSheetCount(stocks - amount);
            if(isMoist()){
                System.out.println("The tissue is moist! Tissue shield is 75% capable of absorbing attacks but heals the wizard!");
            } else{
                System.out.println("Tissue shield is 100% capable of absorbing any attack!");
            }
        }
    }
}