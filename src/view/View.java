package view;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class View {

    /**
     * Funcio per mostrar el Menu d'Inici
     */
    public static void displayIniciMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("-- Inici ------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("1) Gestió Magatzem i Compres");
        System.out.println("2) Introduir Producte");
        System.out.println("3) Passar per caixa");
        System.out.println("4) Mostrar el carret");
        System.out.println("0) Acabar");
    }

    /**
     * Funcio per mostrar el Menu de Producte
     */
    public static void displayProducteMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("-- Producte ---------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("1) Alimentació");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electrònica");
        System.out.println("0) Tornar");
    }
    /**
     * Funcio per mostrar el Menu de Gestió Magatzem i Compres
     */
    public static void displayManagementMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("-- Gestió Magatzem i Compres ----------------");
        System.out.println("---------------------------------------------");
        System.out.println("1) Caducitat");
        System.out.println("2) Tiquets de compra");
        System.out.println("3) Composició textil");
        System.out.println("0) Tornar");
    }

    /**
     * Funcio per mostrar el Carret
     * @param cart El carret com a HashMap
     */
    public static void showCart(Map<String, Integer> cart){
        System.out.println("---------------------------------------------");
        System.out.println("--- Carret ----------------------------------");
        System.out.println("---------------------------------------------");
        for (Map.Entry<String, Integer> producte :  cart.entrySet()){
            System.out.println(producte.getKey() + " --> " + producte.getValue());
        }
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    /**
     * Funcio per generar el tiquet
     * @param hashmapCart El carret com a HashMap
     * @param cart El carret com a ArrayList
     */
    public static void printReciept(Map<String, Integer> hashmapCart, ArrayList<Producte> cart) {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("SAPAMERKAT");
        System.out.println("---------------------------------------------");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("---------------------------------------------");

        // Ordenar productes perque surtin Alimentacio primer segon la data de caducitat, i despres l'altres productes
        List<Producte> sortedCart = cart.stream()
                .sorted(new ProducteComparator())
                .toList();

        double total = 0;

        for (Producte producte : sortedCart) {
            String nom = producte.getNom();
            int qt = hashmapCart.getOrDefault(nom, 1);
            double price = Model.getProductPrice(nom);
            total += price * qt;

            System.out.printf("Nom: %-20s %-2d %-10.2f %-10.2f%n",
                    nom, qt, price, price * qt);
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Total:%10.2f%n", total);
        System.out.println("---------------------------------------------");
        System.out.println();
    }


    /**
     * Funcio per mostrar a l'usuari els productes al carret en funcio de la caducitat
     * @param cart Els productes per mostrar
     */
    public static void printCaducitat(ArrayList<Producte> cart){
        System.out.println("---------------------------------------------");
        System.out.println("--- Caducitat -------------------------------");
        System.out.println("---------------------------------------------");
        ArrayList<Producte> sortedCart = new ArrayList<>(cart);
        sortedCart.sort(new ProducteComparator());
        sortedCart.forEach(producte -> {
            System.out.printf("Nom: %-20s", producte.getNom());
            if (producte instanceof Alimentacio) System.out.printf("Caducitat: %-10s%n", ((Alimentacio) producte).getDataCaducitat());
            else System.out.println();
        });

        cart.stream()
                .filter(producte -> producte instanceof Alimentacio)
                .sorted(new ProducteComparator())
                .forEach(producte -> {
                    Alimentacio a = (Alimentacio) producte;
                    System.out.printf("Nom: %-20s Caducitat: %-10s%n", a.getNom(), a.getDataCaducitat());
                });
    }

    public static void printTextil(ArrayList<Producte> cart){
        System.out.println("---------------------------------------------");
        System.out.println("--- Textils ---------------------------------");
        System.out.println("---------------------------------------------");
        cart.stream()
                .filter(producte -> producte instanceof Textil) // Nomes agafa textils
                .sorted(new ProducteComparator())
                .forEach(producte ->
                        System.out.printf("Nom: %-20s Composició: %-10s%n",
                                producte.getNom(), ((Textil) producte).getComposicio())
                );

    }


}
