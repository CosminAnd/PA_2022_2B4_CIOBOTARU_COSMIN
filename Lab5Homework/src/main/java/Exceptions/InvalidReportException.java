package Exceptions;

public class InvalidReportException extends Exception{
    public InvalidReportException(Exception e){
        super("Report fail.",e);
    }
}
