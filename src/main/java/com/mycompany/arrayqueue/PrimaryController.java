package com.mycompany.arrayqueue;

import java.io.IOException;
import java.util.NoSuchElementException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * controller class for GUI, holds handlers for the buttons
 * @author nicka
 */
public class PrimaryController {

    @FXML
    private ListView<String> listview;
    @FXML
    private TextField AddTextField;
    @FXML
    private Button AddButton;
    @FXML
    private Button RemoveButton;

    private ArrayQueueDS a1 = new ArrayQueueDS();//arrayqueue object, uses default constructor

    private ObservableList<String> ob;

    /**
     * executeadd method will cause the arrayqueue method add to execute, the
     * data is taken from the textfield and added to the arrayqueue
     *
     * @param event
     */
    @FXML
    private void ExecuteAdd(ActionEvent event) {

        ob = listview.getItems();//get the items from the listview
        if (!AddTextField.getText().equals("")) {//if the DOES enter something, (!), then add it otherwise throw an error

            String data = AddTextField.getText();//get the data from the textfield

            a1.add(data);//add the data to the backing array
            ob.add(data);//add the data to the listview

        } else {//if the user does not enter anything, make an error
            makeAlert("Error, please enter something");//throw an error
        }

    }

    /**
     * executeremove method will cause the arrayqueue method remove to execute,
     * the element removed is "j" or the next element from the arrayqueue, it
     * functions like a normal queue
     *
     * @param event
     */
    @FXML
    private void ExecuteRemove(ActionEvent event) {

        try {
            System.out.println(a1.remove());
            ob.remove(0);
        } catch (NoSuchElementException e) {
            makeAlert("The ArrayQueue is empty");
        }

    }

    /**
     * makeAlert method will generate an alert when called, showing the text it was provided
     * @param Text 
     */
    private void makeAlert(String Text) {

        Alert a = new Alert(AlertType.ERROR);//create an alert object
        a.setHeaderText(Text);//set the header to the text provided
        a.setTitle("Error");//set the title
        a.showAndWait();//show the alert until the user closes it 

    }
}
