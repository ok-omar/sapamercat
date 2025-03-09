package model;

public class Electronica extends Producte{

    protected int diesGarantia;

    public Electronica(int preu, String nom, String barcode, int diesGarantia) {
        super(preu, nom, barcode);
        this.diesGarantia = diesGarantia;
    }

    // Getter
    public int getDiesGarantia() {
        return diesGarantia;
    }

    // Setter


    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    @Override
    public double calcularPreu() {
        return preu + preu * ( (double) diesGarantia / 365 ) * 0.1;
    }
}
