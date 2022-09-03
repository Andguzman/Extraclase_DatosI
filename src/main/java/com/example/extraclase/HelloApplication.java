package com.example.extraclase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.setTitle("Extraclase");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main, lanza la aplicacion
     * @param args
     */

    public static void main(String[] args) {
        launch(args);
    }
}