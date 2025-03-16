package model;

public class LimitCaracteresException extends Exception{
    private int limit;

    public LimitCaracteresException(String message, int limit) {
        super(message);
        this.limit = limit;
    }

    public String toString(){
        return String.format("LimitCaracteresException:  %s ( limit de caracters %d)", getMessage(), limit);
    }
}
