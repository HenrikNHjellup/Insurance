package Programutvikling.Controller;

import Programutvikling.Model.MyArrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import Programutvikling.Model.Insurance.Insurance;

//import static Programutvikling.Model.MyArrays.insurancesArray;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


//Implements initializable
public class insuranceController extends GUImethods implements Initializable {

    @FXML
    public Label customerLabel;

    @FXML
    public Button homeButton, createInsuranceButton;

    @FXML
    public Button gotoCreateInsuranceButton2;

    // oppretter tabell med respektive kolonner.
    @FXML
    private TableView<Insurance> tblVwallInsurances;
    @FXML
    private TableColumn<Insurance, Integer> insuranceId;
    @FXML
    private TableColumn<Insurance, String> insuranceConditions;
    @FXML
    private TableColumn<Insurance, String> insuranceType;

    //Populerer Observablelist fra array i backend (i arraysklassen)  (
    private static ObservableList list = FXCollections.observableArrayList(MyArrays.getInsArrayList());


    //Standard metode for alle hjem-knapper
    @FXML
    public void homeButton() throws Exception {
        gotoHome();
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
    private void handleRowClicks() {


        //TODO  SLik det funker nå kan man klikke hvor som helt i tabellen, objektet som velges er det markerte .


        tblVwallInsurances.setOnMouseClicked(mouseEvent -> {

                    /* DOBBELKLIKK VENSTRE Kaller imidlertid på objektets toString og sender denne ut som melding */
                    /*TODO Denne bør kanskje åpne en side for å se og endre på forsikringen.*/

                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        if (mouseEvent.getClickCount() == 2) {
                            String selectedInsurance = tblVwallInsurances.getSelectionModel().getSelectedItem().toString();
                            Dialog d = new Alert(Alert.AlertType.INFORMATION, selectedInsurance);
                            d.show();
                        }
                    }
                    if (mouseEvent.getButton().equals(MouseButton.SECONDARY))
                        /* ENKELT HØYREKLIKK Åpner dokumentet over forsikringsvilkår */ {
                        String selectedInsurance = tblVwallInsurances.getSelectionModel().getSelectedItem().getInsuranceConditions();
                        try {
                            Desktop desktop = null;
                            if (Desktop.isDesktopSupported()) {
                                desktop = Desktop.getDesktop();
                            }

                            desktop.open(new File(selectedInsurance));
                        } catch (IOException ioe) {

                            //TODO må håndteres annerledes, ved feil nå vises ingenting i tabellen.
                            ioe.printStackTrace();
                        }
                    }
                }
        );
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyArrays.fillInsArray();
        // definerer hvilke verdier som skal inn i hvilke kolonner.
        insuranceId.setCellValueFactory(new PropertyValueFactory<Insurance, Integer>("insuranceId"));
        insuranceConditions.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceConditions"));
        insuranceType.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceType"));

        // Henter inn verdier fra observableArraylist til tabellen.
        tblVwallInsurances.setItems(list);
    }
}
