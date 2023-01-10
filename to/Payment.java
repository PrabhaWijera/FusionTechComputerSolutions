package lk.ijse.Fusion.to;

public class Payment {
  private String PayId;
  private String PayDate;
  private String Paymentname;



    public Payment() {
    }

    public Payment(String payId, String payDate, String paymentname ) {
        PayId = payId;
        PayDate = payDate;
        Paymentname = paymentname;

    }

    public String getPayId() {
        return PayId;
    }

    public void setPayId(String payId) {
        PayId = payId;
    }

    public String getPayDate() {
        return PayDate;
    }

    public void setPayDate(String payDate) {
        PayDate = payDate;
    }

    public String getPaymentname() {
        return Paymentname;
    }

    public void setPaymentname(String paymentname) {
        Paymentname = paymentname;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "PayId='" + PayId + '\'' +
                ", PayDate='" + PayDate + '\'' +
                ", Paymentname='" + Paymentname + '\'' +

                '}';
    }

}
