package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    public static Map<String, Integer> convertCartToHashmap(ArrayList<Producte> cart){
        Map<String, Integer> convertedCart = new HashMap<>();
        for(Producte producte : cart){
            convertedCart.put(producte.getNom(), convertedCart.getOrDefault(producte.getNom(), 0) + 1);
        }
        return convertedCart;
    }

    /**
     * Funcio per buscar el preu d'un producte
     * @param nom El nom del producte que volem saber el seu preu
     * @param cart L'array list de tots els productes que tenim
     * @return El preu del producte
     */
    public static double getProductPrice(String nom, ArrayList<Producte> cart){
        for (Producte product : cart){
            if (nom.equals(product.getNom())) return product.calcularPreu();
        }
        return -1;
    }
}
