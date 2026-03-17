package parent_class;

public class SubjectsTrespeces{
    // attributes
    protected String SubName;
    protected String SubDays;
    protected String SubTeacher;
    protected String auras;
    protected int room;
    protected boolean isEnrolled;

    //default constructor
    public SubjectsTrespeces(){
        SubName = "null";
        SubDays = "null";
        SubTeacher = "null";
        auras = "null";
        room = 0;
        isEnrolled = false;
    }
 
    // constructor
    public SubjectsTrespeces (String SubName, String SubDays, String SubTeacher, String auras, int room, boolean isEnrolled) {
        this.SubName = SubName;
        this.SubDays = SubDays;
        this.SubTeacher = SubTeacher;
        this.auras = auras;
        this.room = room;
        this.isEnrolled = isEnrolled;
    }

    // getters
    public String getSubName() {
        return SubName;
    }

    public String getSubDays() {
        return SubDays;
    }

    public String getSubTeacher() {
        return SubTeacher;
    }

    public String getAuras() {
        return auras;
    }

    public int getroom() {
        return room;
    }

    public boolean getIsEnrolled() {
        return isEnrolled;
    }

    // setters
    public void setSubName(String SubName) {
        this.SubName = SubName;
    }

    public void setSubDays(String SubDays) {
        this.SubDays = SubDays;
    }

    public void setSubTeacher(String SubTeacher) {
        this.SubTeacher = SubTeacher;
    }

    public void setAuras(String auras) {
        this.auras = auras;
    }

    public void setroom(int room) {
        this.room = room;
    }

    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    // behaviours / method
    public void dropOutSub() {
            if (isEnrolled) {
            isEnrolled = false;
            System.out.println(SubName + " has been dropped successfully.");
        } else {
            System.out.println(SubName + " is not currently enrolled.");
        }
    }

   public void enrollSub() {
        if (!isEnrolled) {
            isEnrolled = true;
            System.out.println(SubName + " has been enrolled successfully.");
        } else {
            System.out.println(SubName + " is already enrolled.");
        }
    }

    public void classMessage() { // can be overridden
    	System.out.println("Mr/Ms " + SubTeacher + "'s " + SubName + " Class is starting exactly at " + auras + " in Room " + room);
    }

    public void scheduleViewer() {
        System.out.println("===== SUBJECT SCHEDULE =====");
        System.out.println("Subject Name: " + SubName);
        System.out.println("Subject Days: " + SubDays);
        System.out.println("Time: " + auras);
        System.out.println("Room: " + room);
        System.out.println("Teacher: " + SubTeacher);
        System.out.println("Enrolled: " + isEnrolled);
        System.out.println("============================");
    } 

}