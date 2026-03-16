public class Main_DeJuras {

    public static void main(String [] args){

        //using Basketball by Arban
        // class has no behaviors
        
        Basketball bBall1 = new Basketball();
        Basketball bBall2 = new Basketball();

        //setters
        bBall1.setBrand("Wilson");
        bBall1.setColor("Orange");
        bBall1.setPrice(1500.00);
        bBall1.setStock(10);
        bBall1.setAvailable(true);

        bBall2.setBrand("Spalding");
        bBall2.setColor("Black");
        bBall2.setPrice(1000.00);
        bBall2.setStock(0);
        bBall2.setAvailable(false);

        //getters

        System.out.println("===== BALL SHOP =====");
        bBall1.displayInfo();
        System.out.println("=====================");
        bBall2.displayInfo();
        System.out.println("=====================");
        

        //using Table by Trespeces

        Table table1 = new Table();
        Table table2 = new Table();

        //Setters
        table1.setTableName("Nordic Edge Console");
        table1.setTableColor("Walnut Brown");
        table1.setTableMaterial("Solid Wood");
        table1.setTablePrice(8999.00);
        table1.setTableWidthCm(110.0);
        table1.setTableLengthCm(40.0);
        table1.setTableHeightCm(75.0);  

        table2.setTableName ("Maxima 7 Billiard Table");
        table2.setTableColor("Black");
        table2.setTableMaterial("Wood Frame with Slate");
        table2.setTablePrice(110000.00);
        table2.setTableWidthCm(140.0);
        table2.setTableLengthCm(254.0);
        table2.setTableHeightCm(80.0); 
        
        //getters
        System.out.println("====  TABLE SHOP ====");
        table1.displayTableInfo();
        table1.displayTotalTablesSold();
        System.out.println("=====================");
        table2.displayTableInfo();
        System.out.println("=====================");
        // w 
    }
}