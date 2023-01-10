package lk.ijse.Fusion.model;

import javafx.scene.control.TextField;
import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Item;
import lk.ijse.Fusion.to.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrdersModel {

    public static boolean addOrders(Orders orders) throws SQLException, ClassNotFoundException {
        System.out.println(orders.toString());
        String sql = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, orders.getOrderID(),orders.getCustomerID(), orders.getOrderName(), orders.getOrderDate(), orders.getOrderQty());
    }


    public static boolean update(Orders orders) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Orders set  CustomerID=?,    OrderQty=? ,OrderDate=?, OrderName=? where OrderID=?");
        stm.setObject(5,orders.getCustomerID());
        stm.setObject(4, orders.getOrderID());
        stm.setObject(3, orders.getOrderName());
        stm.setObject(2, orders.getOrderDate());
        stm.setObject(1, orders.getOrderQty());

        return stm.executeUpdate() > 0;
    }


    public static boolean remove(String OrderID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Orders where OrderID='" + OrderID + "'") > 0;

    }

    public static Orders search(TextField orderIdTxt) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From Orders WHERE orderIdTxt = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, orderIdTxt);

        if (resultSet.next()) {
            return new Orders(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)


            );
        }
        return null;
    }

    /* public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
         String sql = "SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1";
         ResultSet result = CRUDutil.execute(sql);

         if (result.next()) {
             return result.getString(1);
         }
 //        return generateNextOrderId(result.getString(null));
         return null;

     }*/
    public static String getOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1";
        ResultSet result = CRUDutil.execute(sql);

        if (result.next()) {
            return result.getString(1);
        }
        return null;
    }


    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String orderId = getOrderId();
        if (orderId != null) {
            String[] split = orderId.split("D0");
            int OrderID = Integer.parseInt(split[1]);
            OrderID += 1;
            return "D0" + OrderID;
        }
        return "D0001";
    }
}





