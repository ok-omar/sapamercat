package model;
import java.util.Comparator;

public class ProducteComparator implements Comparator<Producte>{
    @Override
    public int compare(Producte p1, Producte p2){
        // Si el p1 és Alimentacio
        if (p1 instanceof Alimentacio){
            // Si p2 es alimentacio, ordena per data caducitat
            if (p2 instanceof Alimentacio){
                return ((Alimentacio) p1).getDataCaducitat().compareTo(((Alimentacio) p2).getDataCaducitat());
            } else {
                // Sino, retorna -1 (Alimentacio va primer)
                return -1;
            }

        // Si el p1 és Textil
        } else if (p1 instanceof Textil){
            // Si p2 és Alimentacio
            if (p2 instanceof Alimentacio){
                // return 1 (Alimentacio va primer, Textil segon)
                return 1;
            // Si el p2 també és textil
            } else if (p2 instanceof Textil) {
                // ordena per composició
                return (((Textil) p1).getComposicio().compareTo(((Textil) p2).getComposicio()));

            // Si p2 és Electronica
            } else if (p2 instanceof Electronica){
                // return -1 (Textil va primer, Electronica segon)
                return -1;
            }

        // Si el p1 és Electronica
        } else if (p1 instanceof Electronica) {
            // Si p2 és electronica, manté l'ordre
            if (p2 instanceof Electronica){
                return 0;

            // Si p2 és Alimentacio o Textil, van primer y Electronica segon
            } else {
                return 1;
            }
        }
        // Si no és de cap tipus de producte que tenim, manté l'ordre
        return 0;
    }
}
