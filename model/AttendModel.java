package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Attendence;
import lk.ijse.Fusion.to.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendModel {


    public static boolean addAttends(Attendence attendence) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO fusiontech.attendence VALUES (?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, attendence.getAttendID(),attendence.getAttendDate(), attendence.getInTime(), attendence.getOutTime(),attendence.getStetus());

    }

    public static Attendence search(String attendID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From fusiontech.attendence   WHERE  AttendID = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, attendID);

        if (resultSet.next()) {
            return new Attendence(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
                    );
        }
        return null;

    }

    public static boolean update(Attendence attendence) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update attendence set stetus=?,OutTime=?, InTime=?, AttendDate=?   where AttendID=?");
        stm.setObject(1, attendence.getStetus());
        stm.setObject(2, attendence.getOutTime());
        stm.setObject(3, attendence.getInTime());
        stm.setObject(4, attendence.getAttendDate());
        stm.setObject(5, attendence.getAttendID());
        return  stm.executeUpdate()>0;
    }

    public static boolean remove(String AttendID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From attendence where AttendID='" + AttendID + "'") > 0;

    }
}
