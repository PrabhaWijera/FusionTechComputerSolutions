package lk.ijse.Fusion.to;


import java.util.ArrayList;

public class PlaceOrder {
    private String CustomerID;
    private String OrderID;
    private ArrayList<OrderDetail> orderDetails = new ArrayList<>();

    public PlaceOrder() {
    }



    public PlaceOrder(String customerID, String orderID, ArrayList<CartDetail> cartDetails) {
        setCustomerID(customerID);
        setOrderID(orderID);
        this.setOrderDetails(orderDetails);

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

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "CustomerID='" + CustomerID + '\'' +
                ", OrderID='" + getOrderID() + '\'' +
                ", orderDetails=" + getOrderDetails() +
                '}';
    }
}
