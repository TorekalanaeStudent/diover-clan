public class Table {
 
    // private attributes
    private String tableName;
    private String tableColor;
    private String tableMaterial;
    private double tablePrice;
    private double tableWidthCm;
    private double tableLengthCm;
    private double tableHeightCm;
 
    // static attribute
    private static int totalTablesSold;
 
    // default constructor
    public Table() {
        tableName     = "ODD ATELIER";
        tableColor    = "Matte Black";
        tableMaterial = "Marble";
        tablePrice    = 12999.00;
        tableWidthCm  = 120.0;
        tableLengthCm = 35.0;
        tableHeightCm = 80.0;
        totalTablesSold++;
    }
 
    // parameterized constructor
    public Table(String tableName, String tableColor, String tableMaterial,
                 double tablePrice, double tableWidthCm, double tableLengthCm, double tableHeightCm) {
        setTableName(tableName);
        setTableColor(tableColor);
        setTableMaterial(tableMaterial);
        setTablePrice(tablePrice);
        setTableWidthCm(tableWidthCm);
        setTableLengthCm(tableLengthCm);
        setTableHeightCm(tableHeightCm);
        totalTablesSold++;
    }
 
    // GETTERS
    public String getTableName() {
        return tableName;
    }
    public String getTableColor() {
        return tableColor;
    }
    public String getTableMaterial() {
        return tableMaterial;
    }
    public double getTablePrice() {
        return tablePrice;
    }
    public double getTableWidthCm() {
        return tableWidthCm;
    }
    public double getTableLengthCm() {
        return tableLengthCm;
    }
    public double getTableHeightCm() {
        return tableHeightCm;
    }
 
    // SETTERS w validation
 
    // Validation #1
    public void setTableName(String tableName) {
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalArgumentException("Table name must not be null or empty.");
        }
        this.tableName = tableName;
    }
 
    public void setTableColor(String tableColor) {
        if (tableColor == null || tableColor.trim().isEmpty()) {
            throw new IllegalArgumentException("Table color must not be null or empty.");
        }
        this.tableColor = tableColor;
    }
 
    public void setTableMaterial(String tableMaterial) {
        if (tableMaterial == null || tableMaterial.trim().isEmpty()) {
            throw new IllegalArgumentException("Table material must not be null or empty.");
        }
        this.tableMaterial = tableMaterial;
    }
 
    // Validation #2
    public void setTablePrice(double tablePrice) {
        if (tablePrice <= 0) {
            throw new IllegalArgumentException("Table price must be greater than 0.");
        }
        this.tablePrice = tablePrice;
    }
 
    // Validation #3
    public void setTableWidthCm(double tableWidthCm) {
        if (tableWidthCm <= 0) {
            throw new IllegalArgumentException("Table width must be a positive value.");
        }
        this.tableWidthCm = tableWidthCm;
    }
 
    public void setTableLengthCm(double tableLengthCm) {
        if (tableLengthCm <= 0) {
            throw new IllegalArgumentException("Table length must be a positive value.");
        }
        this.tableLengthCm = tableLengthCm;
    }
 
    public void setTableHeightCm(double tableHeightCm) {
        if (tableHeightCm <= 0) {
            throw new IllegalArgumentException("Table height must be a positive value.");
        }
        this.tableHeightCm = tableHeightCm;
    }
 
    // BEHAVIORS
 
    // Behavior #1 - display all table info
    public void displayTableInfo() {
        System.out.println("Table Name: "  + tableName);
        System.out.println("Color: "       + tableColor);
        System.out.println("Material: "    + tableMaterial);
        System.out.println("Price: PHP "   + tablePrice);
        System.out.println("Width: "       + tableWidthCm  + " cm");
        System.out.println("Length: "      + tableLengthCm + " cm");
        System.out.println("Height: "      + tableHeightCm + " cm");
    }
 
    // Behavior #2 - display total tables sold
    public void displayTotalTablesSold() {
        System.out.println("Total Tables Sold: " + totalTablesSold);
    }
 
}