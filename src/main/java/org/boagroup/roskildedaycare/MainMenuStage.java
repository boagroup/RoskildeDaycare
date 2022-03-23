package org.boagroup.roskildedaycare;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuStage implements Initializable {
    @FXML
    private Label label_welcome;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_children;

    @FXML
    private Button button_parents;
    @FXML
    private Button button_waiting_list;
    @FXML
    private Button button_schedule;
    @FXML
    private Button button_groups;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Core core = Core.getInstance();
        button_logout.setOnAction(event -> {
            core.logout();
            DBUtils.changeScene(event, "log-in.fxml", "log in!", null);
        });

        button_children.setOnAction(event -> {
            core.list(new Query("Children","*", null));
        });
    }

    public void setUserInformation(String username){
        label_welcome.setText("Welcome " + username + "!");
    }
}
