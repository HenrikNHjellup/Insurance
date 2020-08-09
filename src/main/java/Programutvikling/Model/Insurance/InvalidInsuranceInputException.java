package Programutvikling.Model.Insurance;// for feilhåndtering av inputvariabler når forsikringer opprettes.

public class InvalidInsuranceInputException extends Exception {

    public InvalidInsuranceInputException(String msg) {
        super(msg);

        // Her skulle varsling til brukeren vært implementert
    }
}
