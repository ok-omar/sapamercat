package model;

public class Electronica extends Producte{

    protected int diesGarantia;

    public Electronica(int preu, String nom, String barcode, int diesGarantia) {
        super(preu, nom, barcode);
        this.diesGarantia = diesGarantia;
    }

    @Override
    public double calcularPreu() {
        return preu + preu * ( diesGarantia / 365 ) * 0.1;
    }
}
