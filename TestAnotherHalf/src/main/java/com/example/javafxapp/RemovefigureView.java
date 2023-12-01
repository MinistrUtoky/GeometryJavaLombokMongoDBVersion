package com.example.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import lombok.extern.java.Log;
import org.example.IShape;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

@Log
public class RemovefigureView implements Initializable {

    public Canvas mainCanvas;
    public HelloController mainWindowController;
    @FXML
    public ComboBox FigureToRemove;
    @FXML
    public Button RemoveShapeButton;
    @FXML
    public Button CloseButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        log.log(Level.INFO, "Initializing the Figure Removal Form");
    }
    public void SetupFigureRemovalForm()
    {
        try {
            log.log(Level.INFO, "Setting up the Figure Removal Form");
            for (IShape shape : mainWindowController.shapesList) {
                FigureToRemove.getItems().add(shape.toString());
            }
        }
        catch (Exception ex){
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
    @FXML
    private void FigureToRemoveChanged() {
        try {
            log.log(Level.INFO, "Figure to remove changed");
            RemoveShapeButton.setDisable(false);
        }
        catch (Exception ex){
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
    @FXML
    private void RemoveShape_Click(){
        try {
            log.log(Level.INFO, "Remove shape button clicked");
            if (mainWindowController.shapesList.isEmpty()) return;
            Integer figureToRemoveIndex = FigureToRemove.getSelectionModel().getSelectedIndex();
            mainWindowController.shapesList.remove(mainWindowController.shapesList.get(figureToRemoveIndex));
            RenewFigureToRemoveComboBox();
            mainWindowController.RedrawMainCanvas();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success");
            alert.setContentText("Shape successfully removed");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
            CloseWindow();
        }
        catch (Exception ex){
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
    private void RenewFigureToRemoveComboBox(){
        try{
            log.log(Level.INFO, "Renewing figure to remove combo box");
            FigureToRemove.getItems().clear();
            for (IShape shape: mainWindowController.shapesList){
                FigureToRemove.getItems().add(shape.toString());
            }
        }
        catch (Exception ex){
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

    @FXML
    private void CloseWindow(){
        try {
            log.log(Level.INFO, "Closing up the Figure Removal Form");
            Stage stage = (Stage) CloseButton.getScene().getWindow();
            stage.close();
        }
        catch (Exception ex){
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
}
