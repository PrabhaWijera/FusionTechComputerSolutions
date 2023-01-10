package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalaryModel {
    public static boolean addsala(Salary salary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Salary VALUES (?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, salary.getSalaryID(),salary.getEmployeeID(), salary.getSalaryAmount(), salary.getSalaryMethod(),salary.getDetails());

    }

    public static boolean remove(String SalaryID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Salary where SalaryID='" + SalaryID + "'") > 0;

    }

    public static boolean update(Salary salary) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Salary set Details=?,SalaryMethod=?, SalaryAmount=?, EmployeeID=?   where SalaryID=?");
        stm.setObject(1, salary.getDetails());
        stm.setObject(2, salary.getSalaryMethod());
        stm.setObject(3, salary.getSalaryAmount());
        stm.setObject(4, salary.getEmployeeID());
        stm.setObject(5, salary.getSalaryID());
        return  stm.executeUpdate()>0;
    }
}
