package com.mycompany.arrayqueue;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private ListView<String> listview;
    @FXML
    private TextField AddTextField;
    @FXML
    private Button AddButton;
    @FXML
    private Button RemoveButton;

    
    @FXML
    private void ExecuteAdd(ActionEvent event) {
    }

    @FXML
    private void ExecuteRemove(ActionEvent event) {
    }
}
