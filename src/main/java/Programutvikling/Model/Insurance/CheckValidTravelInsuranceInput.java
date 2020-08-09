package Programutvikling.Model.Insurance;

public class CheckValidTravelInsuranceInput {




    /* klasse for å validere inputvariable til Insurance */

    public static boolean CheckValidInsuranceRange(String insuranceRange)
            throws InvalidInsuranceInputException {
        if (insuranceRange != insuranceRange) {
            //TODO bygg denne
            throw new InvalidInsuranceInputException
                    ("Melding område");
        }
        return true; // InsuranceInput is valid
    }
    public static boolean CheckValidTravelInsuranceAmount(int travelInsuranceAmount)
            throws InvalidInsuranceInputException {
        if (travelInsuranceAmount < 10000 || travelInsuranceAmount > 100000) {
            throw new InvalidInsuranceInputException
                    ("Vi tilbyr ikke reiseforsikringer med lavere dekning enn 10 000 kr, eller høyere enn 100 000 kr ");
        }
        return true; // InsuranceInput is valid
    }

    // lag metoder for hver variabel som må sjekkes
}
