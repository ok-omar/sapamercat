package model;
import java.util.*;

public class Model {
    private static final int MAX_PRODUCTES = 100;
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

    public static void addToCart(Producte p) throws LimitProductesException {
        if (cart.size() >= MAX_PRODUCTES){
            throw new LimitProductesException(cart.size());
        } else cart.add(p);
    }

    public static boolean cartLimitReached(){
        return cart.size() >= MAX_PRODUCTES;
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

    /**
     * Funcio per buscar un producte pel seu codi de barres
     * @param barcode codi de barres del producte
     * @return El nom del producte si el troba
     */
    public static String getProductByBarcode(String barcode) {
        return cart.stream()
                .filter(product -> product.getBarcode().equals(barcode)) // Filtrar per codi de barres
                .map(Producte::getNom) // Obtenir el nom del producte
                .findFirst() // Obtenir el primer producte
                .orElse("Producte no trobat"); // retorna "Producte no trobat" si no troba el producte
    }



}
