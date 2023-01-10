package lk.ijse.Fusion.model;



import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.to.CartDetail;
import lk.ijse.Fusion.to.Orders;
import lk.ijse.Fusion.to.PlaceOrder;


import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderModel {

    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
       try{
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        boolean isOrderAdded = OrdersModel.addOrders(new Orders(placeOrder.getOrderID(), String.valueOf(LocalDate.now()), placeOrder.getCustomerID()));
        if (isOrderAdded) {
            boolean isUpdate = ItemModel.updateQty(placeOrder.getOrderDetails());
            if (isUpdate) {
                boolean isOrderDetailAdded = OrderDetailModel.saveOrderDetails(placeOrder.getOrderDetails());
                if (isOrderDetailAdded) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
        }
        DBConnection.getInstance().getConnection().rollback();
        return false;
    } finally {
        DBConnection.getInstance().getConnection().setAutoCommit(true);
    }
  }
}



    /*   try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = OrdersModel.addOrders(new Orders(placeOrder.getOrderID(),String.valueOf(LocalDate.now()),placeOrder.getCustomerID()));
            if (isOrderAdded) {
                for (CartDetail orderDetail : placeOrder.getOrderDetails()) {
                    ItemModel.updateQty(orderDetail.getCode(),orderDetail.getQty());
                }

                if (isUpdated) {
                   boolean isOrderDetailAdded = OrderDetailModel.saveOrderDetails(placeOrder.getOrderDetails());
                    if (isOrderDetailAdded) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    }*/