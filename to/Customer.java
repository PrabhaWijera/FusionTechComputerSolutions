package lk.ijse.Fusion.to;

import org.apache.hadoop.hive.common.classification.InterfaceAudience;

public class Customer {
    private String CustomerID;
    private String CustomerNIC;
    private String CustomerName;
    private String Address;
    private String PhoneNumber;
    private String Email;

    public Customer() {
    }

    public Customer(String customerID,  String customerNIC, String customerName, String address, String phoneNumber, String email ) {
        this.CustomerID = customerID;
        this.CustomerNIC = customerNIC;
        this.CustomerName = customerName;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.Email = email;

    }



    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {

        this.CustomerID = customerID;
    }

    public String getCustomerNIC() {
        return CustomerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.CustomerNIC = customerNIC;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
       this. CustomerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
       this. Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
       this. PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
      this.  Email = email;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", CustomerNIC='" + CustomerNIC + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
