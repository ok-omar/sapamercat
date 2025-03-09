package view;

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
        System.out.println();
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
        System.out.println();
    }
    // showCart(list)  *list is most likely a key-value collection type

    // showReceipt(list)
}
