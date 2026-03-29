package sub_class;

import component_class.Ilong_Onte;

/** 
    @author Nono, Mary Angeline B.
*/
public class Mask_Nono extends Ilong_Onte {

    private String maskType;

    // DEFAULT CONSTRUCTOR
    public Mask_Nono(){
        super("Medium", "Yes", false); 
        setMaskType();
    }

    // PARAMETERIZED CONSTRUCTOR
    public Mask_Nono(String laki, String nakakaAmoy, boolean maySipon, String maskType){
        super(laki, nakakaAmoy, maySipon);
        setMaskType(maskType); 
    }

    public String getMaskType(){
        return maskType;
    }

    public void setMaskType(String maskType){
        this.maskType = (maskType == null || maskType.isBlank()) ? "Surgical" : maskType;
    }

    // Overloading
    public void setMaskType(){
        this.maskType = "Surgical";
    }

    //@Override 
    public void amoy(){
        if(maskType.equalsIgnoreCase("N95")){
            System.out.println("High protection! Almost no smell passes.");
        } else if(maskType.equalsIgnoreCase("Cloth")){
            System.out.println("Some smell can pass through.");
        } else{
            System.out.println("Balanced protection and smell.");
        }
    }
}