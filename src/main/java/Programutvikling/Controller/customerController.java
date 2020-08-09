package Programutvikling.Controller;

import Programutvikling.Model.MyArrays;
import Programutvikling.Model.Customer.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

//Implements initializable
public class customerController extends GUImethods implements Initializable{

    @FXML
    public Label customerLabel;
    public Button homeButton;

    public customerController() throws ClassNotFoundException {
    }

    //Standard metode for alle hjem-knapper
    @FXML
    public void homeButton(ActionEvent event) throws Exception {
        gotoHome();
    }

    private ObservableList<Customer> list = FXCollections.observableArrayList(MyArrays.getCustomerList());

    @FXML
    public TableView<Customer> customerTable;
    public TableColumn nameColumn;
    public TableColumn insuranceNumberColumn;
    public TableColumn postalcodeColumn;
    //nameColumn.setCellValueFactory(data -> data.getValue().get(0));


    @FXML
    public void gotoCreateCustomerButton() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/createCustomer.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    public void gotoShowCustomer(Customer customer) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/customerInformation.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));

        customerInformationController controller = fxmlLoader.getController();
        controller.setCustomer(customer);
        // fryser allekundervinduet mens viskunde er åpen.
        stage.initOwner(customerTable.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // definerer hvilke verdier som skal inn i hvilke kolonner.
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        insuranceNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerID"));
        postalcodeColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("billingPostalCode"));

        // Henter inn verdier fra observableArraylist til tabellen.
        customerTable.setItems(list);

        customerTable.setRowFactory( tv -> {
            TableRow<Customer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Customer dblClickedCustomer = row.getItem();

                   // System.out.println(dblClickedCustomer);
                    try {
                        gotoShowCustomer(dblClickedCustomer);
                    } catch (Exception e ) {
                        System.out.println("funka ikke");
                    }


                }
            });
            return row ;
        });
    }
}