## make a branch:
packages-build-<surname>

##switch to jvm 17:
COMMAND FOR UPDATE TO JVM 17:
```
sdk install java 17.0.9-amzn
```
COMMAND TO DEFAULT JVM 17: 
```
sdk default java 17.0.9-amzn
```

## structure
```
packages-and-organization-lab
 └── /surname
       ├── build.gradle // or pom.xml (maven)
       └──/src
            └──/main
                 └── /java
                       └── /com
                             └── /calculator
                                      └── /surname
                                              ├── model     OPTIONAL (data)
                                              ├── service   REQUIRED (calculator class)
                                              ├── exception REQUIRED (customized exceptions)
                                              ├── util      OPTIONAL (helper_methods)
                                              └── main      REQUIRED (demo class)
```

## How to run it:

### Step 1: Go to your surname/src/java
```
cd packages-and-organization-lab/surname/src/java
```

### Step 2: Compile everything
```
javac src/java/com/calculator/surname/*/*.java
```

### Step 3: Run Main Method
```
java com.calculator.surname.main.CalculatorDemo_Surname
```

