### this is the format for teammate_interface (for implementation)

```java
package implementations.teamate_interfaces;

import interfaces.InterfaceName;

public class TeammateInterfaceName implements InterfaceName {
    
    // overriding the abstract method
    @Override
    public void startSomething(){
        System.out.println("Start your abstraction-and-polymorphism-lab NOW");
    }

    // overriding default method (optional)
    @Override
    public void honk(){
        System.out.println("honk do this lab activity b4 i see red");
    }
}
```