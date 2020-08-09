package Programutvikling.Model.Insurance;

import Programutvikling.Model.MyDate;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;


/* klasse for å validere inputvariable til Insurance */


public class CheckValidInsuranceInput {


    public static boolean checkValidInsuranceNumber(int customerId)
            throws InvalidInsuranceInputException {
                /* TODO Her må det håndteres annerledes hvis vi bytter til forsingringsID / customerID ...
                test om insuranceNumber finnes i kundeArrayet hvis true :
                Kanskje kun nødvendig hvis man har mulighet til å skrive inn insuranceNumber selv.
                 */

        if (false)
            throw new InvalidInsuranceInputException("Forsikringsnummeret finnes ikke i registeret");

        return true; // InsuranceInput is valid
    }
    //Forrige metode er overloadet for å kunne håndtere customerId som string og som Integer
    public static boolean checkValidInsuranceNumber(String customerId)
            throws InvalidInsuranceInputException {
                /* TODO Her må det håndteres annerledes hvis vi bytter til forsingringsID / customerID ...
                test om insuranceNumber finnes i kundeArrayet hvis true :
                Kanskje kun nødvendig hvis man har mulighet til å skrive inn insuranceNumber selv.
                 */

        if (false)
            throw new InvalidInsuranceInputException("Forsikringsnummeret finnes ikke i registeret");

        return true; // InsuranceInput is valid
    }

    public static boolean checkValidInsuranceAmount(double insuranceAmount)
            throws InvalidInsuranceInputException {

        if (insuranceAmount <= 0) {
            throw new InvalidInsuranceInputException
                    ("Årlig forsikringsbeløp må være mer enn null kroner");
        }

        return true; // InsuranceInput is valid
    }

    public static boolean checkValidInsuranceValue(double insuranceValue)
            throws InvalidInsuranceInputException {

        if (insuranceValue < 1000 || insuranceValue > 10_000_000) {
            throw new InvalidInsuranceInputException
                    ("Vi forsikrer ikke objekter for mindre enn 1000 eller mer enn 10 millioner kr");
        }

        return true; // InsuranceInput is valid
    }


    // Tester om forsikringen opprettes på et tidspunkt før 00.00 i dag:

    public static boolean checkValidDateInsuranceCreated(MyDate dateInsuranceCreated)
            throws InvalidInsuranceInputException {

        MyDate myToday = new MyDate();

        if (dateInsuranceCreated.before(myToday)) {
            throw new InvalidInsuranceInputException
                    ("Forsikringen kan ikke opprettes tilbake i tid, velg dagen i dag eller frem i tid");
        }

        return true; // InsuranceInput is valid
    }

    public static boolean checkValidInsuranceConditions(String insuranceConditions) throws InvalidInsuranceInputException {
        File vilkaar = new File(insuranceConditions);
        if (// !vilkaar.exists()) blir trøbbel på annen pc med annen mappestruktur
                false )
        {
            throw new InvalidInsuranceInputException
                    ("Finner ikke dokumentet for forsikringsvilkår i mappen du oppga");
        }

        return true; // InsuranceInput is valid
    }


}
