    package sub_class;

    import parent_class.SubjectsTrespeces;


    public class Math_DeJuras extends SubjectsTrespeces{

    // Attribute for Math:
        protected double grade; 

    //  Default Constructor:
        public Math_DeJuras(){
            super();
            this.SubName = "Math";
            this.SubDays = "Monday";
            this.SubTeacher = "Sir Romnick Navarro Sean Ethan Obedoza Ablis II";
            this.auras = "9:00 A.M";
            this.room = 301;
            this.isEnrolled = true;
            this.grade = 75.00;
        }

    //  Parametized Constructor: 
        public Math_DeJuras(String SubName, String SubDays, String SubTeacher, String auras, int room, boolean isEnrolled){
            super(SubName, SubDays, SubTeacher, auras, room, isEnrolled);
            this.grade = 75.00;
        }
    // Overriding Method
        @Override
        public void classMessage(){
        System.out.println("Your Midterm Grade on " + SubTeacher + "'s is: " + grade);
        }
        
    /// New Method 
        public void status(){
            if(grade >= 75.00){
                System.out.println(" You passed");
            } else {
                System.out.println("See you next Semester !");
            }
        }
    // Getter :
        public double getGrade(){
            return grade;
        }
    // Setter :
        public void getGrade (double grade){
            this.grade = grade;
        }
    }