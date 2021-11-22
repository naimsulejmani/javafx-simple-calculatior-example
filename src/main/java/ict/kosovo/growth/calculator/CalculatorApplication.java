package ict.kosovo.growth.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator.fxml"));

        Image iconImage = new Image("D:\\Github\\bezkoder\\Calculator\\images\\icon.png");
        stage.getIcons().add(iconImage);

        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        stage.setTitle("Calculator!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}