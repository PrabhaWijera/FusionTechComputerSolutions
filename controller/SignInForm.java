package lk.ijse.Fusion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import lk.ijse.Fusion.Util.Navigation;
import lk.ijse.Fusion.Util.Routes;

import javax.print.attribute.standard.MediaSize;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInForm implements Initializable {

    public AnchorPane signupwindowContext;
    public MediaView mediaview;
    public TextField nic_txt;
    public TextField name_txt;
    public PasswordField password_txt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("wow.mp4");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        mediaview.setMediaPlayer(mp);
        mp.play();
    }



    public void create_accountOnAction(ActionEvent actionEvent) {

    }

    public void LogAgainOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MAINPAGE,signupwindowContext);
    }
}
