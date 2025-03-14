package model;
import java.util.*;

public class Model {

    private static LinkedList<ArrayList<Producte>> registres = new LinkedList<>();
    private static ArrayList<Producte> cart = new ArrayList<Producte>();

    // Declaracio del variable on es guardara el carret en format hashmap
    private static Map<String, Integer> convertedCart = new HashMap<>();
    /**
     * Funcio per convertir el carret a hashmap
     */
    public static void convertCartToHashmap(){
        for(Producte producte : cart){
            convertedCart.put(producte.getNom(), convertedCart.getOrDefault(producte.getNom(), 0) + 1);
        }
    }

    /**
     * Funcio per buscar el preu d'un producte
     * @param nom El nom del producte que volem saber el seu preu
     * @return El preu del producte
     */
    public static double getProductPrice(String nom){
        for (Producte product : cart){
            if (nom.equals(product.getNom())) return product.calcularPreu();
        }
        return -1;
    }

    public static void guardarTicket(){
        registres.add(cart);
    }

    public static void emptyCart(){
        convertedCart.clear();
        cart.clear();
    }

    public static void addToCart(Producte p){
        cart.add(p);
    }

    public static ArrayList<Producte> getCart(){
        return cart;
    }

    public static Map<String, Integer> getHashmapCart(){
        return convertedCart;
    }


}
