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

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashHomeController {

    public AnchorPane pane;
    public Label total_customerlbl;
    public Label top_itemLbl;
    public Label username_lbl;
    public AnchorPane pane1;

    public Label timeLbl;
    public Label dateLbl;


    public void initialize(){
        setUserName();
        setDateAndTime();
        setTime();
        setDate();
    }


    private void setDate() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO,e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
            timeLbl.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setTime() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO,e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY:MM:dd");
            dateLbl .setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setDateAndTime() {
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm ");
            timeLbl.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(javafx.util.Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }
     private void setUserName(){

    }

    public void LogOut_OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MAINPAGE,pane1);
    }

    public void Go_itemOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ITEM,pane);
    }

    public void Go_ordersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERS,pane);
    }

    public void Go_employeeOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.EMPLOYEE,pane);
    }

    public void Go_customerOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.CUSTOMER,pane);
    }

    public void Go_paymentOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.PAYMENT,pane);
    }

    public void Go_suppliersOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.SUPPLIER,pane);
    }

    public void Go_attendsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDS,pane);
    }

    public void Go_stockOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.STOCK,pane);
    }

    public void Go_deliveryOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.DELIVERY,pane);
    }

    public void Go_returnOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.RETURN,pane);

    }

    public void Go_salaryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SALARY,pane);
    }

    public void Go_newAccount(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SIGNUPPAGE,pane1);
    }
}
