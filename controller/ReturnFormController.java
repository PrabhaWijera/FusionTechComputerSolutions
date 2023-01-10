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

public class ReturnFormController {
    public AnchorPane returnContext;
    public TextField returnIdTxt;
    public TextField orderIdTxt;
    public TextField detailsTxt;


    private void setUi(String location) throws IOException {
        Stage stage=(Stage) returnContext .getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/" + location + ".fxml")))));
    }
    private void setWIN(String location) throws IOException {
        returnContext.getChildren().clear();
        Parent parent= FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"));
        returnContext.getChildren().add(parent);
    }

    public void ReturnDetailsOnAction(ActionEvent actionEvent) {
    }
}
