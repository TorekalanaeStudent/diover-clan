    package sub_class;

    import parent_class.SubjectsTrespeces;


    public class Science_DeJuras extends SubjectsTrespeces{

    // Attribute for Science:
        protected double midGrade; 
        protected double finGrade; 

    //  Default Constructor:
        public Science_DeJuras(){
            super();
            this.SubName = "Science";
            this.SubDays = "Tuesday";
            this.SubTeacher = "Sir Jhave Go Guillermo Trespeces Ovejera III";
            this.auras = "7:00 A.M";
            this.room = 302;
            this.isEnrolled = true;
            this.midGrade = 74.00;
            this.finGrade = 86.00;
        }

    //  Parametized Constructor: 
        public Science_DeJuras(String SubName, String SubDays, String SubTeacher, String auras, int room, boolean isEnrolled){
            super(SubName, SubDays, SubTeacher, auras, room, isEnrolled);
            this.midGrade = 2.00;
            this.finGrade = 4.00;
        }
    // Overriding Method
        @Override
        public void classMessage(){
        System.out.println("Subject: " + SubName);
        System.out.println("Teacher: " + SubTeacher);
        System.out.println("Time: " + auras);
        System.out.println("Midterm Grade: " + midGrade);
        System.out.println("Final Grade: " + finGrade);
        }
        
    /// New Method 
        public void getAverage(){
            double total = (midGrade + finGrade) / 2;
            
            if(total >= 75){
                System.out.println("rank up");
            } else {
                System.out.println("smurfing");
            }

        }
    // Getter :
        public double getMid(){
            return midGrade;
        }
        public double getFin(){
            return finGrade;
        }
    // Setter :
         public void setMid(double midGrade){
            this.midGrade = midGrade;
        }
        public void setFin(double finGrade){
            this.finGrade = finGrade;
        }
    }