package Programutvikling.Controller;

import Programutvikling.Model.Customer.Customer;
import Programutvikling.Model.newObjectCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Programutvikling.Model.MyArrays.customerList;

//Implements initializable
public class createCustomerController extends GUImethods{

    @FXML
    public Label createCustomerLabel;

    @FXML
    public TextField firstNameField, lastNameField, phoneNumberField,
            billingAdressField, emailField, postcodeField, cityField;

    //String firstname = firstNameField.getText();


    @FXML
    public Button createCustomerButton, cancelButton;

    //ArrayList<Customer> customerList = new ArrayList<>();

    //Customer customer = new Customer(firstNameField.getText(), );

    @FXML
    public void cancelButton(ActionEvent event) throws Exception {
        closeWindow();
    }

    @FXML
    public void createCustomer(ActionEvent event) throws Exception {
        /*try {
            Customer customer = new Customer(firstNameField.getText(), lastNameField.getText(),
                    phoneNumberField.getText(), emailField.getText(),
                    billingAdressField.getText(), postcodeField.getText(), cityField.getText());
            customerList.add(customer);
            System.out.println(customerList);
        } catch (Exception e) {
            System.out.println("Feil!");
        }*/
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();
            String billingAdress = billingAdressField.getText();
            String billingPostalCode = postcodeField.getText();
            String billingCity = cityField.getText();
            try {
                newObjectCreator.customerCreator(firstName, lastName, phoneNumber, email,
                        billingAdress, billingPostalCode,billingCity);
            } finally {
                System.out.println("Customer created successfully");
            }
        }

    public void initialize(){

    }
}