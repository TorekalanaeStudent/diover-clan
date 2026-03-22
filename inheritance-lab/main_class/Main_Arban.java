package main_class;

import parent_class.Smartphone_Gedoria;
import sub_class.GamingPhone_Arban;
import sub_class.FilmPhone_Arban;

public class Main_Arban {
    public static void main(String[] args) {

        // Object creation
        GamingPhone_Arban gaming = new GamingPhone_Arban("iOS", true, 12, 5000);
        FilmPhone_Arban film = new FilmPhone_Arban(true, 108, 512);

        // Child specific behavior
        System.out.println("Child Specific Behavior and Overridden");

        System.out.println("\nGaming Phone Sub-class");
        gaming.displaySpecs();       // inherited + own method
        gaming.enableGamingMode();  // child-specific

        System.out.println("\nFilm Phone Sub-class");
        film.displaySpecs();        // inherited + own method
        film.enableFilmMode();      // child-specific

        // Dynamic Binding
        Smartphone_Gedoria phone;

        System.out.println("\n\nDynamic Binding Demonstration");

        // Gaming Phone
        phone = new GamingPhone_Arban("iOS", true, 16, 6000);
        // Cast needed to access subclass method
        ((GamingPhone_Arban) phone).enableGamingMode();

        // Film Phone
        phone = new FilmPhone_Arban(true, 200, 1024);
        ((FilmPhone_Arban) phone).enableFilmMode();


        /** Q&A

         1. What is the IS-A relationship in your program?
         GamingPhone_Arban and FilmPhone_Arban both IS-A Smartphone_Gedoria.
         This means both subclasses are types of smartphones.

         2. Which method was overridden?
         (Depends if you override methods in parent class like displaySpecs().)
         If overridden, displaySpecs() can be customized in each subclass.

         3. What happens during dynamic binding?
         The reference type is Smartphone_Gedoria, but the actual object is either
         GamingPhone_Arban or FilmPhone_Arban. Java decides at runtime which
         method to execute based on the object.

         4. What methods were inherited?
         Attributes like brand, model, operatingSystem, and powerStatus
         and any methods from Smartphone_Gedoria.

         5. What new behavior did the subclass introduce?
         GamingPhone_Arban → enableGamingMode()
         FilmPhone_Arban → enableFilmMode()

         */
    }
}