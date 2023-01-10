package lk.ijse.Fusion.to;

import java.util.ArrayList;

public class Item extends ArrayList<Item> {
    private String ItemCode;
    private String ItemName;
    private String ItemDescription;
    private double ItemPrice;
    private int QtyOnHand;
    private String ItemType;


    public Item() {
    }


    public Item(String itemCode, String itemName, String itemDescription, double itemPrice, int qtyOnHand, String itemType) {
            this.ItemCode=itemCode;
            this.ItemName=itemName;
            this.ItemDescription=itemDescription;
            this.ItemPrice=itemPrice;
            this.QtyOnHand=qtyOnHand;
            this.ItemType=itemType;
    }



    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }
    @Override
    public String toString() {
        return "Item{" +
                "ItemCode='" + ItemCode + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", ItemPrice=" + ItemPrice +
                ", QtyOnHand=" + QtyOnHand +
                ", ItemType='" + ItemType + '\'' +
                '}';
    }

}
