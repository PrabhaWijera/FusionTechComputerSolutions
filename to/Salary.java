package lk.ijse.Fusion.to;

public class Salary {
    private String SalaryID;
    private String EmployeeID;
    private double SalaryAmount;
    private String SalaryMethod;
    private String Details;

    public Salary() {
    }

    public Salary(String salaryID, String employeeID, double salaryAmount, String salaryMethod, String details) {
       this. SalaryID = salaryID;
        this.EmployeeID = employeeID;
        this.SalaryAmount = salaryAmount;
        this.SalaryMethod = salaryMethod;
        this.Details = details;
    }

    public String getSalaryID() {
        return SalaryID;
    }

    public void setSalaryID(String salaryID) {
        SalaryID = salaryID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public double getSalaryAmount() {
        return SalaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        SalaryAmount = salaryAmount;
    }

    public String getSalaryMethod() {
        return SalaryMethod;
    }

    public void setSalaryMethod(String salaryMethod) {
        SalaryMethod = salaryMethod;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "SalaryID='" + SalaryID + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", SalaryAmount=" + SalaryAmount +
                ", SalaryMethod='" + SalaryMethod + '\'' +
                ", Details='" + Details + '\'' +
                '}';
    }
}
