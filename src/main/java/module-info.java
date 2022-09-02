module com.example.extraclase {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.extraclase to javafx.fxml;
    exports com.example.extraclase;
}