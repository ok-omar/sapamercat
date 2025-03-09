package model;

public abstract  class Producte {
        protected int preu;
        protected String nom;
        protected String barcode;

    public Producte(int preu, String nom, String barcode) {
        this.preu = preu;
        this.nom = nom;
        this.barcode = barcode;
    }

    public abstract double calcularPreu();

    // Getters

    public int getPreu() {
        return preu;
    }

    public String getNom() {
        return nom;
    }

    public String getBarcode() {
        return barcode;
    }

    // Setters

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
