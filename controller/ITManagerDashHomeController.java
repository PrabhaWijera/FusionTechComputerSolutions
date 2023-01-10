package lk.ijse.Fusion.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.Fusion.Util.Navigation;
import lk.ijse.Fusion.Util.Routes;
import org.apache.poi.hssf.record.formula.functions.Na;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ITManagerDashHomeController {
    public Label totalCustomerLbl;
    public Label topItemLbl;
    public Label usernameLbl;
    public AnchorPane pane;
    public AnchorPane pane1;
    public Label lblDate;
    public Label lblTime;

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MAINPAGE,pane1);
    }

    public void Go_itemOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ITEM,pane);
    }

    public void Go_ordersOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.ORDERS,pane);
    }

    public void Go_customersOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.CUSTOMER,pane);
    }

    public void Go_PaymentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENT,pane);
    }

    public void Go_suppliersOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.SUPPLIER,pane);
    }

    public void Go_stockOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.STOCK,pane);
    }

    public void Go_deliveryOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.DELIVERY,pane);
    }

    public void initialize(){
        setTime();
        setDate();
    }

    private void setTime() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO,e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY:MM:dd");
            lblTime .setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setDate() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
            lblDate.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void GoPlaceOrder(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PLACEORDER,pane);
    }
}
