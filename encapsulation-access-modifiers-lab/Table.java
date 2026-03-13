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
        this.tableName     = tableName;
        this.tableColor    = tableColor;
        this.tableMaterial = tableMaterial;
        this.tablePrice    = tablePrice;
        this.tableWidthCm  = tableWidthCm;
        this.tableLengthCm = tableLengthCm;
        this.tableHeightCm = tableHeightCm;
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

    // SETTERS
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public void setTableColor(String tableColor) {
        this.tableColor = tableColor;
    }
    public void setTableMaterial(String tableMaterial) {
        this.tableMaterial = tableMaterial;
    }
    public void setTablePrice(double tablePrice) {
        this.tablePrice = tablePrice;
    }
    public void setTableWidthCm(double tableWidthCm) {
        this.tableWidthCm = tableWidthCm;
    }
    public void setTableLengthCm(double tableLengthCm) {
        this.tableLengthCm = tableLengthCm;
    }
    public void setTableHeightCm(double tableHeightCm) {
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

