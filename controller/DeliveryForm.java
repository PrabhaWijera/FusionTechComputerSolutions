package lk.ijse.Fusion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.model.CustomerModel;
import lk.ijse.Fusion.model.DeliveryModel;
import lk.ijse.Fusion.to.Customer;
import lk.ijse.Fusion.to.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryForm {
    public TextField dateTxt;
    public TextField Arrival_timeTxt;
    public TextField delivery_idTxt;
    public TextField Driver_NicTxt;
    public TextField Driver_NameTxt;
    public TextField Delivery_feeTxt;
    public TextField Delivery_stetusTxt;
    public TextField Order_idtxt;

    public TableView deliveryTbl;
    public TableColumn ColdeliID;
    public TableColumn ColNic;
    public TableColumn ColName;
    public TableColumn ColOrder;
    public TableColumn Coldate;
    public TableColumn Coltime;
    public TableColumn ColFee;
    public TableColumn Colstetus;


    public void addOnAction(ActionEvent actionEvent) {
        String DeliveryID = delivery_idTxt.getText();
        String DriverNic = Driver_NicTxt.getText();
        String DriverName = Driver_NameTxt.getText();
        String DeliveryDate = dateTxt.getText();
        String ArriavalTime = Arrival_timeTxt.getText();
        String DeliveryFee = Delivery_feeTxt.getText();
        String Stetus = Delivery_stetusTxt.getText();
        String OrderID = Order_idtxt.getText();

        Delivery delivery = new Delivery(DeliveryID, DriverNic,DriverName,DeliveryDate, ArriavalTime,DeliveryFee,Stetus,OrderID);
        try {
            boolean isAdded =  DeliveryModel.addDelivery(delivery);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delivery Ok!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        delivery_idTxt.clear();Driver_NicTxt.clear();Driver_NameTxt.clear();dateTxt.clear();Arrival_timeTxt.clear();Delivery_feeTxt.clear();Delivery_stetusTxt.clear();Order_idtxt.clear();


    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String DeliveryID = delivery_idTxt.getText();
        String DriverNic = Driver_NicTxt.getText();
        String DriverName = Driver_NameTxt.getText();
        String DeliveryDate = dateTxt.getText();
        String ArriavalTime = Arrival_timeTxt.getText();
        String DeliveryFee = Delivery_feeTxt.getText();
        String Stetus = Delivery_stetusTxt.getText();
        String OrderID = Order_idtxt.getText();

        Delivery delivery = new Delivery(DeliveryID, DriverNic,DriverName,DeliveryDate, ArriavalTime,DeliveryFee,Stetus,OrderID);


        try {
            boolean isDeleted = DeliveryModel.remove(delivery_idTxt.getText());

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delivery Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        delivery_idTxt.clear();Driver_NicTxt.clear();Driver_NameTxt.clear();dateTxt.clear();Arrival_timeTxt.clear();Delivery_feeTxt.clear();Delivery_stetusTxt.clear();Order_idtxt.clear();
    }



    public void UpdateOnAction(ActionEvent actionEvent) {
        String DeliveryID = delivery_idTxt.getText();
        String DriverNic = Driver_NicTxt.getText();
        String DriverName = Driver_NameTxt.getText();
        String DeliveryDate = dateTxt.getText();
        String ArriavalTime = Arrival_timeTxt.getText();
        String DeliveryFee = Delivery_feeTxt.getText();
        String Stetus = Delivery_stetusTxt.getText();
        String OrderID = Order_idtxt.getText();

        Delivery delivery = new Delivery(DeliveryID, DriverNic,DriverName,DeliveryDate, ArriavalTime,DeliveryFee,Stetus,OrderID);

        try {
            boolean isUpdate = DeliveryModel.update(delivery);

            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delivery Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        delivery_idTxt.clear();Driver_NicTxt.clear();Driver_NameTxt.clear();dateTxt.clear();Arrival_timeTxt.clear();Delivery_feeTxt.clear();Delivery_stetusTxt.clear();Order_idtxt.clear();
    }


    public void searchOnAction(ActionEvent actionEvent) {
        String DeliveryID = delivery_idTxt.getText();
        try {
            Delivery delivery = DeliveryModel.search(DeliveryID);
            if (delivery != null) {
                fillData(delivery);
                //new Alert(Alert.AlertType.CONFIRMATION, "Search Ok!!!!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillData(Delivery delivery) {
        delivery_idTxt.setText(delivery.getDeliveryID());
        Driver_NicTxt.setText(delivery.getDriverNic());
        Driver_NameTxt.setText(delivery.getDriverName());
        dateTxt.setText(delivery.getDeliveryDate());
        Arrival_timeTxt.setText(delivery.getArriavalTime());
        Delivery_feeTxt.setText(delivery.getDeliveryFee());
        Delivery_stetusTxt.setText(delivery.getStetus());
        Order_idtxt.setText(delivery.getOrderID());
    }


    public void Save_printOnAction(ActionEvent actionEvent) {}



    public void initialize() {
        ColdeliID.setCellValueFactory(new PropertyValueFactory("DeliveryID"));
        ColNic.setCellValueFactory(new PropertyValueFactory("DriverNic"));
        ColName.setCellValueFactory(new PropertyValueFactory("DriverName"));
        Coldate.setCellValueFactory(new PropertyValueFactory("DeliveryDate"));
        Coltime.setCellValueFactory(new PropertyValueFactory("ArriavalTime"));
        ColFee.setCellValueFactory(new PropertyValueFactory("DeliveryFee"));
        Colstetus.setCellValueFactory(new PropertyValueFactory("Stetus"));
        ColOrder.setCellValueFactory(new PropertyValueFactory("OrderID"));
        try {
            loadAllDeli();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    private void loadAllDeli()  throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  fusiontech.Delivery");
        ObservableList<Delivery> observableList = FXCollections.observableArrayList();
        while(resultSet.next()){
            observableList.add(
                    new Delivery(
                            resultSet.getString("DeliveryID"),
                            resultSet.getString("DriverNic"),
                            resultSet.getString("DriverName"),
                            resultSet.getString("DeliveryDate"),
                            resultSet.getString("ArriavalTime"),
                            resultSet.getString("DeliveryFee"),
                            resultSet.getString("Stetus"),
                            resultSet.getString("OrderID")

                    )
            );
        }
        deliveryTbl.setItems(observableList);
    }

    public void ReloadOnAction(ActionEvent actionEvent) {
        initialize();
    }
}
