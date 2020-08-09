package Programutvikling.Controller.CreateInsuranceControllers;

import Programutvikling.Controller.GUImethods;
import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.Insurance.ComputeInsuranceAmount;
import Programutvikling.Model.Insurance.InvalidInsuranceInputException;


import Programutvikling.Model.newObjectCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import Programutvikling.Model.MyDate;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static Programutvikling.Model.MyArrays.*;

public class createInsuranceTabController extends GUImethods implements Initializable {


    /*-----------------------TABS------------------------------*/

    @FXML
    public TabPane insuranceTabs;
    @FXML
    public Tab tabHouseInsrnc, tabBoatInsrnc, tabTrvlInsrnc;


    /*------------------SELECT CUSTOMER TAB--------------------*/

    @FXML
    public Label lblSelectedCustomer;
    @FXML
    public TableView<Customer> tblVwCustomers;
    @FXML
    public TableColumn<Customer, String> tblColCustomerId;
    @FXML
    public TableColumn<Customer, String> tblColCustomerFirstName;
    @FXML
    public TableColumn<Customer, String> tblColCustomerLastName;
    @FXML
    public TextField txtFilterCustomers;

    private Customer selectedCustomer;
    // Henter customers fra MyArrays og putter de i en observable Arraylist, brukes for å velge kunde.
    private ObservableList<Customer> list = FXCollections.observableArrayList(customerListscsv());


    /*------------------CREATE HOUSE_INSURANCE_TAB--------------------*/

    @FXML
    public static Label customerId;

    @FXML
    public Label lblComputedInsrncAmnt;

    //adressefelter for huset som forsikres
    @FXML
    public TextField txtAdress, txtPostalCode, txtCity;

    // Egenskapsfelter for husforsikring
    @FXML
    public ComboBox<String> cmBxBuildingType, cmBxConstruction, cmBxHseStndnd;
    @FXML
    public Spinner<Integer> spnrArea, spnInsrncValueHsHld, spnInsrncValueBldng;

    // felt og filechooser knapp for å velge dokument for forsikringsvilkår
    @FXML
    public TextField txtInsrncCond;
    @FXML
    public Button btnFndInsrnceCond;

    // Radioknapper for å velge om adressen er lik kundens fakturaadresse
    @FXML
    public RadioButton rdbtnCstmrAdrFalse, rdbtnCstmrAdrTrue;
    public ToggleGroup tgGrpCstmrAdr;

    @FXML
    public DatePicker dtpckDateInsrncCrtd;

    @FXML
    public Button btnNewHouseIns;


    /*------------------CREATE BOAT_INSURANCE_TAB--------------------*/

    @FXML
    public static Label customerIdBoat;

    @FXML
    public Label lblComputedInsrncAmntBoat;

    //Eierfelt for båtens eier
    @FXML
    public TextField txtOwner, txtRegNumber, txtYearModel, txtOperation;

    // Egenskapsfelter for båtforsikring
    @FXML
    public ComboBox<String> cmBxBoatType, cmBxModel;
    @FXML
    public Spinner<Integer> spnrFeet, spnrValueBoat;/* spnInsrncValueBldng;*/

    // felt og filechooser knapp for å velge dokument for forsikringsvilkår
    @FXML
    public TextField txtInsrncCondBoat;
    @FXML
    public Button btnFndBoatInsrnceCond;

    // Radioknapper for å velge om eieren av båten er lik kunden
    @FXML
    public RadioButton rdbtnCstmrOwnerFalse, rdbtnCstmrOwnerTrue;
    public ToggleGroup tgGrpCstmrOwner;

    @FXML
    public DatePicker dtpckDateBoatInsrncCrtd;

    @FXML
    public Button btnNewBoatIns;


    /*------------------CREATE TRAVEL INSURANCE TAB ---------------*/

    @FXML
    public static Label customerIdTravel;

    @FXML
    public Label lblComputedInsrncAmntTravel;

    @FXML
    public Spinner<Integer> spnrValueTravel;

    // felt og filechooser knapp for å velge dokument for forsikringsvilkår
    @FXML
    public TextField txtInsrncCondTravel, txtInsrncRange;
    @FXML
    public Button btnFndTravelInsrnceCond;

    @FXML
    public DatePicker dtpckDateTravelInsrncCrtd;

    @FXML
    public Button btnNewTravelIns;


    /*----------------------------METODER------------------------*/

    // filechooser-metode for å velge dokument for forsikringsvilkår
    public void FndInsrnceCond() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setInitialDirectory(new File("insuranceConditions"));


        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        File file = fileChooser.showOpenDialog( null);

        if (file != null) {
            txtInsrncCond.setText(file.getAbsolutePath());
        }
    }

    //Beregner forsikringsverdi
    public void computeTravelInsuranceAmount() {

        int insuranceAmountTravel = spnrValueTravel.getValue();

        ComputeInsuranceAmount insuranceAmount = new ComputeInsuranceAmount();
        lblComputedInsrncAmntTravel.setText(String.format("%.2f",insuranceAmount.computeTravelInsuranceAmount(insuranceAmountTravel)));
    }

    public void createTravelInsrnc() {

        String customerID = selectedCustomer.getCustomerID();
        int insuranceValue = spnrValueTravel.getValue();
        String insuranceConditions = txtInsrncCondTravel.getText();
        String insuranceRange = txtInsrncRange.getText();

        int day = dtpckDateTravelInsrncCrtd.getValue().getDayOfMonth();
        int month = dtpckDateTravelInsrncCrtd.getValue().getMonthValue();
        int year = dtpckDateTravelInsrncCrtd.getValue().getYear();

        //double insuranceAmount = Double.parseDouble(lblComputedInsrncAmntTravel.getText());
        double insuranceAmount = ComputeInsuranceAmount.computeTravelInsuranceAmount(insuranceValue);
        int travelInsuranceAmount = (int) insuranceAmount;

        MyDate dateInsuranceCreated = new MyDate(day,month,year);

        try {
            newObjectCreator.TravelInsuranceCreator(customerID, insuranceAmount, insuranceValue,
                    dateInsuranceCreated, insuranceConditions, insuranceRange, travelInsuranceAmount);

            goToShowAllInsurances();
        } catch (InvalidInsuranceInputException e) {
            System.err.printf( e.getMessage());
        } catch (Exception e) {
            System.out.println("gotoshowallinsurances funker ikke");
            e.printStackTrace();
        }
    }

    int horsePowerInt;
    String engineTypeString;

    //Metode for å dele operation inn i motortype og antall hestekrefter
    public void splitETandHP(){
        String operationString = txtOperation.getText();
        String[] split = operationString.split("\\s+");
        String engineTypeStringinSplit = "";
        int horsePowerIntinSplit = 0;
        for (int i = 0; i < split.length-1; i++){
            if (i < split.length-1){
                engineTypeStringinSplit += split[i] += " ";
            }/* else if (i == (operationString.length())-1){
                engineTypeStringinSplit += split[i];
            }*/
        }
        horsePowerIntinSplit = Integer.parseInt(split[split.length-1]);

        engineTypeString = engineTypeStringinSplit;
        horsePowerInt = horsePowerIntinSplit;

        System.out.print(engineTypeString + " " + horsePowerInt);
    }

    //Metode som setter kunden som eier av båten
    public void customerEqualsOwner(){

        if (this.tgGrpCstmrOwner.getSelectedToggle().equals(this.rdbtnCstmrOwnerTrue)){
            txtOwner.setText(selectedCustomer.getFirstName() + " " + selectedCustomer.getLastName());
        }
        if (this.tgGrpCstmrOwner.getSelectedToggle().equals(this.rdbtnCstmrOwnerFalse)){
            txtOwner.setText("");
        }
    }

    //Beregner forsikringsverdi
    public void computeBoatInsuranceAmount() {

        String boatType = "";
        String model = "";
        int horsePower = 0;
        int feet = 0;
        int insuranceAmountBoat = 0;
        //int insuranceAmountHouseHold = 0;

        if (!cmBxBoatType.getSelectionModel().isEmpty() &&
                !cmBxModel.getSelectionModel().isEmpty() &&
                !txtOperation.getText().isEmpty()) {

            splitETandHP();

            boatType = cmBxBoatType.getSelectionModel().getSelectedItem().toString();
            model = cmBxModel.getSelectionModel().getSelectedItem().toString();
            horsePower = horsePowerInt;
            //engineType = txtOperation.getSelectionModel().getSelectedItem().toString();
            feet = spnrFeet.getValue();
            insuranceAmountBoat = spnrValueBoat.getValue();

            //insuranceAmountHouseHold = spnInsrncValueHsHld.getValue();
            //System.out.println(buildingType + " " + construction + " " + standard+" areal:"+ area+ "bygningverdi:" +insuranceAmountBuilding + "innboverdi:"+ insuranceAmountHouseHold);

            ComputeInsuranceAmount insuranceAmount = new ComputeInsuranceAmount();

            lblComputedInsrncAmntBoat.setText(String.format("%.2f",insuranceAmount.computeBoatInsuranceAmount(
                    boatType, model, horsePower, feet, insuranceAmountBoat)));
        }
    }

    String ownerFirstname, ownerLastname;

    public void ownerNameStringSplit() {
        String nameString = txtOwner.getText();
        String[] split = nameString.split("\\s+");
        String firstname = "";
        String lastname = "";
        for (int i = 0; i < split.length; i++){
            if (i < (split.length)-2){
                firstname += split[i] += " ";
            } else if (i == (split.length)-2){
                firstname += split[i];
            }
        }
        lastname = split[split.length-1];

        ownerFirstname = firstname;
        ownerLastname = lastname;

        System.out.print(ownerFirstname + " " + ownerLastname);
    }

    /*public String ownerFirstnameStringSplit() {
        String firstnameString = txtOwner.getText();
        String[] splited = firstnameString.split("\\s+");
        String firstname = splited[0];
        return firstname;
    }

    public String ownerLastnameStringSplit() {
        String lastnameString = txtOwner.getText();
        String[] splited = lastnameString.split("\\s+");
        String lastname = splited[1];
        return lastname;
    }*/

    public void createBoatInsrnc() {

        String customerID = selectedCustomer.getCustomerID();
        int insuranceValueBoat = spnrValueBoat.getValue();
        //int insuranceValueBoat = spnInsrncValueBldng.getValue();
        //double insuranceValue = insuranceValueBuilding+insuranceValueBuilding;
        String insuranceConditionsBoat = txtInsrncCondBoat.getText();

        ownerNameStringSplit();

        int day = dtpckDateBoatInsrncCrtd.getValue().getDayOfMonth();
        int month = dtpckDateBoatInsrncCrtd.getValue().getMonthValue();
        int year = dtpckDateBoatInsrncCrtd.getValue().getYear();

        String boatType = cmBxBoatType.getValue();//.getSelectionModel().getSelectedItem().getText();
        String model = cmBxModel.getSelectionModel().getSelectedItem();
        String engineType = engineTypeString;
        int horsePower = horsePowerInt;
        String operation = txtOperation.getText();
        String regNumber = txtRegNumber.getText();
        String yearModelString = txtYearModel.getText();
        int yearModel = Integer.parseInt(yearModelString);
        //String engineType = txtOperation.getSelectionModel().getSelectedItem();
        int feet = spnrFeet.getValue();
        //double insuranceAmount = Double.parseDouble(lblComputedInsrncAmnt.getText());
        double insuranceAmountBoat = ComputeInsuranceAmount.computeBoatInsuranceAmount(boatType, model,
                horsePower, feet, insuranceValueBoat);
        //String adress = txtAdress.getText()+" "+txtPostalCode.getText()+" "+txtCity.getText();

        MyDate dateInsuranceCreatedBoat = new MyDate(day,month,year);

        //System.out.println(insuranceValueHouseHold);

        try {
            newObjectCreator.BoatInsuranceCreator(customerID, insuranceAmountBoat, insuranceValueBoat,
                    dateInsuranceCreatedBoat, insuranceConditionsBoat,
                    ownerLastname, ownerFirstname, regNumber,
                    boatType, model, feet, yearModel,
                    operation);

            goToShowAllInsurances();
        } catch (InvalidInsuranceInputException e) {
            System.err.printf( e.getMessage());
        } catch (Exception e) {
            System.out.println("gotoshowallinsurances funker ikke");
            e.printStackTrace();
        }
    }

    public void goToShowAllInsurances() throws Exception {
        Stage stage = (Stage) btnNewBoatIns.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/insurance.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    //metode som setter husadressen lik kundens fakturaadresse, basert på radiobutton-valg.
    public void customerAdressEqualsHouseAdress() {

        if (this.tgGrpCstmrAdr.getSelectedToggle().equals(this.rdbtnCstmrAdrTrue)) {

            txtAdress.setText(selectedCustomer.getBillingAdress());
            txtCity.setText(selectedCustomer.getBillingCity());
            txtPostalCode.setText(selectedCustomer.getBillingPostalCode());
        }
        if (this.tgGrpCstmrAdr.getSelectedToggle().equals(this.rdbtnCstmrAdrFalse)) {
            txtAdress.setText("");
            txtCity.setText("");
            txtPostalCode.setText("");
        }

    }

    public void computeInsuranceAmount() {

        String buildingType = "";
        String construction = "";
        String standard = "";
        int area = 0;
        int insuranceAmountBuilding = 0;
        int insuranceAmountHouseHold = 0;

        if (!cmBxBuildingType.getSelectionModel().isEmpty() &&
                !cmBxConstruction.getSelectionModel().isEmpty() &&
                !cmBxHseStndnd.getSelectionModel().isEmpty()) {

            buildingType = cmBxBuildingType.getSelectionModel().getSelectedItem().toString();
            construction = cmBxConstruction.getSelectionModel().getSelectedItem().toString();
            standard = cmBxHseStndnd.getSelectionModel().getSelectedItem().toString();
            area = spnrArea.getValue();
            insuranceAmountBuilding = spnInsrncValueBldng.getValue();
            insuranceAmountHouseHold = spnInsrncValueHsHld.getValue();

            //System.out.println(buildingType + " " + construction + " " + standard+" areal:"+ area+ "bygningverdi:" +insuranceAmountBuilding + "innboverdi:"+ insuranceAmountHouseHold);

            ComputeInsuranceAmount insuranceAmount = new ComputeInsuranceAmount();

            lblComputedInsrncAmnt.setText(String.format("%.2f",insuranceAmount.computeHouseInsuranceAmount(
                    buildingType,construction,standard,area,insuranceAmountBuilding,insuranceAmountHouseHold)));
        }
    }


    public void createInsrnc() {

        String customerID = selectedCustomer.getCustomerID();
        int insuranceValueHouseHold = spnInsrncValueHsHld.getValue();
        int insuranceValueBuilding = spnInsrncValueBldng.getValue();
        double insuranceValue = insuranceValueBuilding+insuranceValueBuilding;
        String insuranceConditions = txtInsrncCond.getText();

        int day = dtpckDateInsrncCrtd.getValue().getDayOfMonth();
        int month = dtpckDateInsrncCrtd.getValue().getMonthValue();
        int year = dtpckDateInsrncCrtd.getValue().getYear();

        String buildingType = cmBxBuildingType.getSelectionModel().getSelectedItem();
        String buildingStandard = cmBxHseStndnd.getSelectionModel().getSelectedItem();
        String buildingConstruction = cmBxConstruction.getSelectionModel().getSelectedItem();
        int area = spnrArea.getValue();
        //double insuranceAmount = Double.parseDouble(lblComputedInsrncAmnt.getText());
        double insuranceAmount = ComputeInsuranceAmount.computeHouseInsuranceAmount(buildingType,buildingConstruction,
                buildingStandard,area,insuranceValueBuilding,insuranceValueHouseHold);
        String adress = txtAdress.getText()+" "+txtPostalCode.getText()+" "+txtCity.getText();

        MyDate dateInsuranceCreated = new MyDate(day,month,year);

        System.out.println(insuranceValueHouseHold);

        try {
            newObjectCreator.houseInsuranceCreator(customerID, insuranceAmount, insuranceValue,
                    dateInsuranceCreated, insuranceConditions, adress, buildingType, buildingConstruction, buildingStandard, area, insuranceValueBuilding, insuranceValueHouseHold);

            gotoShowAllInsurances();
        } catch (InvalidInsuranceInputException e) {
            System.err.printf( e.getMessage());
        } catch (Exception e) {
            System.out.println("gotoshowallinsurances funker ikke");
        }
    }


    /*



    INIT    aøsldkfjasødlfjasølkdjfaølksdfjølksajfølasdfjaølsfjkd




     */


    @SuppressWarnings("Duplicates")
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabHouseInsrnc.setDisable(true);
        tabBoatInsrnc.setDisable(true);
        tabTrvlInsrnc.setDisable(true);

        lblSelectedCustomer.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null){
                tabHouseInsrnc.setDisable(false);
                tabBoatInsrnc.setDisable(false);
                tabTrvlInsrnc.setDisable(false);
            } else {
                tabHouseInsrnc.setDisable(true);
                tabBoatInsrnc.setDisable(true);
                tabTrvlInsrnc.setDisable(true);
            }
        });

        /*insuranceTabs.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            if (newValue.equals(tabHouseInsrnc)) {
                System.out.println("husforsikring");
                computeInsuranceAmount();
            }
            if (newValue.equals(tabBoatInsrnc)) {
                System.out.println("båt");
            }
            if (newValue.equals(tabTrvlInsrnc)) {
                System.out.println("reise");
            }
        }));

        /*--------------------INIT SELECT CUSTOMER TAB---------------------------*/

        // TODO   dette bør flyttes over til backend...

        /*---SELECT CUSTOMER START---*/
        //Oppretter kolonner og henter celleverdier fra Customerarrayet
        tblColCustomerFirstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        tblColCustomerLastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        tblColCustomerId.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerID"));


        // Putter observablelist inn i filteredlist
        FilteredList<Customer> filteredData = new FilteredList<>(list, p -> true);

        //Lytter på txtFilterCustomers og setter verdi som filtrerer filteredData
        txtFilterCustomers.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // filteredData returnerer alt hvis txtFilterCustomers er tom.
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
        SortedList<Customer> sortedData = new SortedList<>(filteredData);


        //Binder sammen comparatorene i sortedlist og tblVwCustomers
        sortedData.comparatorProperty().bind(tblVwCustomers.comparatorProperty());

        // Legger til sortert og filtrert liste i tabellen.
        tblVwCustomers.setItems(sortedData);

        /*---SELECT CUSTOMER END---*/

        // Setter tekst for å vise hvilken kunde som er valgt, setter selectedCustomervariabelen til valgte kunde.

        tblVwCustomers.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            //TODO mulig denne bør bygges om å heller bruke mouseevent enn listener, slik at man feks må dobbelklikke
            if (newValue == null) {
                lblSelectedCustomer.setText("Velg kunde i tabellen til venstre");


            } else {
                lblSelectedCustomer.setText(String.format("Ny forsikringavtale opprettes for : %s %s (KundeID: %s )",
                        newValue.getFirstName(),
                        newValue.getLastName(),
                        newValue.getCustomerID()));


                selectedCustomer = newValue;

                rdbtnCstmrAdrTrue.setSelected(true);

                customerAdressEqualsHouseAdress();

            }
        }));


        /*-------------------------------INIT CREATE HOUSE_INSURANCE_TAB--------------------------------*/

        //Initierer combobox med forhåndsdefinerte verdier
        cmBxBuildingType.getItems().addAll("Villa", "Leilighet", "Næringsbygg", "Fritidsbolig");
        cmBxConstruction.getItems().addAll("Reisverk(tre)", "Murstein", "Stål/Betong", "Laft(tre)", "Papp");
        cmBxHseStndnd.getItems().addAll("Lav", "Middels", "Høy");

        // Definerer spinnernes lovlige verdier.

        /*

        For spinners: (int min, int, max, int initialValue, int amountToStepBy)

         */


        SpinnerValueFactory<Integer> areaValuesFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10,1000,10, 10);

        spnrArea.setValueFactory(areaValuesFactory);

        SpinnerValueFactory<Integer> InsrncAmntBldngVF =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(100000,10000000,500000,10000);

        spnInsrncValueBldng.setValueFactory(InsrncAmntBldngVF);

        SpinnerValueFactory<Integer> InsrncAmntHsHldVF =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10000,1000000,50000,1000);

        spnInsrncValueHsHld.setValueFactory(InsrncAmntHsHldVF);

        // Listener som starter beregning av årlig kostnad, når spinnerverdier endres
        spnrArea.getEditor().textProperty().addListener(observable -> computeInsuranceAmount());
        spnInsrncValueBldng.getEditor().textProperty().addListener(observable -> computeInsuranceAmount());
        spnInsrncValueHsHld.getEditor().textProperty().addListener(observable -> computeInsuranceAmount());


        //Radiobuttons for å velge samme adresse som kundens
        tgGrpCstmrAdr = new ToggleGroup();
        this.rdbtnCstmrAdrFalse.setToggleGroup(tgGrpCstmrAdr);
        this.rdbtnCstmrAdrTrue.setToggleGroup(tgGrpCstmrAdr);

        // Setter datepicker til dagens dato, og disabler datoer før dagen i dag.

        dtpckDateInsrncCrtd.setValue(LocalDate.now());

        dtpckDateInsrncCrtd.setDayCellFactory(datePicker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });


        /*-------------------------------INIT CREATE BOAT_INSURANCE_TAB--------------------------------*/

        //Initierer combobox med forhåndsdefinerte verdier
        cmBxBoatType.getItems().addAll("Robåt", "Motorbåt", "Seilbåt", "Ubåt", "Yacht", "Fregatt");
        cmBxModel.getItems().addAll("Bertram", "Lund", "Pioner", "Smart Rib", "Yamarin");
        //txtOperation.getItems().addAll("Ingen", "Påhengsmotor", "Innebygd", "Innebygd med akterstyring");

        // Definerer spinnernes lovlige verdier.
        SpinnerValueFactory<Integer> feetValuesFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(6,1500,1, 30);

        spnrArea.setValueFactory(feetValuesFactory);

        SpinnerValueFactory<Integer> InsrncAmntBoatVF =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1000,10000000,10000,1000);

        spnrValueBoat.setValueFactory(InsrncAmntBoatVF);

        /*SpinnerValueFactory<Integer> InsrncAmntHsHldVF =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10000,1000000,1000,1000);

        spnInsrncValueHsHld.setValueFactory(InsrncAmntHsHldVF);*/

        // Listener som starter beregning av årlig kostnad, når spinnerverdier endres
        spnrFeet.getEditor().textProperty().addListener(observable -> computeBoatInsuranceAmount());
        spnrValueBoat.getEditor().textProperty().addListener(observable -> computeBoatInsuranceAmount());
        /*spnInsrncValueHsHld.getEditor().textProperty().addListener(observable -> computeInsuranceAmount());*/

        //Radiobuttons for å velge samme eier som kunden
        tgGrpCstmrOwner = new ToggleGroup();
        this.rdbtnCstmrOwnerFalse.setToggleGroup(tgGrpCstmrOwner);
        this.rdbtnCstmrOwnerTrue.setToggleGroup(tgGrpCstmrOwner);

        // Setter datepicker til dagens dato, og disabler datoer før dagen i dag.
        dtpckDateBoatInsrncCrtd.setValue(LocalDate.now());
        dtpckDateBoatInsrncCrtd.setDayCellFactory(datePicker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

        /*-----------------------------INIT CREATE TRAVEL_INSURANCE_TAB--------------------------------*/

        // Listener som starter beregning av årlig kostnad, når spinnerverdien endres
        spnrValueTravel.getEditor().textProperty().addListener(observable -> computeTravelInsuranceAmount());

        // Definerer spinnerns lovlige verdier.
        SpinnerValueFactory<Integer> amountValuesFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10000,1000000,1000, 10000);

        spnrValueTravel.setValueFactory(amountValuesFactory);

        // Setter datepicker til dagens dato, og disabler datoer før dagen i dag.
        dtpckDateTravelInsrncCrtd.setValue(LocalDate.now());
        dtpckDateTravelInsrncCrtd.setDayCellFactory(datePicker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

    }
}

