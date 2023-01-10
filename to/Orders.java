package lk.ijse.Fusion.to;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Orders {
    private String OrderID;
    private String CustomerID;
    private String OrderName;
    private String OrderDate;
    private int OrderQty;

    private ArrayList< OrdersItemDetail>ordersItemDetailArrayList;




    public ArrayList< OrdersItemDetail> getOrdersItemDetailArrayList() {
        return ordersItemDetailArrayList;
    }

    public void setOrdersItemDetailArrayList(ArrayList< OrdersItemDetail> ordersItemDetailArrayList) {
        this.ordersItemDetailArrayList = ordersItemDetailArrayList;
    }

    public Orders(String orderID, String s, String customerID) {
        this.OrderID = orderID;
        this.OrderDate = s;
        this.CustomerID = customerID;
    }


    public Orders(String orderID,String customerID, String orderName, String orderDate, int orderQty ) {
        this.OrderID = orderID;
        this.CustomerID=customerID;
        this.OrderName = orderName;
        this.OrderDate = orderDate;
        this.OrderQty = orderQty;

    }


    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(int orderQty) {
        OrderQty = orderQty;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "OrderID='" + OrderID + '\'' +
                ", CustomerID='" + CustomerID + '\'' +
                ", OrderName='" + OrderName + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                ", OrderQty=" + OrderQty +
                ", ordersItemDetailArrayList=" + ordersItemDetailArrayList +
                '}';
    }
}
