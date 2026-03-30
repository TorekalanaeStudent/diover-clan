### this is the format for teammate_abstract_class (for implementation)

```java
package implementations.teamate_abstract_class;

import abstract_class.AbstractClassname;

public class TeammateAbstractClassname extends AbstractClassName {

    // overriding abstract method makeSound
    @Override
    public void makeSound(){
        System.out.println("Canillo says to do this now please");
    }

    @Override // Optional to override concrete methods
    public void eat(){
        System.out.println("Canillo cannot eat because you're not doing this, so please do this now");
    }
}
```