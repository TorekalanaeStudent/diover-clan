### this is the format for interfaces

```java
package interfaces;

interface InterfaceName {
    
    // at least 1 abstract method
    // example:
    void startSomething();

    // at least 1 default method
    // example:
    default void honk(){
        System.out.println("Beep i guess");
    }
} 
```