package Exceptions;

public class InvalidLocationException extends Exception{
    public InvalidLocationException(Exception e){
        super("Invalid location for file.",e);
    }
}
