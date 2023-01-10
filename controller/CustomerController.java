package lk.ijse.Fusion.controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.Util.Navigation;
import lk.ijse.Fusion.Util.Routes;
import lk.ijse.Fusion.model.CustomerModel;
import lk.ijse.Fusion.to.Customer;


import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static lk.ijse.Fusion.model.CustomerModel.search;

public class CustomerController {



    @FXML
    public TextField CustomerlDTxt;

    public AnchorPane pane;
    @FXML
    public TextField addressTxt;
    @FXML
    public TableView<Customer> tblCus;

    @FXML
    public TextField CustomerNameTxt;

    @FXML

    public TextField nicTxt;

    @FXML
    public TextField phoneTxt;

    @FXML
    public TextField emailTxt;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColPhone;
    public TableColumn ColCusID;
    public TableColumn ColNic;
    public TableColumn ColEmail;
    public AnchorPane CusPane;


    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {
        String id = CustomerlDTxt.getText();
        try {
            Customer customer = CustomerModel.search(id);
            if (customer != null) {
                fillData(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(Customer customer) {
        CustomerlDTxt.setText(customer.getCustomerID());
        nicTxt.setText(customer.getCustomerNIC());
        CustomerNameTxt.setText(customer.getCustomerName());
        addressTxt.setText(customer.getAddress());
        phoneTxt.setText(customer.getPhoneNumber());
        emailTxt.setText(customer.getEmail());
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String CustomerID = CustomerlDTxt.getText();
        String CustomerNIC = nicTxt.getText();
        String CustomerName = CustomerNameTxt.getText();
        String Address = addressTxt.getText();
        String PhoneNumber = phoneTxt.getText();
        String Email = emailTxt.getText();


        Customer customer = new Customer(CustomerID, CustomerNIC, CustomerName, Address, PhoneNumber, Email);
        try {
            boolean isUpdate = CustomerModel.update(customer);

            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        CustomerlDTxt.clear();nicTxt.clear();CustomerNameTxt.clear();addressTxt.clear();phoneTxt.clear();emailTxt.clear();
    }


    public void DeleteOnAction(ActionEvent actionEvent) {
        String CustomerID = CustomerlDTxt.getText();
        String CustomerNIC = nicTxt.getText();
        String CustomerName = CustomerNameTxt.getText();
        String Address = addressTxt.getText();
        String PhoneNumber = phoneTxt.getText();
        String Email = emailTxt.getText();


        Customer customer = new Customer(CustomerID, CustomerNIC, CustomerName, Address, PhoneNumber, Email);
        try {
            boolean isDeleted = CustomerModel.remove(CustomerlDTxt.getText());

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        CustomerlDTxt.clear();nicTxt.clear();CustomerNameTxt.clear();addressTxt.clear();phoneTxt.clear();emailTxt.clear();
    }


    public void searchOnAction(ActionEvent actionEvent) {
        String CustomerID = CustomerlDTxt.getText();
        try {
            Customer customer = CustomerModel.search(CustomerID);
            if (customer != null) {
                fillData(customer);
                //new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void AddOnAction(ActionEvent actionEvent) {
        String CustomerID = CustomerlDTxt.getText();
        String CustomerNIC = nicTxt.getText();
        String CustomerName = CustomerNameTxt.getText();
        String Address = addressTxt.getText();
        String PhoneNumber = phoneTxt.getText();
        String Email = emailTxt.getText();


        Customer customer = new Customer(CustomerID, CustomerNIC, CustomerName, Address, PhoneNumber, Email);
        try {
            boolean isAdded = CustomerModel.addCustomer(customer);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        CustomerlDTxt.clear();nicTxt.clear();CustomerNameTxt.clear();addressTxt.clear();phoneTxt.clear();emailTxt.clear();
    }




   public void initialize() {
        ColCusID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
       ColNic.setCellValueFactory(new PropertyValueFactory("CustomerNIC"));
        ColName.setCellValueFactory(new PropertyValueFactory("CustomerName"));
        ColAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        ColPhone.setCellValueFactory(new PropertyValueFactory("PhoneNumber"));
       ColEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        try {
            loadAllCustomer();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    private void loadAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  Customer");
        ObservableList<Customer> observableList = FXCollections.observableArrayList();
        while(resultSet.next()){
                observableList.add(
                        new Customer(
                                resultSet.getString("CustomerID"),
                                resultSet.getString("CustomerNIC"),
                                resultSet.getString("CustomerName"),
                                resultSet.getString("Address"),
                                resultSet.getString("PhoneNumber"),
                                resultSet.getString("Email")
                        )
                    );
        }
        tblCus.setItems(observableList);
    }

    public void ReloadOnAction(ActionEvent actionEvent) {
       initialize();
    }
}

