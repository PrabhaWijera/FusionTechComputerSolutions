package lk.ijse.Fusion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WarrentyFormController {
    public AnchorPane WarrentyContext;
    public TextField warrentyIDTxt;
    public TextField descriptionTxt;
    public TextField warrentyDateTxt;
    public TextField orderIdTxt;


    private void setUi(String location) throws IOException {
        Stage stage=(Stage)WarrentyContext .getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/" + location + ".fxml")))));
    }
    private void setWIN(String location) throws IOException {
        WarrentyContext.getChildren().clear();
        Parent parent= FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"));
        WarrentyContext.getChildren().add(parent);
    }

    public void warrentyDetailsOnAction(ActionEvent actionEvent) {
    }

    public void addOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
