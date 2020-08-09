package Programutvikling.Model.Insurance;

public class CheckValidHouseInsuranceInput {


    public static boolean CheckValidHouseAdress(String houseAdress)
            throws InvalidInsuranceInputException {
        if (houseAdress != houseAdress) {
            throw new InvalidInsuranceInputException
                    ("Melding husadresse");
        }
        return true; // InsuranceInput is valid
    }

    public static boolean CheckValidBuildingType(String buildingType)
            throws InvalidInsuranceInputException {
        if (buildingType != buildingType) {
            throw new InvalidInsuranceInputException
                    ("Melding bygningstype");
        }
        return true; // InsuranceInput is valid
    }
    public static boolean CheckValidConstruction(String construction)
            throws InvalidInsuranceInputException {
        if (construction != construction) {
            throw new InvalidInsuranceInputException
                    ("Melding bygningsmateriale/ konstruksjon");
        }
        return true; // InsuranceInput is valid
    }
    public static boolean CheckValidBuildingStandard(String buildingStandard)
            throws InvalidInsuranceInputException {
        if (buildingStandard != buildingStandard) {
            throw new InvalidInsuranceInputException
                    ("Melding bygningsstandard");
        }
        return true; // InsuranceInput is valid
    }
    public static boolean CheckValidBuildingArea(int buildingArea)
            throws InvalidInsuranceInputException {
        if (buildingArea != buildingArea) {
            throw new InvalidInsuranceInputException
                    ("Melding areal");
        }
        return true; // InsuranceInput is valid
    }
    public static boolean CheckValidInsuranceAmountBuiliding(int insuranceAmountBuilding)
            throws InvalidInsuranceInputException {
        if (insuranceAmountBuilding != insuranceAmountBuilding) {
            throw new InvalidInsuranceInputException
                    ("Melding forsikringsbeløp bygning");
        }
        return true; // InsuranceInput is valid
    }
    public static boolean CheckValidInsureAmountHousehold(int insuranceAmountHousehold)
            throws InvalidInsuranceInputException {
        if (insuranceAmountHousehold != insuranceAmountHousehold) {
            throw new InvalidInsuranceInputException
                    ("Melding forsikringsbeløp innnbo");
        }
        return true; // InsuranceInput is valid
    }

}
