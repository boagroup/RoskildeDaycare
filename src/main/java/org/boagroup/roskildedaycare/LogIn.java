package org.boagroup.roskildedaycare;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogIn implements Initializable {


    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private Button button_login;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Core core = Core.getInstance();
                if(core.login(tf_username.getText(), tf_password.getText())) {
                    DBUtils.changeScene(event, "Logged-in.fxml", "Menu", tf_username.getText());
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Wrong Credentials");
                    alert.show();
                }
//                DBUtils.logInUser(event, tf_username.getText(), tf_password.getText());
            }
        });
    }
}
