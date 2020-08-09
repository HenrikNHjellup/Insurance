module InsuranceProgram {
    requires javafx.controls;
    requires java.desktop; // Måtte fylle inn den her for å få programmet til å åpne filer i default desktopprogram.
    requires javafx.fxml;

    opens View to javafx.fxml;
    opens Programutvikling.Model.FilerForSletting.TempForTesting to javafx.base;
    opens Programutvikling.Model.Insurance to javafx.base;
    opens Programutvikling.Model to javafx.base, javafx.fxml;
    opens Programutvikling.Controller to javafx.fxml;
    opens Programutvikling.Model.Customer to javafx.base;
    opens Programutvikling to javafx.base;
    opens Programutvikling.Controller.CreateInsuranceControllers to javafx.fxml;
    exports Programutvikling;
    exports Programutvikling.Controller;
    exports Programutvikling.Controller.CreateInsuranceControllers to javafx.fxml;
}