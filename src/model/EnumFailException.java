package model;

public class EnumFailException extends Exception{
    private String message;

    public EnumFailException(String message) {
        super(message);
    }

    public String toString(){
        return String.format("EnumFailException: %s", getMessage());
    }
}
