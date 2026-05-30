/*
 * this class represents a study session with attributes like subject, hours, student name, and status.
 * includes behaviors to display and end a session.
 * Created by Faye Cardeño
 */

public class StudySessionEncap {

    // attributes of the class
    private String subject;
    private int hours;
    private String studentName;
    private String status;

    // static variable 
    public static String school = "National University";

    // default constructor 
    public StudySessionEncap() {
        subject = "Math";
        hours = 2;
        studentName = "Anonymous";
        status = "Active";
    }

    // parameterized constructor 
    public StudySessionEncap(String subject, int hours, String studentName) {
        setSubject(subject);  
        setHours(hours);
        setStudentName(studentName);
        status = "Active";
    }

    // getters 
    public String getSubject() {
        return subject;
    }

    public int getHours() {
        return hours;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStatus() {
        return status;
    }

    public static String getSchool() {
        return school;
    }

    // setter with validation rule
    public void setHours(int hours) {
        if(hours > 0) {
            this.hours = hours;
        }
    }
    public void setStudentName(String studentName) {
        if(studentName != null && !studentName.isEmpty()) {
            this.studentName = studentName;
        } else {
            System.out.println("Name invalid!");
        }
    }
    public void setSubject(String subject) {
        if(subject != null && !subject.isEmpty()) {
            this.subject = subject;
        } else {
            System.out.println("Subject invalid!");
        }
    }

    // behavior 1
    // is used to display the session details
    public void displaySession() {
        System.out.println("School: " + school);
        System.out.println("Student: " + studentName);
        System.out.println("Subject: " + subject);
        System.out.println("Hours: " + hours);
        System.out.println("Status: " + status);
    }

    // behavior 2
    // is used to end the session
    public void endSession() {
        status = "Finished";
    }
}