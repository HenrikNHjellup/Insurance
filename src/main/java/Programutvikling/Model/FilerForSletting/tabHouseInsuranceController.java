package Programutvikling.Model.FilerForSletting;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class tabHouseInsuranceController implements Initializable {


    @FXML public static Label customerId;
    @FXML public TextField txtAdress;
    @FXML public ComboBox cmBxBuildingType;
    @FXML public ComboBox cmBxConstruction;
    @FXML public ComboBox cmBxHseStndnd;

    @FXML  public Spinner spnrArea;
    @FXML public Spinner spnInsrncAmntHsHld;
    @FXML public Spinner spnInsrncAmntBldng;

    @FXML public RadioButton rdbtnCustomerTrue;
    @FXML  public RadioButton rdbtnCustomerFalse;

    @FXML public DatePicker dtpckDateInsrncCrtd;

    @FXML public Button btnFndInsrnceCond;




    @FXML
    public void FndInsrnceCond() {
        //TODO implementer for å finne fil
    }

    @FXML
    public void getCustomerAdress() {
        //TODO implementer for å finne fil
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        //Initierer combobox med forhåndsdefinerte verdier
        cmBxBuildingType.getItems().addAll("Villa", "Leilighet", "Næringsbygg", "Fritidsbolig");
        cmBxConstruction.getItems().addAll("Reisverk(tre)", "Murstein", "Stål/Betong", "laft(tre)", "Papp");
        cmBxHseStndnd.getItems().addAll("Lav", "Middels", "høy");

        //Initierer spinnere. forhåndsdefinerte max-min verdier er definert i fxml
        spnrArea = new Spinner();
        spnInsrncAmntBldng = new Spinner();
        spnInsrncAmntHsHld = new Spinner();

        //Radiobuttons for å velge samme adresse som kundens

        /*ToggleGroup rdbtnAdress = new ToggleGroup();
        rdbtnCstmrAdrTrue = new RadioButton();
        rdbtnCstmrAdrTrue.setToggleGroup(rdbtnAdress);
        rdbtnCstmrAdrTrue.setSelected(true);

        rdbtnCustomerFalse = new RadioButton();
        rdbtnCustomerFalse.setToggleGroup(rdbtnAdress);*/
    }
}
