# Github Collaboration and Java Coding Guidelines
## BSCS251A - Info Sharing Post

**This guide document explains important concepts for team collaboration using GitHub and proper coding practices in Java.**\
**It includes common GitHub commands, changelogs, pull request  practices, and naming conventions used in professional software development.**

---

Group 1 

### Common GitHub Commands, their Functions, and Use Cases

**git checkout**

Function:
git checkout is a command used to switch between branches or restore files from another commit or branch. It changes what your working directory looks like based on the branch or commit you choose.

Use Cases:
Switching from one branch to another when working on different features.
Restoring a file to its previous version.
Viewing a previous state of the project.


**git add**

Function:
git add adds changes to the staging area. It prepares modified or new files so they can be included in the next commit.

Use Cases:
Selecting which files should be included in the next commit.
Preparing updated files before saving them permanently in the repository.


**git commit**

Function:
git commit saves the staged changes into the repository. It records a snapshot of the project at a specific point in time.

Use Cases:
Recording progress in the project.
Saving updates and improvements in the project history.
Adding messages to describe what changes were made.


**git push**

Function:
git push transfers commits from a local repository to a remote repository such as GitHub.

Use Cases:
Uploading your work to GitHub.
Sharing updates with teammates in collaborative projects.
Backing up your project online.

**git pull**

Function:
git pull retrieves changes from a remote repository and updates the local repository with those changes.

Use Cases:
Getting the latest updates from other collaborators.
Synchronizing your local project with the remote repository.


**git rebase**

Function:
git rebase reapplies commits from one branch onto another base branch. This helps maintain a cleaner and more organized commit history.

Use Cases:
Updating a feature branch with the latest changes from the main branch.
Cleaning up commit history before merging branches.

**git clone**

Function:
git clone creates a copy of a remote repository on a local machine.

Use Cases:
Downloading an existing project from GitHub.
Starting work on a repository shared by other developers.

**git status**

Function:
git status shows the current condition of the repository, including modified files and files waiting to be committed.

Use Cases:
Checking which files have been changed.
Seeing which files are staged or not yet staged.


**git branch**

Function:
git branch is used to create, list, or manage branches in a repository.

Use Cases:
Creating a new branch for developing a feature.
Viewing all existing branches in the project.

---

Group 2

**What is a Changelog?**
- *A changelog is a human-readable list of notable changes made to a project, organized by version and date. Unlike a commit history (which is technical and messy), a changelog tells the team exactly what changed and why.*

**How to Use It Properly**
- Group by Type: Use *headers* like [Added], [Fixed], and [Changed].

- Write for People: Use clear language (e.g., "Fixed login button alignment") instead of technical jargon or commit IDs.

- Newest First: Always put the latest updates at the top of the file.

**How We Use It in Teams**
- The Source of Truth: It's the one place everyone (Devs, QAs, and Managers) goes to see the current state of the project.

- PR Integration: Update the CHANGELOG.md file every time you submit a Pull Request so documentation stays in sync with the code.

- Release Notes: It makes creating "What's New" updates for stakeholders instant and effortless.

---

Group 3
The Importance of Pull Requests 
* Pull requests are more than just a "to-do" list, they are the final filter that keeps your code clean and your team in sync. At their core, they exist to review code before merging, helping catch bugs, errors, and other issues early while improving overall quality.’ 

Why need two approvers? 
* Because it adds accountability, reduces mistakes, ensures more than one perspective, and prevents teammates from always approving each other's work without a real review. This also ensures that the code is correct before it counts. In short, pull requests protect your codebase and make sure every change is right before it matters. 
  
---

Group 4 
### Classes (PascalCase)

*PascalCase* is utilized to have classes represent main objects or entities in a program. Capitalizing every word assists the programmer to identify and separate from variables and methods. This allows for an easier way to recognize that they are classes, an important function of a program.
Example: Student, LibraryManager

**Interfaces (PascalCase)**

*Interfaces* also use PascalCase as they define a specific type or capability that classes can implement. This allows loose coupling, allowing a code to use a non-class, or polymorphism, which allows the same task be done on different objects. Using the same style as classes shows that they are also reference types in Java.

Fields / Instance Variables (camelCase)

*Variables* are used as containers of data and use camelCase, which is a way of naming variables that starts with a lowercase letter with the next letter starting with a capital letter to distinguish variables from classes. It is used for the programmer to be able to read and know that they belong to an object and are able to store data.
Example: firstName, accountBalance, totalGrade

*Methods (camelCase)*
Methods are used to perform specific tasks when it is called and use camelCase to represent actions performed by the program. This starts with a lowercase letter with the next letter starting with a capital letter to distinguish itself for easier readability.
Example: calculateTotal(), printReceipt(), getRecords()

*Parameters (camelCase)*
Parameters follow the same style as variables because they are temporary variables used inside methods. This keeps naming consistent and easy to understand and find making it much more easier to manipulate if needed only exception being data types to the rule.                                                                                                              Example: (String firstName, String accountBalance, Scanner in); 

*Local Variables (camelCase)*
Local variables also use camelCase for consistency with fields and parameters. It helps programmers quickly recognize them as variables rather than classes or constants making it viable to be manipulated if required, use cases for variables being used as temporary storage to hold data temporarily.                                                               Example:  public static void main(String[] args)
    {
       int studentId = 000000;
    } 
**Overall reason these naming styles are used to improve readability and make it easy to identify what each part of the code represents just by looking at the name and making it much more easier, to debug or manipulated if error is found within the code or any changes that needs to be made.**

