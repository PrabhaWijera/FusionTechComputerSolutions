package lk.ijse.Fusion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.model.ItemModel;
import lk.ijse.Fusion.model.OrdersModel;
import lk.ijse.Fusion.to.Employee;
import lk.ijse.Fusion.to.Item;
import lk.ijse.Fusion.to.Orders;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class OrderFormController {
    public AnchorPane OrderContext;
    public TextField orderNameTxt;
    public TextField orderIdTxt;
    public TextField qtyTxt;
    public TextField dateTxt;
    public TableView tblorderalll;
    public TableColumn colOrderId;
    public TableColumn olordername;
    public TableColumn ColItemcod;
    public TableColumn ColDate;
    public TableColumn ColQty;
    public TextField itemTxt;
    public TableColumn ColCusID;
    public TextField CusTxt;


    @FXML
    public void addOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String OrderID = orderIdTxt.getText();
        String CustomerID=CusTxt.getText();
        String OrderName = orderNameTxt .getText();
        String  OrderDate = dateTxt.getText();
        int  OrderQty = Integer.parseInt(qtyTxt.getText());


        Orders orders = new Orders(OrderID,CustomerID,OrderName,OrderDate,OrderQty);
        boolean isAdded = OrdersModel.addOrders(orders);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Order Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    }


    public void UpdateOnAction(ActionEvent actionEvent) {
        String OrderID = orderIdTxt.getText();
        String CustomerID=CusTxt.getText();

        String OrderName = orderNameTxt .getText();
        String   OrderDate = dateTxt.getText();
        int  OrderQty = Integer.parseInt(qtyTxt.getText());


        Orders orders = new Orders(OrderID,CustomerID,OrderName,OrderDate,OrderQty);

        try {
            boolean isUpdate = OrdersModel.update(orders);

            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Orders Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String OrderID = orderIdTxt.getText();
        String CustomerID=CusTxt.getText();

        String OrderName = orderNameTxt .getText();
        String  OrderDate = dateTxt.getText();
        int  OrderQty = Integer.parseInt(qtyTxt.getText());


        Orders orders = new Orders(OrderID,CustomerID,OrderName,OrderDate,OrderQty);
        try {
            boolean isDeleted = OrdersModel.remove(orderIdTxt.getText());

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void searchOnAction(ActionEvent actionEvent) {
        String  OrderID =  orderIdTxt.getText();
        try {
            Orders  orders = OrdersModel.search(orderIdTxt);
            if (orders != null) {
                fillData(orders);
                //new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    private void fillData(Orders orders) {
        orderIdTxt .setText(orders.getOrderID());
        CusTxt.setText(orders.getCustomerID());
        orderNameTxt.setText(orders.getOrderName());
        dateTxt.setText(orders.getOrderDate());
        qtyTxt.setText(String.valueOf(orders.getOrderQty()));
        orderIdTxt .setText(orders.getOrderID());

    }

    public void reloadOnAction(ActionEvent actionEvent) {
     initialize();
    }

    public void initialize() {
        colOrderId.setCellValueFactory(new PropertyValueFactory("OrderID"));
        olordername.setCellValueFactory(new PropertyValueFactory("OrderName"));
        ColDate.setCellValueFactory(new PropertyValueFactory("OrderDate"));
        ColQty.setCellValueFactory(new PropertyValueFactory("OrderQty"));
        ColCusID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
        try {
            loadAllOrders();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    private void loadAllOrders() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  fusiontech.Orders");
        ObservableList<Orders> observableList = FXCollections.observableArrayList();
        while(resultSet.next()){
            observableList.add(
                    new Orders(
                            resultSet.getString("OrderID"),
                            resultSet.getString("CustomerID"),
                            resultSet.getString("OrderName"),
                            resultSet.getString("OrderDate"),
                            resultSet.getInt("OrderQty")

                    )
            );
        }
        tblorderalll.setItems(observableList);
    }

}
