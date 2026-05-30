## make a branch:
```
packages-build-<surname>
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

