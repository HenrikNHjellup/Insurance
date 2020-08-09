package Programutvikling.Model.Readers;

public class InvalidAccidentReportInputException extends Exception{
    public InvalidAccidentReportInputException(String msg) {
        super(msg);

        // Implementer varsling til bruker
    }
}
