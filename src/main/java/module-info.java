module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.client to javafx.fxml;
    exports com.example.client;
}