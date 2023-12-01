package com.example.javafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.logging.Level;

@Log
public class HelloApplication extends Application {

    private GridPane mainGrid;
    private HelloController controller;

    @Override
    public void start(Stage stage) throws IOException {
        try
        {
            log.log(Level.INFO, "Starting application");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load(), 782, 560);
            controller = fxmlLoader.getController();
            controller.mainApplicationScript = this;
            stage.setTitle("Geometric Shapes");
            stage.setScene(mainScene);
            stage.setResizable(false);
            stage.show();

            mainGrid = (GridPane) fxmlLoader.getNamespace().get("MainFormGrid");
            controller.redColoredShapesIndices = new int[2];
            controller.redColoredShapesIndices[0]=-1;
            controller.redColoredShapesIndices[1]=-1;
            controller.CreateAxis();
        }
        catch (Exception ex)
        {
            log.severe(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Error: " + ex.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }

    public static void main(String[] args) {
        launch();
    }



}