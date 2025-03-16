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
    public static void convertCartToHashmap() {
        // Buidar el map
        convertedCart.clear();

        for (Producte producte : cart) {
            // Utilitzar el barcode com a key, y la qt com a value
            convertedCart.put(producte.getBarcode(), convertedCart.getOrDefault(producte.getBarcode(), 0) + 1);
        }
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

    public static boolean verifyDuplicates(Producte t){
        boolean duplicate = false;
        for(Producte p : cart){
            if (p.getBarcode().equals(t.getBarcode())) {
                duplicate = true;
                break;
            }
        }
        return duplicate;

    }



}
