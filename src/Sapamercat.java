import model.Alimentacio;
import model.Electronica;
import model.Producte;
import model.Textil;
import view.View;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sapamercat {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Producte> cart = new ArrayList<Producte>();
        while (true){
            View.displayIniciMenu();
            int input = getNumeroValid();
            switch (input){
                case 1:
                    ///
                    break;
                case 2:
                    cart = getProductes();
                    break;
                case 3:
                    ///
                    break;
                case 4:
                    ///
                    break;
                case 0:
                    return;
            }

        }




    }

    public static ArrayList<Producte> getProductes(){
        while (true){
            ArrayList<Producte> cart = new ArrayList<Producte>();
            View.displayProducteMenu();
            int input = getNumeroValid();
            switch (input){
                case 1:
                    cart.add(getAlimentacio());
                    break;
                case 2:
                    cart.add(getTextil());
                    break;
                case 3:
                    cart.add(getElectronica());
                    break;
                case 0:
                    return cart;
            }
        }

    }


    /**
     * Funcio per agafar un producte (Alimentacio) introduit per l'usuari
     * @return L'objecte (Alimentacio)
     */
    public static Producte getAlimentacio(){
        System.out.println("Afegir aliment");
        System.out.print("Nom producte: ");
        String nom = scanner.nextLine();
        System.out.print("Preu: ");
        int preu = scanner.nextInt();
        System.out.print("Codi de barres: ");
        String barcode = scanner.nextLine();
        System.out.print("Data de caducitat (dd/mm/yyyy): ");
        String dataCaducidad = scanner.nextLine();

        return new Alimentacio(preu, nom, barcode, dataCaducidad);
    }

    /**
     * Funcio per agafar un producte (Textil) introduit per l'usuari
     * @return L'objecte (Textil)
     */
    public static Producte getTextil(){
        System.out.println("Afegir aliment");
        System.out.print("Nom producte: ");
        String nom = scanner.nextLine();
        System.out.print("Preu: ");
        int preu = scanner.nextInt();
        System.out.print("Composicio: ");
        String composicio = scanner.nextLine();
        System.out.print("Codi de barres: ");
        String barcode = scanner.nextLine();


        return new Textil(preu, nom, barcode, composicio);
    }

    /**
     * Funcio per agafar un producte (Electronica) introduit per l'usuari
     * @return L'objecte (Electronica)
     */
    public static Producte getElectronica(){
        System.out.println("Afegir aliment");
        System.out.print("Nom producte: ");
        String nom = scanner.nextLine();
        System.out.print("Preu: ");
        int preu = scanner.nextInt();
        System.out.print("Garantia (dies): ");
        int garantia = scanner.nextInt();
        System.out.print("Codi de barres: ");
        String barcode = scanner.nextLine();


        return new Electronica(preu, nom, barcode, garantia);
    }

    private static int getNumeroValid() {
        while (true) {
            try {
                int number = scanner.nextInt();

                // Verificar si el numbero en el rang 0-4
                if (number >= 0 && number <= 4) {
                    return number;
                } else {
                    System.out.println("Numero invalid, introduiex un numero en el rang (0-4)");
                }

            } catch (InputMismatchException e) {
                System.out.println("El valor ha de ser un numbero");
                scanner.next(); // Elimininar invalid input
            }
        }
    }


}