package Programutvikling.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//Implements initializable
public class FXMLController extends GUImethods {

    //TODO foreslår å refaktorere alle buttonnavn til mer forståelig.
    //TODO Jeg er helt enig. Holder på å gjøre det nå. -Henrik
    //TODO Også lage en felles metode for handleaction med btn navn og fxmlfil som input.

    /*@FXML
    public Label label;*/

    @FXML
    public Button createAccidentReportButton, showAllCustomersButton, createInsuranceButton,
            showAllInsurancesButton, createCustomerButton, exportFileButton;

    @FXML
    public void createAccidentReport() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/createAccidentReport.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void showAllCustomers() throws Exception {
        Stage stage = (Stage) showAllCustomersButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/customer.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        //gotoPage(customer);
    }

    @FXML
    public void createInsurance() throws Exception {
        Stage stage = (Stage) createInsuranceButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/createInsuranceViews/createInsurance.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void showAllInsurances() throws Exception {
        gotoShowAllInsurances();
    }

    @FXML
    public void createCustomer() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/createCustomer.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    public void exportFile() throws Exception{
        Stage stage = (Stage) createInsuranceButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/export.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        // TODO
    }
}