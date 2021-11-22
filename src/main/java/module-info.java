module ict.kosovo.growth.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens ict.kosovo.growth.calculator to javafx.fxml;
    exports ict.kosovo.growth.calculator;
}