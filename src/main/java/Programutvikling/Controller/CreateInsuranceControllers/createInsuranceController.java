package Programutvikling.Controller.CreateInsuranceControllers;

import Programutvikling.Controller.GUImethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class createInsuranceController extends GUImethods implements Initializable {

    @FXML public Button homeButton, createInsuranceButton;

    //Kaller gotoHome
    @FXML
    public void homeButton(ActionEvent event) throws Exception {
        gotoHome();
    }

    @FXML
    public void createInsurance(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/createCustomer.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}