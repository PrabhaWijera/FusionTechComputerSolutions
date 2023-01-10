package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Customer;
import lk.ijse.Fusion.to.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {


    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql,employee.getEmployeeId(),employee.getEmployeeNIC(),employee.getName(),employee.getAddress(),employee.getEmail(),employee.getMobile(),employee.getJobROLE(),employee.getDOB(),employee.getJoinDate(),employee.getGender());
    }

    public static Employee search(String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From Employee WHERE employeeId = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, employeeId);

        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10)

            );
        }
        return null;
    }


    public static boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Employee set Gender=?, JoinDate=?, DOB=? ,JobROLE=?, Mobile=? ,Email=?,Address=?, Name=?, EmployeeNIC=? where EmployeeId=?");
        stm.setObject(1, employee.getGender());
        stm.setObject(2, employee.getJobROLE() );
        stm.setObject(3,  employee.getDOB());
        stm.setObject(4, employee.getJobROLE());
        stm.setObject(5, employee.getMobile() );
        stm.setObject(6, employee.getEmail());
        stm.setObject(7, employee.getAddress());
        stm.setObject(8, employee.getName());
        stm.setObject(9, employee.getEmployeeNIC());
        stm.setObject(10,employee.getEmployeeId());

        return  stm.executeUpdate()>0;
        //return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Update Customer set Email=?, PhoneNumber=?, Address=? ,CustomerName=?, CustomerNIC where CustomerID=?") > 0;

    }

    public static boolean remove(String EmployeeId) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Employee where EmployeeId='" + EmployeeId + "'") > 0;

    }
}
