package Programutvikling.Model.Insurance;
/* klasse for å validere inputvariable til BoatInsurance */


public class CheckValidBoatInsuranceInput {


    public static boolean checkValidBoatOwnerLastName(String OwnerLastName)
            throws InvalidBoatInsuranceInputException {
        if (1==2) {
            throw new InvalidBoatInsuranceInputException
                    ("Melding etternavn");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatOwnerFirstName(String OwnerFirstName)
            throws InvalidBoatInsuranceInputException {
        if (1==2) {
            throw new InvalidBoatInsuranceInputException
                    ("Melding fornavn");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatRegistrationId(String registrationId)
            throws InvalidBoatInsuranceInputException {
        if (! java.util.regex.Pattern.matches("[a-zA-Z]{3}+[0-9]{3}",registrationId) ){

            throw new InvalidBoatInsuranceInputException
                    ("Registreringsnummeret har feil format");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatType(String boatType)
            throws InvalidBoatInsuranceInputException {
        if (1==2) {
            throw new InvalidBoatInsuranceInputException
                    ("Melding");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatModel(String model)
            throws InvalidBoatInsuranceInputException {
        if (1==2) {
            throw new InvalidBoatInsuranceInputException
                    ("Melding");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatLength(int length)
            throws InvalidBoatInsuranceInputException {
        if (length < 5) {
            throw new InvalidBoatInsuranceInputException
                    ("Vi forsikrer ikke båter mindre enn 6 fot");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatRegistrationYear(int registrationYear)
            throws InvalidBoatInsuranceInputException {
        if (1==2) {
            throw new InvalidBoatInsuranceInputException
                    ("Melding");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatOperation(String operation)
            throws InvalidBoatInsuranceInputException {
        if (1==2) {
            throw new InvalidBoatInsuranceInputException
                    ("Melding");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean checkValidBoatPower(int power)
            throws InvalidBoatInsuranceInputException {
        if (power < 1) {
            throw new InvalidBoatInsuranceInputException
                    ("Man kan ikke forsikre båten som motorbåt hvis den har færre hestekrefter enn 1");
        }
        return true; // InsuranceInput is valid
    }

}