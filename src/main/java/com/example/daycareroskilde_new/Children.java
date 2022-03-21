package com.example.daycareroskilde_new;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.ResourceBundle;

public class Children implements Initializable {


    @FXML
    private Button button_back;

    @FXML
    private TableColumn<ChildrenDetails, String> column_group_Name;

    @FXML
    private TableColumn<ChildrenDetails, Date> column_birth_date;

    @FXML
    private TableColumn<ChildrenDetails,String> column_first_name;

    @FXML
    private TableColumn<ChildrenDetails, Integer > column_Children_ID;

    @FXML
    private TableColumn<ChildrenDetails, String> column_last_name;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<?> table_children;
//    @FXML
//    private TableView<ChildrenDetails>;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml", "logged in!", null);
            }
        });
    }


}
