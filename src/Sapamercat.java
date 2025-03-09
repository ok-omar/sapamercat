import model.Alimentacio;
import model.Electronica;
import model.Producte;
import model.Textil;

import java.util.Scanner;

public class Sapamercat {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {



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


}