package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Customer;
import lk.ijse.Fusion.to.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryModel {
    public static boolean addDelivery(Delivery delivery) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO fusiontech.delivery VALUES (?, ?, ?, ?, ?, ?, ? ,? )";
        return CRUDutil.execute(sql, delivery.getDeliveryID(), delivery.getDriverNic(), delivery.getDriverName(), delivery.getDeliveryDate(), delivery.getArriavalTime(), delivery.getDeliveryFee(),delivery.getStetus(),delivery.getOrderID());
    }

    public static boolean remove(String DeliveryID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From delivery where DeliveryID='" + DeliveryID + "'") > 0;

    }

    public static boolean update(Delivery delivery) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update delivery set   OrderID=?, Stetus=?, DeliveryFee=?, ArriavalTime=?, DeliveryDate=? ,DriverName=?, DriverNic=? where DeliveryID=?");
        stm.setObject(1, delivery.getOrderID());
        stm.setObject(2, delivery.getStetus());
        stm.setObject(3, delivery.getDeliveryFee());
        stm.setObject(4, delivery.getArriavalTime());
        stm.setObject(5, delivery.getDeliveryDate());
        stm.setObject(6, delivery.getDriverName());
        stm.setObject(7,delivery.getDriverNic());
        stm.setObject(8,delivery.getDeliveryID());

        return  stm.executeUpdate()>0;

    }

    public static Delivery search(String deliveryID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From fusiontech.Delivery WHERE DeliveryID = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, deliveryID);

        if (resultSet.next()) {
            return new Delivery(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
        return null;
    }
}
