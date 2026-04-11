package abstract_classes;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 */

public abstract class Dama_Trespeces {
    
    // attributes
    String color;
    int position;

    // constructor
    public Dama_Trespeces(String color, int position) {
        this.color = color;
        this.position = position;
    }

    // abstract method - will be overidden
    public abstract void move();

    // concrete method
    public void display() {
        System.out.println("Piece [" + color + "] at position " + position);
    }
}