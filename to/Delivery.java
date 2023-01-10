package lk.ijse.Fusion.to;

public class Delivery {
    private String DeliveryID;
    private String DriverNic;
    private String DriverName;
    private String DeliveryDate;
    private String ArriavalTime;
    private String DeliveryFee;
    private String Stetus;
    private String OrderID;


    public Delivery() {
    }

    public Delivery(String deliveryID, String driverNic, String driverName, String deliveryDate, String arriavalTime, String deliveryFee, String stetus, String orderID) {
       this. DeliveryID = deliveryID;
        this .DriverNic = driverNic;
        this .DriverName = driverName;
        this .DeliveryDate = deliveryDate;
        this. ArriavalTime = arriavalTime;
        this .DeliveryFee = deliveryFee;
        this. Stetus = stetus;
        this .OrderID = orderID;
    }

    public String getDeliveryID() {
        return DeliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        DeliveryID = deliveryID;
    }

    public String getDriverNic() {
        return DriverNic;
    }

    public void setDriverNic(String driverNic) {
        DriverNic = driverNic;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getArriavalTime() {
        return ArriavalTime;
    }

    public void setArriavalTime(String arriavalTime) {
        ArriavalTime = arriavalTime;
    }

    public String getDeliveryFee() {
        return DeliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        DeliveryFee = deliveryFee;
    }

    public String getStetus() {
        return Stetus;
    }

    public void setStetus(String stetus) {
        Stetus = stetus;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "DeliveryID='" + DeliveryID + '\'' +
                ", DriverNic='" + DriverNic + '\'' +
                ", DriverName='" + DriverName + '\'' +
                ", DeliveryDate='" + DeliveryDate + '\'' +
                ", ArriavalTime='" + ArriavalTime + '\'' +
                ", DeliveryFee='" + DeliveryFee + '\'' +
                ", Stetus='" + Stetus + '\'' +
                ", OrderID='" + OrderID + '\'' +
                '}';
    }
}
