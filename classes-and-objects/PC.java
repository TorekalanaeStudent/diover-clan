/**
 * @author canilloPC
 */
public class PC {
    
    static int pcCount = 0;
    static String socketType = "AM4";
    
    String GPUManufacturer;
    String caseColor;
    int GPUModel;
    String MOBO;
    String CPU; // am4 only
    int RAMSpeed;
    int RAMSize;
    boolean turnedON;
    
    // default constructor
    PC(){
       this.GPUManufacturer = "NVIDIA";
       this.caseColor = "Black";
       this.GPUModel = 1650;
       this.MOBO = "B450M Biostar";
       this.CPU = "Ryzen 5 5600";
       this.RAMSpeed = 3200;
       this.RAMSize = 32;
       turnedON = false;
       pcCount++;
    }

    // overloading constructor
    PC(String caseColor){
       this();
       this.caseColor = caseColor;
    }

    // overloading constructor (2)
    PC(String GPUManufacturer, int GPUModel){
       this();
       this.GPUManufacturer = GPUManufacturer;
       this.GPUModel = GPUModel;
    }

    // parameterized constructor
    PC(String GPUManufacturer, int GPUModel, String MOBO, String CPU, int RSpeed, int RSize){
       this.GPUManufacturer = GPUManufacturer;
       this.GPUModel = GPUModel;
       this.MOBO = MOBO;
       this.CPU = CPU; 
       this.RAMSpeed = RSpeed;
       this.RAMSize = RSize;
    }
    
    // =======================================
    // GETTER AND SETTERS - Behavior with parameter AND Behavior without parameter
    // =======================================
    
    // GETTERS
    public int getPcCount(){
        return this.pcCount;
    }
    
    public String getSocketType(){
        return this.socketType;
    }
    
    public String getCaseColor(){
        return this.caseColor;
    }
    
    public String getGPUManufacturer(){
        return this.GPUManufacturer;
    }
    
    public int getGPUModel(){
        return this.GPUModel;
    }
    
    public String getMOBO(){
        return this.MOBO;
    }
    
    public String getCPU(){
        return this.CPU;
    }
    
    public int getRamSpeed(){
        return this.RAMSpeed;
    }
    
    public int ramSize(){
        return this.RAMSize;
    }
    
    public boolean getPCStatus(){
        return this.turnedON;
    }
        
    // SETTERS
    
    public void setGPUManufacturer(String manufacturer){
        this.GPUManufacturer = manufacturer;
    }
    
    public void setCaseColor(String color){
        this.caseColor = color;
    }
    
    public void setGPUModel(int model){
        this.GPUModel = model;
    }
    
    public void setMOBO(String MOBO){
        this.MOBO = MOBO;
    }
    
    public void setCPU(String CPU){
        this.CPU = CPU;
    }
    
    public void setRAMSpeed(int speed){
        this.RAMSpeed = speed;
    }
    
    public void setRAMSize(int size){
        this.RAMSize = size;
    }
    
    public void openPC(boolean on){
        this.turnedON = on;
    }

    // Behavior without parameter (again)
    public void introduceSpecs(){
        System.out.println("GPU manufacturer: " + GPUManufacturer + ".");
        System.out.println("GPU model: " + GPUModel + ".");
        System.out.println("Case Color: " + caseColor + ".");
        System.out.println("Motherboard: " + MOBO + ".");
        System.out.println("CPU: " + CPU + ".");
        System.out.println("Ram Speed: " + RAMSpeed + ".");
        System.out.println("Ram Size: " + RAMSize + ".");
    }

    // Static methods
    public static void displayTotalPC(){
        System.out.println("Total PC Created: " + pcCount + ".");
    }
    
    public static void displaySocketType(){
        System.out.println("Socket Type: " + socketType + ".");
    }

    
}
