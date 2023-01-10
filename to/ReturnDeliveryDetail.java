package lk.ijse.Fusion.to;

public class ReturnDeliveryDetail {
    String DeliveryID;
    String ReturnDID;
    int DeliveryDate;
    String Details;

    public ReturnDeliveryDetail() {
    }

    public ReturnDeliveryDetail(String deliveryID, String returnDID, int deliveryDate, String details) {
        DeliveryID = deliveryID;
        ReturnDID = returnDID;
        DeliveryDate = deliveryDate;
        Details = details;
    }



    public String getDeliveryID() {
        return DeliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        DeliveryID = deliveryID;
    }

    public String getReturnDID() {
        return ReturnDID;
    }

    public void setReturnDID(String returnDID) {
        ReturnDID = returnDID;
    }

    public int getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(int deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    @Override
    public String toString() {
        return "ReturnDeliveryDetail{" +
                "DeliveryID='" + DeliveryID + '\'' +
                ", ReturnDID='" + ReturnDID + '\'' +
                ", DeliveryDate=" + DeliveryDate +
                ", Details='" + Details + '\'' +
                '}';
    }
}
