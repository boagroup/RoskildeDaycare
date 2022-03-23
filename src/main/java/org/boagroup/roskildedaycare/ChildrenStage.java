package org.boagroup.roskildedaycare;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChildrenStage implements Initializable {


    @FXML
    private Button button_back;

    @FXML
    private TableColumn<ChildrenDetails, String> column_group_ID;

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
    private TableView<ChildrenDetails> table_children;

//    @FXML
//    private TableView<ChildrenDetails>;

    ObservableList<ChildrenDetails> productSearchModelObservableList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ResultSet queryOutput = Core.getInstance().list(new Query("Children","*", null));
            while (queryOutput.next()){

//                ChildId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
//                        FirstName VARCHAR(255),
//                        LastName VARCHAR(255),
//                        GroupId INT,
//                        BirthDate DATE NOT NULL,

                int queryChildrenID = queryOutput.getInt("ChildId");
                String queryFirstName = queryOutput.getString("FirstName");
                String queryLastName = queryOutput.getString("LastName");
                int queryGroupID = queryOutput.getInt("GroupId");
                Date queryBirthDate = queryOutput.getDate("BirthDate");


                productSearchModelObservableList.add(new ChildrenDetails(queryChildrenID, queryFirstName, queryLastName, queryGroupID, queryBirthDate ));

                column_Children_ID.setCellValueFactory(new PropertyValueFactory<>("childrenID"));
                column_first_name.setCellValueFactory(new PropertyValueFactory<>("fistName"));
                column_last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                column_group_ID.setCellValueFactory(new PropertyValueFactory<>("groupID"));
                column_birth_date.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

                table_children.setItems(productSearchModelObservableList);

                FilteredList<ChildrenDetails> filteredData = new FilteredList<>(productSearchModelObservableList, b -> true);

                searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                    filteredData.setPredicate(productSearchModel -> {
                        if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                            return true;
                        }
                        String searchKeyword = newValue.toLowerCase();

                        if (productSearchModel.getFirstName().toLowerCase().indexOf(searchKeyword)> -1){
                            return true;
                        } else {
                            return false;
                        }
                    });
                });

                SortedList<ChildrenDetails> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(table_children.comparatorProperty());
                table_children.setItems(sortedData);


            }

        } catch (SQLException e) {
            Logger.getLogger(ChildrenStage.class.getName()).log(Level.SEVERE, null, e);

            //e.printStackTrace();
        }
        button_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml", "logged in!", null);
            }
        });
    }


}
