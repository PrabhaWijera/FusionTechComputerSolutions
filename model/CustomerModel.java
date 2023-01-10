package lk.ijse.Fusion.model;

import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {


    public static ArrayList <Customer> getCustomerList() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("select * from Customer");

        ArrayList<Customer> customerArrayList = new ArrayList<>();

        while (resultSet.next()){
            customerArrayList.add(new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return customerArrayList;
    }



    public static Customer getCustomer(String CustomerID) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("select * from Customer where CustomerID = ?", CustomerID);

        if(resultSet.next()){
            return new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
        }
        return null;
    }

    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, customer.getCustomerID(), customer.getCustomerNIC(), customer.getCustomerName(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail());
    }



    public static Customer search(String CustomerID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From Customer WHERE CustomerID = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, CustomerID);

        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }


    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  CustomerID FROM Customer";
        ResultSet result = CRUDutil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static boolean remove(String CustomerID) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Customer where CustomerID='" + CustomerID + "'") > 0;
    }



    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {
       Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Customer set Email=?, PhoneNumber=?, Address=? ,CustomerName=?, CustomerNIC=? where CustomerID=?");
        stm.setObject(1, customer.getEmail());
        stm.setObject(2, customer.getPhoneNumber());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getCustomerName());
        stm.setObject(5, customer.getCustomerNIC());
        stm.setObject(6, customer.getCustomerID());

        return  stm.executeUpdate()>0;
        //return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Update Customer set Email=?, PhoneNumber=?, Address=? ,CustomerName=?, CustomerNIC where CustomerID=?") > 0;

    }
}

