package Programutvikling.Model.FilerForSletting;

import Programutvikling.Model.FilerForSletting.TempForTesting.CustomerTemp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static Programutvikling.Model.MyArrays.customerArray;

public class tabSelectCustomerController implements Initializable {

    @FXML
    public Label lblSelectedCustomer;

    @FXML
    public TableView<CustomerTemp> tblVwCustomers;
    @FXML
    public TableColumn<CustomerTemp, String> tblColCustomerId;
    @FXML
    public TableColumn<CustomerTemp, String> tblColCustomerFirstName;
    @FXML
    public TableColumn<CustomerTemp, String> tblColCustomerLastName;
    @FXML
    public TextField txtFilterCustomers;


    // Henter customers fra MyArrays og putter de i en observable Arraylist, brukes for å velge kunde.
    private ObservableList<CustomerTemp> list = FXCollections.observableArrayList(customerArray());




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //TODO Her er mye hentet fra tutorial: https://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
        // Er det mulig å oppgi kilder, eller bør vi skrive det om litt? Kanskje vi skal spørre om det.
        // TODO Mye mulig en del av dette bør flyttes over til backend...

        /*-------------------SELECT CUSTOMER START----------------------------*/
        //Oppretter kolonner og henter celleverdier fra Customer
        tblColCustomerFirstName.setCellValueFactory(new PropertyValueFactory<CustomerTemp, String>("firstName"));
        tblColCustomerLastName.setCellValueFactory(new PropertyValueFactory<CustomerTemp, String>("lastName"));
        tblColCustomerId.setCellValueFactory(new PropertyValueFactory<CustomerTemp, String>("customerId"));


        // Putter observablelist inn i filteredlist
        FilteredList<CustomerTemp> filteredData = new FilteredList<>(list, p -> true);

        //Lytter på txtFilterCustomers og setter verdi som filtrerer filteredData
        txtFilterCustomers.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(customerTemp -> {
                // filteredData returnerer alt hvis txtFilterCustomers er tom.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                //For å gjøre filtreringen uavhengig av case settes alt til lowercase
                // før filtrering, både filterverdien og tabellverdien
                String txtFilterCustomersToLowerCalse = newValue.toLowerCase();

                if (customerTemp.getFirstName().toLowerCase().contains(txtFilterCustomersToLowerCalse)) {
                    return true; // Filtrering på lowercasefornavn fra customer
                } else if (customerTemp.getLastName().toLowerCase().contains(txtFilterCustomersToLowerCalse)) {
                    return true; // Filtrering på lowercaseetternavn fra customer
                } else if (customerTemp.getCustomerId().toLowerCase().contains(txtFilterCustomersToLowerCalse)) {
                    return true; // Filtrering på id.
                }
                return false; // Filtrering finner ingen match.
            });
        });
        //Legger filtrert liste i sortedList, for at det filtrerte innholdet returneres sortert.
        SortedList<CustomerTemp> sortedData = new SortedList<>(filteredData);


        //Binder sammen comparatorene i sortedlist og tblVwCustomers
        sortedData.comparatorProperty().bind(tblVwCustomers.comparatorProperty());

        // Legger til sortert og filtrert liste i tabellen.
        tblVwCustomers.setItems(sortedData);

        /*-------------------SELECT CUSTOMER END----------------------------*/

        // Setter tekst for å vise hvilken kunde som er valgt.

        tblVwCustomers.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            //TODO mulig denne bør bygges om å heller bruke mouseevent enn listener, slik at man feks må dobbelklikke
            if (newValue == null) {
                lblSelectedCustomer.setText("Velg kunde i tabellen til venstre");
            } else {
                lblSelectedCustomer.setText(String.format("Ny forsikringavtale opprettes for : %s %s (KundeID: %s )",
                        newValue.getFirstName(),
                        newValue.getLastName(),
                        newValue.getCustomerId()));
                // Sender valgt kunde over til de andre tabs
               
            }
        }));



    }
}

