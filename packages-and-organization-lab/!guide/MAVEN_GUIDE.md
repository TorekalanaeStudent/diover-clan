# NOTE: CHANGE ``` <surname> ``` TO YOUR ACTUAL SURNAME <br> ``` <surname> -> canillo ``` ``` <Surname> -> Canillo ```
## pom.xml (OPTION A)
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

## how to run (OPTION A)
### Step 1. Install Maven
+ go to your directory \
     ``` cd packages-and-organization-lab/surname ```
```
mvn clean install
```

### Step 2. compile it first (if you do any changes)
```
mvn compile exec:java
```

### Step 3. run it
```
mvn exec:java
```

---

## pom.xml (OPTION B)
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.calculator</groupId>
    <artifactId><surname>-calculator</artifactId>
    <version>1.0-SNAPSHOT</version>
</project>
```

## how to run (OPTION B)
### Step 1. Install Maven (also used for compiling)
+ go to your directory \
  ``` cd packages-and-organization-lab/surname ```
```
mvn clean install
```

### Step 2. Run it
+ go to target directory \
  ``` cd target ```
```
java -cp <surname>-calculator-1.0-SNAPSHOT.jar com.calculator.<surname>.main.CalculatorDemo_<Surname>
```
