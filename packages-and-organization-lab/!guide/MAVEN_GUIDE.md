## pom.xml
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.calculator</groupId>
    <artifactId>caneda-calculator</artifactId>
    <version>1.0-SNAPSHOT</version>

    <build>
        <plugins>
            <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>exec-maven-plugin</artifactId>
                    <version>3.6.3</version>
                    <configuration>
                        <mainClass>com.calculator.caneda.main.CalculatorDemo_Caneda</mainClass>
                    </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## how to run

1. compile it first (if you do any changes)
```
mvn compile exec:java
```

2. run it
```
mvn exec:java
```
