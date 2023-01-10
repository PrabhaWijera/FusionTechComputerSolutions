package lk.ijse.Fusion.to;

public class Warrenty {
    String WarrentyID;
    String OrderID;
    int WarrentyDate;
    String WarrentyDescription;


    public Warrenty() {
    }


    public Warrenty(String warrentyID, String orderID, int warrentyDate, String warrentyDescription) {
        this.WarrentyID = warrentyID;
        this.OrderID = orderID;
        this.WarrentyDate = warrentyDate;
        this.WarrentyDescription = warrentyDescription;
    }


    public String getWarrentyID() {
        return WarrentyID;
    }

    public void setWarrentyID(String warrentyID) {
        WarrentyID = warrentyID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public int getWarrentyDate() {
        return WarrentyDate;
    }

    public void setWarrentyDate(int warrentyDate) {
        WarrentyDate = warrentyDate;
    }

    public String getWarrentyDescription() {
        return WarrentyDescription;
    }

    public void setWarrentyDescription(String warrentyDescription) {
        WarrentyDescription = warrentyDescription;
    }

    @Override
    public String toString() {
        return "Warrenty{" +
                "WarrentyID='" + WarrentyID + '\'' +
                ", OrderID='" + OrderID + '\'' +
                ", WarrentyDate=" + WarrentyDate +
                ", WarrentyDescription='" + WarrentyDescription + '\'' +
                '}';
    }
}
