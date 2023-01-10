package lk.ijse.Fusion.to;

import java.util.ArrayList;

public class Stock {
    private String StockID;
    private String  StockDate;
    private int stockQty;
    private ArrayList<Stock> StockDetail;


    public String getStockID() {
        return StockID;
    }

    public void setStockID(String stockID) {
        StockID = stockID;
    }

    public String getStockDate() {
        return StockDate;
    }

    public void setStockDate(String stockDate) {
        StockDate = stockDate;
    }



    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }





    public Stock(String stockID, String stockDate,  int stockQty) {
       this.StockID = stockID;
       this.StockDate = stockDate;

       this.stockQty=stockQty;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" +
                "StockID='" + StockID + '\'' +
                ", StockDate=" + StockDate +

                ", stockQty=" + stockQty +

                '}';
    }



}
