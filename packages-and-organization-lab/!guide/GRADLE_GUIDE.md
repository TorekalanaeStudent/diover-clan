# NOTE: CHANGE ``` <surname> ``` TO YOUR ACTUAL SURNAME <br> ``` <surname> -> canillo ``` ``` <Surname> -> Canillo ```
## build.gradle
```gradle
plugins {
    id 'java'
    id 'application'
}

group = 'com.calculator'
version = '1.0'

application {
    mainClass = 'com.calculator.<surname>.main.CalculatorDemo_<Surname>'
}
```

## switch to jvm 17:
COMMAND FOR UPDATE TO JVM 17:
```
sdk install java 17.0.9-amzn
```
COMMAND TO DEFAULT JVM 17: 
```
sdk default java 17.0.9-amzn
```

## How to run it:

### Step 1: Go to your directory
```
cd packages-and-organization-lab/surname
```

### Step 2: Build gradle
```
gradle build
```

### Step 3: Compile everything
```
gradle compile
```

### Step 4: Run Main Method
```
gradle run
```
