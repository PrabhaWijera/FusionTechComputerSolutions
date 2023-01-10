package lk.ijse.Fusion.to;

public class Suppliers {
    private String SupplierID;
    private String SupplierName;
    private String SupplierEmail;
    private String SupplierContact;
    private double Price;
    private String ItemCode;
    private String Amount;

    public Suppliers() {
    }

    public Suppliers(String supplierID, String supplierName, String supplierEmail, String supplierContact, double price, String itemCode, String amount) {
        this.SupplierID = supplierID;
        this.SupplierName = supplierName;
        this.SupplierEmail = supplierEmail;
        this.SupplierContact = supplierContact;
        this.Price = price;
        this.ItemCode = itemCode;
        this.Amount = amount;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        SupplierEmail = supplierEmail;
    }

    public String getSupplierContact() {
        return SupplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        SupplierContact = supplierContact;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "SupplierID='" + SupplierID + '\'' +
                ", SupplierName='" + SupplierName + '\'' +
                ", SupplierEmail='" + SupplierEmail + '\'' +
                ", SupplierContact='" + SupplierContact + '\'' +
                ", Price=" + Price +
                ", ItemCode='" + ItemCode + '\'' +
                ", Amount='" + Amount + '\'' +
                '}';
    }
}
