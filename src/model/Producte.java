package model;

abstract  class Producte {
        protected int preu;
        protected String nom;
        protected String barcode;

    public Producte(int preu, String nom, String barcode) {
        this.preu = preu;
        this.nom = nom;
        this.barcode = barcode;
    }

    public abstract double calcularPreu();
}
