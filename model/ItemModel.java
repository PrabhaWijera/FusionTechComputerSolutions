package lk.ijse.Fusion.model;

import javafx.fxml.FXML;
import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.to.CartDetail;
import lk.ijse.Fusion.to.Item;
import lk.ijse.Fusion.to.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {

    public static ArrayList<Item> getItemList() throws SQLException, ClassNotFoundException {
        ArrayList<Item> itemArrayList = new ArrayList<>();
        ResultSet resultSet = CRUDutil.execute("select * from Item");

        while (resultSet.next()) {
            itemArrayList.add(new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.valueOf(resultSet.getString(4)), Integer.valueOf(resultSet.getString(5)), resultSet.getString(6)));
        }
        return itemArrayList;
    }


    public static Item getItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("select * from Item where code = ?", code);
        while (resultSet.next()) {
            return new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.valueOf(resultSet.getString(4)), Integer.valueOf(resultSet.getString(5)), resultSet.getString(6));
        }
        return null;
    }

    public static boolean addItem(Item item) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Item VALUES (?, ?, ?, ?, ?, ?)";
        return CRUDutil.execute(sql, item.getItemCode(), item.getItemName(), item.getItemDescription(), item.getItemPrice(), item.getQtyOnHand(), item.getItemType());
    }


    public static Item search(String itemCode) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From Item WHERE ItemCode = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, itemCode);

        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    public static boolean remove(String ItemCode) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Item where ItemCode='" + ItemCode + "'") > 0;

    }

    public static boolean update(Item item) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Item set ItemType=?, QtyOnHand=?, ItemPrice=? ,ItemDescription=?, ItemName=? where ItemCode=?");
        stm.setObject(6, item.getItemCode());
        stm.setObject(5, item.getItemName());
        stm.setObject(4, item.getItemDescription());
        stm.setObject(3, item.getItemPrice());
        stm.setObject(2, item.getQtyOnHand());
        stm.setObject(1, item.getItemType());

        return stm.executeUpdate() > 0;
        //return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Update Customer set Email=?, PhoneNumber=?, Address=? ,CustomerName=?, CustomerNIC where CustomerID=?") > 0;
    }

    @FXML
    public static ArrayList<String> loaditemIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  ItemCode FROM Item";
        ResultSet result = CRUDutil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }


    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ItemCode FROM Item";
        ResultSet result = CRUDutil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }


    public static ArrayList<String> loadItemTypes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ItemType FROM Item";
        ResultSet result = CRUDutil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }

    public static Item searchType(String ItemType) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * From Item WHERE ItemType = ? ";
        ResultSet resultSet = CRUDutil.execute(sql, ItemType);

        if (resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }


   /* public static boolean updateQty(ArrayList<CartDetail> cartDetails) {
      /*  for (CartDetail cartDetail : cartDetails) {
            if (!updateQty(new Item(cartDetail.getCode(), cartDetail.getDescription(), cartDetail.getUnitPrice(), cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }
    }
        return false;
    }*/

    public static boolean updateQty(String itemCode,int qty) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("Update Item set QtyOnHand=? where ItemCode=?");
            stm.setObject(2, itemCode);
            stm.setObject(1, qty);

        return stm.executeUpdate() > 0;
    }


    public static boolean updateQty(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Update Item set QtyOnHand=? where ItemCode=?");
        stm.setObject(2, orderDetails);
        stm.setObject(1, orderDetails);

        return stm.executeUpdate() > 0;
    }
}