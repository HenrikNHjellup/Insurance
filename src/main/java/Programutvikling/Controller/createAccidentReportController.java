package Programutvikling.Controller;


import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.Insurance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static Programutvikling.Model.MyArrays.*;

public class createAccidentReportController extends GUImethods implements Initializable {



    @FXML
    private Label lblselectedCustomer;


    // Velg kunde tabell
    @FXML
    private TableView<Customer> tblVwCustomers;
    @FXML
    private TableColumn<Customer, String> tblColCustomerId;
    @FXML
    private TableColumn<Customer, String> tblColCustomerLastName;
    @FXML
    private TableColumn<Customer, String> tblColCustomerFirstName;
    @FXML
    private TextField txtFilterCustomers;

    private ObservableList<Customer> customerList = FXCollections.observableArrayList(customerListscsv());

    private Customer selectedCustomer;

    //Velg forsikring tabell
    @FXML
    private TableView<Insurance> tblVwInsrnc;
    @FXML
    private TableColumn tblColInsID;

    //Datafelter for skademelding

    @FXML
    public AnchorPane AnchPAccRep;
    @FXML
    private TextField txtFldAccDesc;
    @FXML
    private TextField txtFldWitness;
    @FXML
    private Spinner spnPaidComp;
    @FXML
    private Spinner spnValAmnt;
    @FXML
    private ComboBox cmBxTypeAcc;
    @FXML
    private DatePicker dtPckAccDate;


    private ObservableList<Insurance> ObsInsurancesList = FXCollections.observableArrayList(getInsArrayList());

    public void cancelButton(ActionEvent event) throws Exception {
        closeWindow();
    }


    @SuppressWarnings("Duplicates")
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AnchPAccRep.setVisible(false);

        /*---SELECT CUSTOMER START---*/
        //Oppretter kolonner og henter celleverdier fra Customerarrayet
        tblColCustomerFirstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        tblColCustomerLastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        tblColCustomerId.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerID"));

        tblVwCustomers.setRowFactory(tv -> {
            TableRow<Customer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    Customer dblClickedCustomer = row.getItem();

                    lblselectedCustomer.setText(dblClickedCustomer.getCustomerID());

                }
            });
            return row;
        });


        // Putter observablelist inn i filteredlist
        FilteredList<Customer> filteredCustomerData = new FilteredList<>(customerList, p -> true);

        //Lytter på txtFilterCustomers og setter verdi som filtrerer filteredCustomerData
        txtFilterCustomers.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredCustomerData.setPredicate(customer -> {
                // filteredCustomerData returnerer alt hvis txtFilterCustomers er tom.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                //For å gjøre filtreringen uavhengig av case settes alt til lowercase
                // før filtrering, både filterverdien og tabellverdien
                String txtFilterCustomersToLowerCalse = newValue.toLowerCase();

                if (customer.getFirstName().toLowerCase().contains(txtFilterCustomersToLowerCalse)) {
                    return true; // Filtrering på lowercasefornavn fra customer
                } else if (customer.getLastName().toLowerCase().contains(txtFilterCustomersToLowerCalse)) {
                    return true; // Filtrering på lowercaseetternavn fra customer
                } else if (

                        customer.getCustomerID().contains(txtFilterCustomersToLowerCalse)) {
                    return true; // Filtrering på id.
                }
                return false; // Filtrering finner ingen match.
            });
        });
        //Legger filtrert liste i sortedList, for at det filtrerte innholdet returneres sortert.
        SortedList<Customer> sortedData = new SortedList<>(filteredCustomerData);


        //Binder sammen comparatorene i sortedlist og tblVwCustomers
        sortedData.comparatorProperty().bind(tblVwCustomers.comparatorProperty());

        // Legger til sortert og filtrert liste i tabellen.
        tblVwCustomers.setItems(sortedData);

        /*---SELECT CUSTOMER END---*/

        /*---SELECT INSURANCE START---*/

        //Oppretter kolonner og henter celleverdier fra Insurancearrayet
        tblVwInsrnc.setPlaceholder(new Text("kunden har \n ingen forsikringer"));

        tblColInsID.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceId"));


        FilteredList<Insurance> filteredInsurancesList = new FilteredList<>(ObsInsurancesList, p -> true);

        lblselectedCustomer.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredInsurancesList.setPredicate(Insurance -> {

                if (Insurance.getInsuranceId().substring(0, 4).equals(newValue)) {

                    System.out.println("new value:" + newValue);
                    return true;
                }
                return false;
            });

        });
        tblVwInsrnc.setItems(filteredInsurancesList);

        tblVwInsrnc.setRowFactory(tv -> {
            TableRow<Insurance> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Insurance dblClickedInsurance = row.getItem();

                    //lblselectedCustomer.setText(dblClickedCustomer.getCustomerID());
                    AnchPAccRep.setVisible(true);
                }
            });
            return row;
        });

    }
}

