package sub_class;

import parent_class.Person_DeJuras;

public class Teacher_Trespeces extends Person_DeJuras {
    // attributes
    protected String SchoolName;
    protected String Subjects;
    protected String TeacherNumberID;
    protected int YearsOfExperience;

    // default constructor    
     public Teacher_Trespeces() {
        super();
        Subjects = "Art Appreciation";
        YearsOfExperience = 6;
        SchoolName = "National University Laguna";
        TeacherNumberID = "2020-1020067";    
    }

    // parameterized constructor
    public Teacher_Trespeces(String SchoolName, String Subjects, String TeacherNumberID, int YearsOfExperience) {
        super(name, occupation, age);
        this.SchoolName = SchoolName;
        this.Subjects = Subjects;
        this.TeacherNumberID = TeacherNumberID;
        this.YearsOfExperience = YearsOfExperience;
    }

    // getters
    public String getSchoolName(){
        return SchoolName;
    }
    public String getSubjects(){
        return Subjects;
    }
    public String getTeacherNumberID(){
        return TeacherNumberID;
    }
    public int getYearsOfExperience(){
        return YearsOfExperience;
    }

    // setters
    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }
    public void setSubjects(String Subjects) {
        this.Subjects = Subjects;
    }
    public void setTeacherNumberID(String TeacherNumberID) {
        this.TeacherNumberID = TeacherNumberID;
    }
    public void setYearsOfExperience(int YearsOfExperience) {
        this.YearsOfExperience = YearsOfExperience;
    }

    // behaviours / methods
    @Override
    public void task() { 
        System.out.println(name + " is preparing a lesson plan.");
    }

    public void gradeStudents() {
        if (YearsOfExperience >= 7) {
            System.out.println(name + " is a veteran teacher and grades efficiently.");
        } else {
            System.out.println(name + " is still getting used to grading papers.");
        }
    }
} 
    
   




   
