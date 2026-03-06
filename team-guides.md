# Github Collaboration and Java Coding Guidelines
## BSCS251A - Info Sharing Post

**This guide document explains important concepts for team collaboration using GitHub and proper coding practices in Java.**\
**It includes common GitHub commands, changelogs, pull request  practices, and naming conventions used in professional software development.**

---

Group 1
- Put things below this

---

Group 2
- Put things below this

---

Group 3
- Put things below this
  
---

Group 4
Classes (PascalCase)

PascalCase is utilized to have classes represent main objects or entities in a program. Capitalizing every word assists the programmer to identify and separate from variables and methods. This allows for an easier way to recognize that they are classes, an important function of a program.
Example: Student, LibraryManager

Interfaces (PascalCase)

Interfaces also use PascalCase as they define a specific type or capability that classes can implement. This allows loose coupling, allowing a code to use a non-class, or polymorphism, which allows the same task be done on different objects. Using the same style as classes shows that they are also reference types in Java.

Fields / Instance Variables (camelCase)

Variables are used as containers of data and use camelCase, which is a way of naming variables that starts with a lowercase letter with the next letter starting with a capital letter to distinguish variables from classes. It is used for the programmer to be able to read and know that they belong to an object and are able to store data.
Example: firstName, accountBalance, totalGrade

Methods (camelCase)
Methods are used to perform specific tasks when it is called and use camelCase to represent actions performed by the program. This starts with a lowercase letter with the next letter starting with a capital letter to distinguish itself for easier readability.
Example: calculateTotal(), printReceipt(), getRecords()

Parameters (camelCase)
Parameters follow the same style as variables because they are temporary variables used inside methods. This keeps naming consistent and easy to understand and find making it much more easier to manipulate if needed only exception being data types to the rule.                                                                                                                             Example: (String firstName, String accountBalance, Scanner in); 

Local Variables (camelCase)
Local variables also use camelCase for consistency with fields and parameters. It helps programmers quickly recognize them as variables rather than classes or constants making it viable to be manipulated if required, use cases for variables being used as temporary storage to hold data temporarily.        Example:  public static void main(String[] args)
    {
       int studentId = 000000;
    }

