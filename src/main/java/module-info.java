module com.example.physicssimulations {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.physicssimulations to javafx.fxml;
    exports com.example.physicssimulations;
}