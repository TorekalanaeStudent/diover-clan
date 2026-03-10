public class Guitar {


    // Static Attribute
    private static String storeName = "Kyle's Music Shop";
    
    // Fields 
    private String itemModel;
    private String itemMaterial;
    private String itemCondition;
    
    // default constructor Constructor
    public Guitar (){
        this.itemModel = "Davis";
        this.itemMaterial = "Oak Wood";
        this.itemCondition = "Brand New";

    }

    // Parameterized Contrucor
    public Guitar (String model, String material, String condition){
        this.itemModel = model;
        this.itemMaterial = material;
        this.itemCondition = condition;
    }

    // Product Display 
    public void displayProduct(){
        System.out.println("Model: "+itemModel);
        System.out.println("Material: "+ itemMaterial);
        System.out.println("Condition: "+itemCondition);
    }

    public static void displayStoreName(){
        System.out.println("Store: "+storeName);
    }

    public void updateCondition(String newCondition){
        this.itemCondition = newCondition;
    }

    // Getters
    public String getModel() {
        return itemModel;
    }

    public String getMaterial(){
        return itemMaterial;
    }

    public String getCondition(){
        return itemCondition;
    }

}


