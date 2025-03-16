package model;

public class NegatiuException extends Exception{
    private Integer valor;

    public NegatiuException(String message, Integer n){
        super(message);
        this.valor = n;
    }

    public String toString(){
        return String.format("NegatiuException: %s %nEl numero: %d", getMessage(), valor) ;
    }
}
