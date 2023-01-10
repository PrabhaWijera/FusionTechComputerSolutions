package lk.ijse.Fusion.tm;

public class ItemTM {
    String code;
    String description;
    double unitPrice;
    int qty;
    double total;

    public String getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public int getQty() {
        return qty;
    }
    public double getTotal() { return total; }

    public ItemTM(String code, String description, double unitPrice, int qty, double total) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total = total;
    }


}
