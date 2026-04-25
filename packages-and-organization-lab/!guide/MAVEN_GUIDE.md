# NOTE: CHANGE ``` <surname> ``` TO YOUR ACTUAL SURNAME <br> ``` <surname> -> canillo ``` ``` <Surname> -> Canillo ```
## pom.xml
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.calculator</groupId>
    <artifactId><surname>-calculator</artifactId>
    <version>1.0-SNAPSHOT</version>

    <build>
        <plugins>
            <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>exec-maven-plugin</artifactId>
                    <version>3.6.3</version>
                    <configuration>
                        <mainClass>com.calculator.<surname>.main.CalculatorDemo_<Surname></mainClass>
                    </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## how to run

1. compile it first (if you do any changes)
   + go to your directory ex. packages-and-organization-lab \
     ``` cd packages-and-organization-lab/surname ```
```
mvn compile exec:java
```

2. run it
```
mvn exec:java
```
