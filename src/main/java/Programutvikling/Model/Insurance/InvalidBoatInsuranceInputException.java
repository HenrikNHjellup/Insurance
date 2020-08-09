package Programutvikling.Model.Insurance;
// for feilhåndtering av inputvariabler når forsikringer opprettes.

public class InvalidBoatInsuranceInputException extends InvalidInsuranceInputException {

    public InvalidBoatInsuranceInputException(String msg) {
        super(msg);

        // Implementer varsling til bruker
    }
}
