package lk.ijse.Fusion.to;

public class OrdersItemDetail {
    private String OrderID ;
    private String ItemCode;
    private int OrderQty;
    private String Discount;



    public OrdersItemDetail(String text, String code, int qty, double unitPrice) {
    }


    public OrdersItemDetail(String orderID, String itemCode, int orderQty, String discount) {
        this.OrderID = orderID;
        this.ItemCode = itemCode;
        this.OrderQty = orderQty;
        this.Discount = discount;

    }




    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public int getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(int orderQty) {
        OrderQty = orderQty;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }




    @Override
    public String toString() {
        return "OrdersItemDetail{" +
                "OrderID='" + getOrderID() + '\'' +
                ", ItemCode='" + getItemCode() + '\'' +
                ", OrderQty=" + getOrderQty() +
                ", Discount='" + getDiscount() + '\'' +

                '}';
    }
}
