package lk.ijse.Fusion.to;

public class OrderDetail {
   String  OrderId;
   String ItemCode;
   int qty;
   String descriptions;
   double unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String itemCode, int qty, String descriptions, double unitPrice) {
        OrderId = orderId;
        ItemCode = itemCode;
        this.qty = qty;
        this.descriptions = descriptions;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "OrderId='" + OrderId + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                ", qty=" + qty +
                ", descriptions='" + descriptions + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
