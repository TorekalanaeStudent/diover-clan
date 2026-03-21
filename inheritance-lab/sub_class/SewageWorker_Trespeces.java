package sub_class;

import parent_class.Person_DeJuras;

public class SewageWorker_Trespeces extends Person_DeJuras {
    // attributes
    protected String AreaAssigned;
    protected String SewageNumberID;
    protected int YearsOfService;

    // default constructor    
     public SewageWorker_Trespeces() {
        super();
        YearsOfService = 3;
        AreaAssigned = "Calamba, Laguna";
        SewageNumberID = "2024-1024067";    
    }

    // parameterized constructor
    public SewageWorker_Trespeces(String AreaAssigned, String SewageNumberID, int YearsOfService) {
        super(name, occupation, age);
        this.AreaAssigned = AreaAssigned;
        this.SewageNumberID = SewageNumberID;
        this.YearsOfService = YearsOfService;
    }

    // getters
    public String getAreaAssigned(){
        return AreaAssigned;
    }
    public String getSewageNumberID(){
        return SewageNumberID;
    }
    public int getYearsOfService(){
        return YearsOfService;
    }

    // setters
    public void setAreaAssigned(String AreaAssigned) {
        this.AreaAssigned = AreaAssigned;
    }
    public void setSewageNumberID(String SewageNumberID) {
        this.SewageNumberID = SewageNumberID;
    }
    public void setYearsOfService(int YearsOfService) {
        this.YearsOfService = YearsOfService;
    }

    // behaviours / methods
    @Override
    public void task(){ 
	    System.out.println(name + " is cleaning out the septic tank in " + AreaAssigned + ".");
	}
    public void checkExperience() {
        if (YearsOfService >= 5) {
            System.out.println(name + " is a veteran sewage worker in " + AreaAssigned + ".");
        } else {
            System.out.println(name + " is a new sewage worker still learning the ropes.");
        }
    }
} 
    
   




   
