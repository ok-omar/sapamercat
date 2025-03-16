package model;

public class DataCaducidadException extends Exception {
    private String missatge;

    public DataCaducidadException(String missatge) {
        this.missatge = missatge;
    }

    public String toString () {
        return "Exception DataCaducidadException: " +
                missatge;
    }
}
