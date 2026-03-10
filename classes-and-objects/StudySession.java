/*
*This class represents a study session with attributes like subject, hours, and student name.
* Created by Faye Cardeño
*/

public class StudySession {
    String subject;
    int hours;
    String studentName;

    public static String school = "National University";

    public StudySession() {
        this.subject = "Math";
        this.hours = 2;
        this.studentName = "Anonymous";
    }

    public StudySession(String subject) {
        this.subject = subject;
        this.hours = 2;
        this.studentName = "Anonymous";
    }

    public StudySession(String subject, int hours) {
        this.subject = subject;
        this.hours = hours;
        this.studentName = "Anonymous";
    }

    public StudySession(String subject, int hours, String studentName) {
        this.subject = subject;
        this.hours = hours;
        this.studentName = studentName;
    }

    public void displaySession() {
        System.out.println("Student: " + studentName);
        System.out.println("Subject: " + subject);
        System.out.println("Hours: " + hours);
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getSubject() {
        return this.subject;
    }

    public static String getSchool() {
        return school;
    }
}
