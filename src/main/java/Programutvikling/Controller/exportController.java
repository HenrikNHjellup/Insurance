package Programutvikling.Controller;

import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.MyArrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import static Programutvikling.Model.Readers.prepareExportFiles.prepareExportFiles;

public class exportController extends GUImethods {
    @FXML
    public Label customerLabel;
    public Button homeButton, exportFileButton;


    //Standard metode for alle hjem-knapper
    @FXML
    public void homeButton() throws Exception {
        gotoHome();
    }

    private ObservableList<Customer> list = FXCollections.observableArrayList(MyArrays.getCustomerList());
    //private ObservableList<File> list =

    public void exportFile() throws Exception{
        prepareExportFiles();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("objectFiles"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        
    }

    /*
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
    }*/

    //@Override
    public void initialize(URL location, ResourceBundle resources) {
       /* // definerer hvilke verdier som skal inn i hvilke kolonner.
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

                    System.out.println(dblClickedCustomer);
                    try {
                        gotoShowCustomer(dblClickedCustomer);
                    } catch (Exception e ) {
                        System.out.println("funka ikke");
                    }


                }
            });
            return row ;
        });*/
    }
}
