package view;
import model.Alimentacio;
import model.DataCaducitatComparator;
import model.Model;
import model.Producte;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
public class View {

    /**
     * Funcio per mostrar el Menu d'Inici
     */
    public static void displayIniciMenu(){
        System.out.println("------------");
        System.out.println("-- INICI ---");
        System.out.println("------------");
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
        System.out.println("---------------");
        System.out.println("-- Producte ---");
        System.out.println("---------------");
        System.out.println("1) Alimentació");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electrònica");
        System.out.println("0) Tornar");
    }
    /**
     * Funcio per mostrar el Menu de Gestió Magatzem i Compres
     */
    public static void displayManagementMenu(){
        System.out.println("--------------------------------");
        System.out.println("-- Gestió Magatzem i Compres ---");
        System.out.println("--------------------------------");
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
        System.out.println("Carret:");
        for (Map.Entry<String, Integer> producte :  cart.entrySet()){
            System.out.println(producte.getKey() + " --> " + producte.getValue());
        }
    }

    /**
     * Funcio per generar el tiquet
     * @param hashmapCart El carret com a HashMap
     * @param cart El carret com a ArrayList
     */
    public static void printReciept(Map<String, Integer> hashmapCart, ArrayList<Producte> cart){
        System.out.println("-------------------------------");
        System.out.println("SAPAMERKAT");
        System.out.println("-------------------------------");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("-------------------------------");
        int qt;
        double price, total = 0;
        for (Map.Entry<String, Integer> producte :  hashmapCart.entrySet()){
            price = Model.getProductPrice(producte.getKey());
            qt = producte.getValue();
            System.out.printf("%-20s %d %10.2f %10.2f%n", producte.getKey(), qt, price, (price * qt));
            total = total + price * qt;
        }
        System.out.println("-------------------------------");
        System.out.printf("Total:%10.2f%n", total);

    }

    /**
     * Funcio per mostrar a l'usuari els productes al carret en funcio de la caducitat
     * @param cart Els productes per mostrar
     */
    public static void printCaducitat(ArrayList<Producte> cart){
        cart.sort(new DataCaducitatComparator());
        cart.forEach(producte -> {
            System.out.printf("Nom: %-20s", producte.getNom());
            if (producte instanceof Alimentacio) System.out.printf("Caducitat: %-10s%n", ((Alimentacio) producte).getDataCaducitat());
            else System.out.println();
        });
    }


}
