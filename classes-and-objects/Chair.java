public class Chair {
    //Attributes

    String model;
    String color;
    double price;
    int stock;

    // Static Attribute
    static int totalChair = 0;

    //default constructor

    Chair(){

        model = "IKEA";
        color = "Red";
        price = 1800.00;
        stock = 900;
        totalChair++;
    
    }
    //Parameterized Constructor
    Chair(String model, String color, double price, int stock){


        this.model = model;
        this.color = color;
        this.price = price;
        this.stock = stock;

        totalChair++;

    }
   //Overload Constructor
   Chair(String model, double price){

       this.model = model;
        this.color = color; 
        this.price = price;
        this.stock = 900;

        totalChair++;

   }

   //The behavior without parameters
   void displayDetails(){

   System.out.println("Model" + model);
   System.out.println("Color" + color);
   System.out.println("Price P" + price);
   System.out.println("Stock" + stock);


   }

   //Behavior with parameter
   void changeColor(String newColor){

   color=newColor;
   System.out.println(model + "Color Change to" + color);



   }
   //Static Method
   static void displayTotalChair(){

   System.out.println("Total Chair Created" + totalChair);



   }


}