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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockKeeperDashHomeController {
    public Label instockLbl;
    public Label soldItemLbl;
    public Label userNameLbl;
    public AnchorPane pane;
    public AnchorPane pane1;
    public Label datelbl;
    public Label Itemlbl;


    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MAINPAGE,pane1);
    }

    public void Go_itemOnAction(ActionEvent actionEvent) throws IOException {
    Navigation.navigate(Routes.ITEM,pane);
    }

    public void Go_StockOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCK,pane);
    }



    public void initialize(){
        setDate();
        setTime();
    }

    private void setTime() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
            Itemlbl.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    private void setDate() {
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
            datelbl.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
