package Programutvikling.Controller;


// initieres av metode i allekunder, når en kunde er valgt/ dobbeltklikket.


import Programutvikling.Model.AccidentReport;
import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.Insurance;
import Programutvikling.Model.MyDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;

import java.util.ResourceBundle;

import static Programutvikling.Model.MyArrays.*;

public class customerInformationController extends GUImethods implements Initializable {


    private Customer customerToShow;
    private ObservableList<Insurance> ObsInsurancesList;
    private ObservableList<AccidentReport> ObsAccidentReportList;


    // Kundeinfo
    @FXML
    private Label lblCustomerID;
    @FXML
    private Label lblFirstname;
    @FXML
    private Label lblLastname;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblphoneNr;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblAdress;
    @FXML
    private Label lblSumUnpaid;
    @FXML
    private Label lblPostCodeCity;


    // tableview kundens forsikringer
    @FXML
    private TableView<Insurance> tblVwInsrnc;
    @FXML
    private TableColumn tblColInsrncId;
    @FXML
    private TableColumn tblColinsType;
    @FXML
    private TableColumn tblColValue;
    @FXML
    private TableColumn tblColAmount;
    @FXML
    private TableColumn tblColInsMyDate;

    // tableview kundens skademeldinger
    @FXML
    private TableView<AccidentReport> tblVwAccRep;
    @FXML
    private TableColumn tblColAccidentNumber;
    @FXML
    private TableColumn tblColaccidentType;
    @FXML
    private TableColumn tblColvaluationAmount;
    @FXML
    private TableColumn tblColpaidCompansationAmount;
    @FXML
    private TableColumn tblColaccidentDate;
    @FXML
    private TableColumn tblColaccidentDescription;


    // setter hvilken kunde som vises basert på valg i ownerviewet
    public void setCustomer(Customer customer) {
        customerToShow = customer;
        updateFields();
    }

    // setter labler med valgt kundes getmetoder, og verdier i tabeller.
    private void updateFields() {
        lblCustomerID.setText(customerToShow.getCustomerID());
        lblFirstname.setText(customerToShow.getFirstName());
        lblLastname.setText(customerToShow.getLastName());
        lblDate.setText(customerToShow.getDateCustomerCreated().getDay() + "." +
                customerToShow.getDateCustomerCreated().getMonth() + "." +
                customerToShow.getDateCustomerCreated().getYear());
        lblphoneNr.setText(customerToShow.getPhoneNumber());
        lblEmail.setText(customerToShow.getEmail());
        lblAdress.setText(customerToShow.getBillingAdress());
        lblPostCodeCity.setText(customerToShow.getBillingPostalCode().
                concat("  ").concat(customerToShow.getBillingCity()));
        lblSumUnpaid.setText(customerToShow.getCustomerUnpaidCompensations());//"Mangler get metode" + " kr");


        // Henter inn alle forsikringer fra MyArrays, og filtrerer ut denne kundens forsikringer
        ObsInsurancesList = FXCollections.observableArrayList(getInsArrayList());
        FilteredList<Insurance> filteredInsurancesList = new FilteredList<>(ObsInsurancesList, p -> true);

        filteredInsurancesList.setPredicate(Insurance -> {
            if (Insurance.getInsuranceId().substring(0, 4).equals(customerToShow.getCustomerID())) {
                return true;
            }
            return false;
        });


        // Henter inn alle skademeldinger fra MyArrays, og filtrerer ut denne kundens skademeldinger
        ObsAccidentReportList = FXCollections.observableArrayList(AccidentReportListscsv());
        FilteredList<AccidentReport> filteredAccidentReportList = new FilteredList<>(ObsAccidentReportList, p -> true);

        filteredAccidentReportList.setPredicate(AccidentReport -> {
            if (AccidentReport.getAccidentNumber().substring(0, 4).equals(customerToShow.getCustomerID())) {
                return true;
            }
            return false;
        });

        //Setter tableviews utfra filtrerte lister.

        tblVwInsrnc.setItems(filteredInsurancesList);

        tblVwAccRep.setItems(filteredAccidentReportList);
    }

    // Henter insurances fra MyArrays og putter de i en observable Arraylist, brukes for å vise kundens forsikringer.

    //ObservableList<Insurance> insurancesList = FXCollections.observableArrayList(getInsArrayList());

    /*private ObservableList<Insurance> findInsurances() {

        ArrayList<Insurance> insurancesList = getInsArrayList();
        ArrayList<Insurance> insurancesFound = new ArrayList<>();

        for (Insurance insurance : insurancesList) {
            if (insurance.getInsuranceId().substring(0, 5).equals(customerToShow.getCustomerID())) {
                insurancesFound.add(insurance);
                System.out.println(insurance.getInsuranceId());
            }
        }
        ObservableList<Insurance> ObsInsurancesList = FXCollections.observableArrayList(insurancesFound);
        return ObsInsurancesList;
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // definerer hvilke verdier som skal inn i hvilke kolonner i forsikringstabellen.

        tblVwInsrnc.setPlaceholder(new Label("Denne kunden har ingen forsikringer"));
        tblVwAccRep.setPlaceholder(new Label("Det er ingen rapporterte skademeldinger for denne kunden"));

        tblColInsrncId.setCellValueFactory(new PropertyValueFactory<Insurance, Integer>("insuranceId"));
        tblColinsType.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceType"));
        tblColValue.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceValue"));
        tblColAmount.setCellValueFactory(new PropertyValueFactory<Insurance, String>("insuranceAmount"));
        tblColInsMyDate.setCellValueFactory(new PropertyValueFactory<Insurance, MyDate>("dateInsuranceCreated"));

        // definerer hvilke verdier som skal inn i hvilke kolonner i skademeldingstabellen.

        tblColAccidentNumber.setCellValueFactory(new PropertyValueFactory<AccidentReport, String>("accidentNumber"));
        tblColaccidentType.setCellValueFactory(new PropertyValueFactory<AccidentReport, String>("accidentType"));
        tblColvaluationAmount.setCellValueFactory(new PropertyValueFactory<AccidentReport, Double>("valuationAmount"));
        tblColpaidCompansationAmount.setCellValueFactory(new PropertyValueFactory<AccidentReport, Double>("paidCompansationAmount"));
        tblColaccidentDate.setCellValueFactory(new PropertyValueFactory<AccidentReport, MyDate>("accidentDate"));
        tblColaccidentDescription.setCellValueFactory(new PropertyValueFactory<AccidentReport, String>("accidentDescription"));

    }

}
