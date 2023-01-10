package lk.ijse.Fusion.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Fusion.model.CustomerModel;
import lk.ijse.Fusion.model.ItemModel;
import lk.ijse.Fusion.model.OrdersModel;
import lk.ijse.Fusion.model.PlaceOrderModel;
import lk.ijse.Fusion.tm.PlaceOrderTM;
import lk.ijse.Fusion.to.CartDetail;
import lk.ijse.Fusion.to.Customer;
import lk.ijse.Fusion.to.Item;
import lk.ijse.Fusion.to.PlaceOrder;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    public AnchorPane pane;
    public Label lblOrderId;
    public Label lblOrderDate;
    public JFXComboBox cmbCustomerId;
    public Label lblCustomerName;
    public JFXComboBox cmbItemCode;
    public Label lblDescription;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;

    public TextField txtQty;
    public TableView<PlaceOrderTM> tblOrderCart;
    public TableColumn colItemCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colAction;
    public JFXComboBox cmbItemtype;
    public Label lblNic;
    public Label lblAddress;
    public Label lblPhoneNo;
    public Label lblEmail;
    public Label lblItemName;
    public Label lblOID;
    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();


    public void cmbItemOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbItemCode.getValue());
        try {
            Item item = ItemModel.search(code);
            fillItemFields(item);
            txtQty.requestFocus();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillItemFields(Item item) throws SQLException, ClassNotFoundException {
        lblDescription.setText(item.getItemDescription());
        lblUnitPrice.setText(String.valueOf(item.getItemPrice()));
        lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
        lblItemName.setText(item.getItemName());
    }

    private void fillCustomerFields(Customer customer) {
        lblNic.setText(customer.getCustomerNIC());
        lblPhoneNo.setText(customer.getPhoneNumber());
        lblAddress.setText(customer.getAddress());
        lblEmail.setText(customer.getEmail());

    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
        btnAddToCartOnAction(actionEvent);

    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbItemCode.getValue());
        int qty = Integer.parseInt(txtQty.getText());
        String desc = lblDescription.getText();
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = unitPrice * qty;
        Button btnDelete = new Button("Delete");

        txtQty.setText("");

        if (!obList.isEmpty()) {
            L1:
            /* check same item has been in table. If so, update that row instead of adding new row to the table */
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                if (colItemCode.getCellData(i).equals(code)) {
                    qty += (int) colQty.getCellData(i);
                    total = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblOrderCart.refresh();
                    return;
                }
            }
        }

        /* set delete button to some action before it put on obList */
        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                //  PlaceOrderTM tm = tblOrderCart.getSelectionModel().getSelectedItem();
                /*
                netTot = Double.parseDouble(txtNetTot.getText());
                netTot = netTot - tm.getTotalPrice();
                */

                tblOrderCart.getItems().removeAll(tblOrderCart.getSelectionModel().getSelectedItem());
            }
        });
        obList.add(new PlaceOrderTM(code, desc, qty, unitPrice, total, btnDelete));
        tblOrderCart.setItems(obList);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        String OrderID = lblOID.getText();
        String CustomerID = String.valueOf(cmbCustomerId.getValue());


        ArrayList<CartDetail> cartDetails = new ArrayList<>();

        //* load all cart items' to orderDetails arrayList *//*
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {//* get each row details to (PlaceOrderTm)tm in each time and add them to the orderDetails *//*
            PlaceOrderTM tm = obList.get(i);
            cartDetails.add(new CartDetail(OrderID, tm.getCode(), tm.getQty(), tm.getDescription(), tm.getUnitPrice()));
        }

        PlaceOrder placeOrder = new PlaceOrder(CustomerID, OrderID, cartDetails);
        System.out.println(placeOrder.toString());
        try {
            boolean isPlaced = PlaceOrderModel.placeOrder(placeOrder);
            if (isPlaced) {
                //* to clear table *//*
                obList.clear();
                loadNextOrderId();
                new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Order Not Placed!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void btnBackOnAction(ActionEvent actionEvent) {

    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadCustomerIds();
        loadNextOrderId();
        loadItemCodes();
        setCellValueFactory();
        loadItemType();
    }

    private void loadItemCodes() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = ItemModel.loadItemCodes();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadNextOrderId() {
        try {
            String OrderID = OrdersModel.generateNextOrderId();
//            lblOrderId.setText(OrderID);
            lblOID.setText(OrderID);
            System.out.println(OrderID);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = CustomerModel.loadCustomerIds();

            for (String id : idList) {
                observableList.add(id);

            }
            cmbCustomerId.setItems(observableList);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }

    public void cmbCusLoader(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        lblCustomerName.setText(CustomerModel.getCustomer(String.valueOf(cmbCustomerId.getValue())).getCustomerName());

        String CustomerID = String.valueOf(cmbCustomerId.getValue());
        try {
            Customer customer = CustomerModel.search(CustomerID);
            fillCustomerFields(customer);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void cmbItemtypeOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    }

    private void loadItemType() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = ItemModel.loadItemTypes();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemtype.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
