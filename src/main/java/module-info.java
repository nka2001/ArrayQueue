module com.mycompany.arrayqueue {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.arrayqueue to javafx.fxml;
    exports com.mycompany.arrayqueue;
}
