package lk.ijse.Fusion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import lk.ijse.Fusion.Database.DBConnection;
import lk.ijse.Fusion.Util.CRUDutil;
import lk.ijse.Fusion.model.CustomerModel;
import lk.ijse.Fusion.model.StockModel;
import lk.ijse.Fusion.to.Customer;
import lk.ijse.Fusion.to.Stock;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class StockFormController {
    public AnchorPane StockContext;

    public TextField stockIdTxt;
    public TextField StockqtyTxt;

    public TextField dateTxt;
    public TableView stockTbl;

    public TableColumn ColStockId;
    public TableColumn ColItemCode;
    public TableColumn ColQty;
    public TableColumn ColDate;
    public TextField itemCodeTxt;


    public void initialize(){
        ColStockId.setCellValueFactory(new PropertyValueFactory("Stock ID"));
        ColQty.setCellValueFactory(new PropertyValueFactory("QTY"));
        ColDate.setCellValueFactory(new PropertyValueFactory("Date"));
        try {
            loadAllStock();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

}
    public void Stock_Manage_EmployeeOnAction(ActionEvent actionEvent) {
    }

    public void Stock_ItemDetails_OnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
        String StockID = stockIdTxt.getText();
        String  StockDate = dateTxt.getText();

        int stockQty = Integer.parseInt(StockqtyTxt.getText());

        Stock stock = new Stock(StockID,StockDate, stockQty);
        try {
            boolean isAdded = StockModel.addStock(stock);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void editonAction(ActionEvent actionEvent) {
        String StockID = stockIdTxt.getText();
        String  StockDate = dateTxt.getText();

        int stockQty = Integer.parseInt(StockqtyTxt.getText());


        Stock stock = new Stock(StockID,StockDate, stockQty);

         try {
            boolean isUpdate = StockModel.update(stock);

            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Update!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteeOnAction(ActionEvent actionEvent) {
        String StockID = stockIdTxt.getText();
        String  StockDate = dateTxt.getText();

        int stockQty = Integer.parseInt(StockqtyTxt.getText());

        Stock stock = new Stock(StockID,StockDate, stockQty);
        try {
            boolean isDeleted = StockModel.remove( stockIdTxt.getText());

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Delete!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReloadOnAction(ActionEvent actionEvent) {
    initialize();
    }

    private void loadAllStock() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CRUDutil.execute("SELECT * FROM  Stock");
        ObservableList<Stock> observableList = FXCollections.observableArrayList();
        while(resultSet.next()){
            observableList.add(
                    new Stock(
                            resultSet.getString("StockID"),
                            resultSet.getString("StockDate"),
                            resultSet.getInt("stockQty")
                    )
            );
        }
        stockTbl.setItems(observableList);
    }


}
