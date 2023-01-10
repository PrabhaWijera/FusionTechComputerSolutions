package lk.ijse.Fusion.to;

public class Employee {
    private String EmployeeId;
    private String EmployeeNIC;
    private String Name;
    private String Address;
    private String Email;
    private String Mobile;
    private String JobROLE;
    private String DOB;
    private String JoinDate;
    private String Gender;



    public Employee() {
    }


    public Employee(String employeeId, String employeeNIC, String name, String address, String email, String mobile, String jobROLE, String DOB, String joinDate, String gender) {
        this.EmployeeId = employeeId;
        this.EmployeeNIC = employeeNIC;
        this.Name = name;
        this.Address = address;
        this.Email = email;
        this.Mobile = mobile;
        this.JobROLE = jobROLE;
        this.DOB = DOB;
        this.JoinDate = joinDate;
        this.Gender = gender;
    }




    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeNIC() {
        return EmployeeNIC;
    }

    public void setEmployeeNIC(String employeeNIC) {
        EmployeeNIC = employeeNIC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getJobROLE() {
        return JobROLE;
    }

    public void setJobROLE(String jobROLE) {
        JobROLE = jobROLE;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(String joinDate) {
        JoinDate = joinDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", EmployeeNIC='" + EmployeeNIC + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", JobROLE='" + JobROLE + '\'' +
                ", DOB='" + DOB + '\'' +
                ", JoinDate='" + JoinDate + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
