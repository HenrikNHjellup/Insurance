package Programutvikling.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GUImethods {
    @FXML
    public Button cancelButton, homeButton, showAllInsurancesButton;

    public void closeWindow() throws Exception {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void gotoHome() throws Exception {
        Stage stage = (Stage) homeButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/scene.fxml"));
        Scene scene = new Scene (root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    /*
    public void gotoPage(String pageString) throws Exception {
        Stage stage = (Stage) pageButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/" + pageString + ".fxml"));
        Scene scene = new Scene (root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }*/

    public void gotoShowAllInsurances() throws Exception {
        Stage stage = (Stage) showAllInsurancesButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/insurance.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
