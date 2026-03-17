package sub_class;

import parent_class.UserTypes_Caneda;

// Child Class 1 of UserTypes_Caneda, created by John Kyle Obedoza

public class Employee_Obedoza extends UserTypes_Caneda{

    // Child class unique attributes
    private String employeeDepartment;

    public Employee_Obedoza (String userName, String userCode, String userType, boolean userActivity, String employeeDepartment) {
        super (userName, userCode, userType, userActivity);

        this.employeeDepartment = employeeDepartment;
    }

    // Getter
    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    // Setter
    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    // Child Specific Method
    public void displayEmployeeInfo() {
        System.out.println("===Employee Information===");
        System.out.println("Name: " + getUserName());
        System.out.println("Employee Code: "+ getUserCode());
        System.out.println("User Type: " + getUserType());
        System.out.println("Department: " + employeeDepartment);
        System.out.println("Company Log: " + (getUserActivity() ? "Online" : "Offline"));
    }

    @Override 
    public void userCorrectionInputs(String userName, String userCode, String userType, boolean userActivity) {
        if (userName == null || userCode == null || userType == null) {
            System.out.println("No Employee Record!");
        } else {
            System.out.println("Welcome back!");
        }
    }


}