package model;

public class Textil extends Producte{
    protected String composicio;

    public Textil(int preu, String nom, String barcode, String composicio) {
        super(preu, nom, barcode);
        this.composicio = composicio;
    }

    @Override
    public double calcularPreu() {
        return preu;
    }
}
