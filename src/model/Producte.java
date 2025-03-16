package model;

public abstract  class Producte implements Comparable<Producte>{
        protected float preu;
        protected String nom;
        protected String barcode;

    public Producte(float preu, String nom, String barcode) {
        this.preu = preu;
        this.nom = nom;
        this.barcode = barcode;
    }

    public abstract double calcularPreu();

    @Override
    public int compareTo(Producte altreProducte) {
        // Comparar pel nom
        int nameComparison = nom.compareTo(altreProducte.getNom());

        // Si els noms no son iguals, retorna el resultat
        if (nameComparison != 0) {
            return nameComparison;
        }

        // Si els noms son iguals, compara pel codi de barres
        return barcode.compareTo(altreProducte.getBarcode());
    }



    // Getters

    public float getPreu() {
        return preu;
    }

    public String getNom() {
        return nom;
    }

    public String getBarcode() {
        return barcode;
    }

    // Setters

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
