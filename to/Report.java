package lk.ijse.Fusion.to;

public class Report {
    private String ReportID;
    private String EmployeeID;
    private int ReportDate;
    private String ReportType;
    private String Details;

    public Report() {
    }

    public Report(String reportID, String employeeID, int reportDate, String reportType, String details) {
        ReportID = reportID;
        EmployeeID = employeeID;
        ReportDate = reportDate;
        ReportType = reportType;
        Details = details;
    }

    public String getReportID() {
        return ReportID;
    }

    public void setReportID(String reportID) {
        ReportID = reportID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public int getReportDate() {
        return ReportDate;
    }

    public void setReportDate(int reportDate) {
        ReportDate = reportDate;
    }

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String reportType) {
        ReportType = reportType;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
    @Override
    public String toString() {
        return "Report{" +
                "ReportID='" + getReportID() + '\'' +
                ", EmployeeID='" + getEmployeeID() + '\'' +
                ", ReportDate=" + getReportDate() +
                ", ReportType='" + getReportType() + '\'' +
                ", Details='" + getDetails() + '\'' +
                '}';
    }
}
