package implementations;

import abstract_classes.Superhero_Ablis;
import interfaces.SuperheroSystem_Ablis;

public class FlyingHero_Gedoria extends Superhero_Ablis implements SuperheroSystem_Ablis {

    public FlyingHero_Gedoria() {
        super();
    }

    public FlyingHero_Gedoria(String name, int age, int speed, String ability) {
        super(name, age, speed, ability);
    }

    // What methods did you override?
    // usePower() and saveTheDay() from abstract class
    @Override
    public void usePower() {
        System.out.println(getName() + " soars through the sky using " + getAbility() + "!");
    }

    @Override
    public void saveTheDay() {
        System.out.println(getName() + " saves civilians at incredible speed!");
    }

    // performAttack() from interface
    @Override
    public void performAttack() {
        System.out.println(getName() + " performs a basic aerial attack!");
    }

    // What methods did you overload?
    // performAttack() is overloaded (with parameter)
    @Override
    public void performAttack(String target) {
        System.out.println(getName() + " launches a powerful attack on " + target + "!");
    }

    @Override
    public void performAbility() {
        System.out.println(getName() + " uses special ability: " + getAbility());
    }
}