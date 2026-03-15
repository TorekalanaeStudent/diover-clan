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

    }
}