package sub_class;

import component_class.Clothes_Obedoza;

/**
 * This is the Subclass
 * @author CanedaRamilJrM
 */
public class CargoPants_Caneda extends Clothes_Obedoza {

    private String clotheMaterial;

    //Constructor:

    //default
    public CargoPants_Caneda() {
      super("cargopants", "Medium Size", "Black", 1500.00);
      clotheMaterial = "Fine Leather";
    }
    //parameterized
    public CargoPants_Caneda(String clotheType, String clotheSize, String clotheColor, Double clothePrice, String clotheMaterial ) {
        super(clotheType, clotheSize, clotheColor, clothePrice);
        setClotheMaterial(clotheMaterial);
    }

    public String getClotheMaterial(){
        return clotheMaterial;
    }
    public void setClotheMaterial(String clotheMaterial){
        this.clotheMaterial = clotheMaterial;
    }

    //Overrides

    @Override
    public void describe() {
        System.out.println("Clothe Detail:");
        System.out.println("Type: " + getClotheType());
        System.out.println("Size: " + getClotheSize());
        System.out.println("Color: " + getClotheColor());
        System.out.println("Price: " + getClothePrice());
        System.out.println("Material: " +  clotheMaterial);
    }

    @Override
    public void chooseColor() {
        if (getClotheColor().equalsIgnoreCase("black")) {
            System.out.println("Buy this "+getClotheColor()+" "+getClotheType() + " that's Made out of "+clotheMaterial);
        } else {
            System.out.println("Try something else!");
        }
    }

    @Override
    public void buyClothing() {
        if (getClothePrice() <= 2000.00) {
            System.out.println("Type: "+ getClotheType());
            System.out.println("Size: " + getClotheSize());
            System.out.println("Color: " + getClotheColor());
            System.out.println("Material: " +clotheMaterial);
            System.out.println("Price: " + getClothePrice());
        } else {
            System.out.println("Too expensive!");
        }
    }











}


