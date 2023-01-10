package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockModel {


    public static boolean addStock(Stock stock) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Stock VALUES (?, ?, ?)";
        return CRUDutil.execute(sql,stock.getStockID(),stock.getStockDate(), stock.getStockQty());

    }

    public static boolean remove(String StockID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Stock where StockID='" + StockID + "'") > 0;

    }

    public static boolean update(Stock stock) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Stock set stockQty =?,StockDate=?  where StockID=?");
        stm.setObject(3, stock.getStockID());
        stm.setObject(2, stock.getStockDate());
        stm.setObject(1, stock.getStockQty());


        return  stm.executeUpdate()>0;
        //return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Update Customer set Email=?, PhoneNumber=?, Address=? ,CustomerName=?, CustomerNIC where CustomerID=?") > 0;

    }
}
