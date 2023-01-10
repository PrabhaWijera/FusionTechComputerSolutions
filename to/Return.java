package lk.ijse.Fusion.to;

public class Return {
    String ReturnDID;
    String OrderID;
    String Details;

    public Return() {
    }

    public Return(String returnDID, String orderID, String details) {
        ReturnDID = returnDID;
        OrderID = orderID;
        Details = details;
    }
    public String getReturnDID() {
        return ReturnDID;
    }

    public void setReturnDID(String returnDID) {
        ReturnDID = returnDID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
    @Override
    public String toString() {
        return "Return{" +
                "ReturnDID='" + ReturnDID + '\'' +
                ", OrderID='" + OrderID + '\'' +
                ", Details='" + Details + '\'' +
                '}';
    }
}
