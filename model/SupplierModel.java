package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Customer;
import lk.ijse.Fusion.to.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierModel {
    public static boolean addsupplly(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO  fusiontech.suppliers VALUES (?, ?, ?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, suppliers.getSupplierID(), suppliers.getSupplierName(), suppliers.getSupplierEmail(), suppliers.getSupplierContact(), suppliers.getPrice(), suppliers.getItemCode(),suppliers.getAmount());
    }

    public static boolean remove(String SupplierID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From suppliers where SupplierID='" + SupplierID + "'") > 0;

    }

    public static boolean update(Suppliers suppliers) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update suppliers set Amount=?,ItemCode=?, Price=?, SupplierContact=? ,SupplierEmail=?, SupplierName=? where SupplierID=?");
        stm.setObject(1, suppliers.getAmount());
        stm.setObject(2, suppliers.getItemCode());
        stm.setObject(3, suppliers.getPrice());
        stm.setObject(4, suppliers.getSupplierContact());
        stm.setObject(5, suppliers.getSupplierEmail());
        stm.setObject(6, suppliers.getSupplierName());
        stm.setObject(7, suppliers.getSupplierID());
        return  stm.executeUpdate()>0;

    }


    public static Suppliers search(String supplierID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From fusiontech.suppliers WHERE SupplierID = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, supplierID);

        if (resultSet.next()) {
            return new Suppliers(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
        return null;


    }
}
