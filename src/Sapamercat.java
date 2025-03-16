import model.*;
import view.View;

import java.util.*;

public class Sapamercat {

    // Declaracio de variables globals
    // static ArrayList<Producte> cart = new ArrayList<Producte>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        // Bucle del Menu Inici
        while (true){
            View.displayIniciMenu();
            int input = getNumeroValid();
            switch (input){
                case 1:
                    // 1. Gestio de magatzem i compres
                    gestionar();
                    break;
                case 2:
                    // 2. Introduir producte
                    getProductes();
                    // Convertir el carret a HashMap
                    Model.convertCartToHashmap();
                    break;
                case 3:
                    // 3. Passar per caixa

                    // Verificar si el carret no està buit abans de passar per caixa
                    if (Model.getHashmapCart().isEmpty()){
                        System.out.println("No tens cap producte al carret!");
                        return;
                    }
                    else View.printReciept(Model.getHashmapCart(), Model.getCart());

                    // Buidar el carro
                    Model.emptyCart();
                    break;
                case 4:
                    // 4. Mostrar el carro de compra

                    // Verificar si el carret no esta buit abans de mostrar el carro de compra
                    if (Model.getHashmapCart().isEmpty()) System.out.println("El carret està buit!");
                    else View.showCart(Model.getHashmapCart());
                    break;
                case 0:
                    System.out.println("\nPrograma tancat correctament!");
                    return;
            }

        }

    }

    public static void gestionar(){
        while (true){

            // Mostrar el menu de gestio i magatzem
            View.displayManagementMenu();

            // Agafar l'input de l'usuari
            int input = getNumeroValid();

            // Switch case per cridar la funcio corresponent a l'opcio introduida per l'usuari
            switch (input){
                case 1:
                    // 1.1 Caducidad
                    ArrayList<Producte> caducitatCart = new ArrayList<>(Model.getCart());
                    View.printCaducitat(caducitatCart);
                    break;
                case 2:
                    // 1.2 Guardar Ticket de compra
                    Model.guardarTicket();
                    System.out.println("---------------------------------------------");
                    System.out.println("        Ticket guardat correctament! ");
                    System.out.println("---------------------------------------------");
                    break;
                case 3:
                    // 1.3 Composició textil
                    View.printTextil(Model.getCart());
                    break;
                case 0:
                    return;
            }
        }

    }

    /**
     * Funcio per agafar els productes
     */
    public static void getProductes(){
        while (true){
            // Mostrar el menu Producte
            View.displayProducteMenu();

            // Agafar l'input de l'usuari
            int input = getNumeroValid();


            scanner.nextLine();

            // Switch case per cridar la funcio corresponent al tipus de producte que l'usuari vol introduir
            try {
                switch (input){
                    case 1:
                        // Afegir un producte tipus Alimentacio al carret si no hem arribat al limit (100)
                        if (!Model.cartLimitReached()) Model.addToCart(getAlimentacio());
                        break;
                    case 2:
                        // Agafar un producte tipus Textil si no hem arribat al limit (100) y no hi ha duplicats
                        addIfNotDuplicate(getTextil());
                        break;
                    case 3:
                        // Afegir un producte tipus Electronica al carret si no hem arribat al limit (100)
                        if (!Model.cartLimitReached()) Model.addToCart(getElectronica());
                        break;
                    case 0:
                        return;
                }
            } catch (LimitProductesException e){
                System.out.println(e);
                System.out.println("El producte no s'afegira al carret!");
            } catch (DataCaducidadException e){
                System.out.println(e);
                System.out.println("Si us plau, introdueix una data de caducitat valida amb el format dd/mm/yyyy");
            } catch (NegatiuException e) {
                System.out.println(e);
            }

        }

    }


    /**
     * Funcio per agafar un producte (Alimentacio) introduit per l'usuari
     * @return L'objecte (Alimentacio)
     */
    public static Producte getAlimentacio() throws DataCaducidadException, NegatiuException {
        System.out.println("Afegir aliment");
        System.out.print("Nom producte: ");
        String nom = scanner.nextLine();
        System.out.print("Preu: ");
        int preu = scanner.nextInt();
        scanner.nextLine();  // Consumir la línia buida
        System.out.print("Codi de barres: ");
        String barcode = scanner.nextLine();
        System.out.print("Data de caducitat (dd/mm/yyyy): ");
        String dataCaducidad = scanner.nextLine();

        boolean matches = dataCaducidad.matches("^\\d{2}\\/\\d{2}\\/\\d{4}");

        if (preu < 0) throw new NegatiuException("El preu no pot ser negatiu", preu);

        if (!matches) throw new DataCaducidadException("La data de caducitat té el format incorrecte!");

        return new Alimentacio(preu, nom, barcode, dataCaducidad);
    }

    /**
     * Funcio per agafar un producte (Textil) introduit per l'usuari
     * @return L'objecte (Textil)
     */
    public static Producte getTextil() throws NegatiuException {
        System.out.println("Afegir Textil");
        System.out.print("Nom producte: ");
        String nom = scanner.nextLine();
        System.out.print("Preu: ");
        int preu = scanner.nextInt();
        scanner.nextLine();  // Consumir la línia buida
        System.out.print("Composicio: ");
        String composicio = scanner.nextLine();
        System.out.print("Codi de barres: ");
        String barcode = scanner.nextLine();

        if (preu < 0) throw new NegatiuException("El preu no pot ser negatiu", preu);
        return new Textil(preu, nom, barcode, composicio);
    }

    /**
     * Funcio per agafar un producte (Electronica) introduit per l'usuari
     * @return L'objecte (Electronica)
     */
    public static Producte getElectronica() throws NegatiuException {
        System.out.println("Afegir Electronica");
        System.out.print("Nom producte: ");
        String nom = scanner.nextLine();
        System.out.print("Preu: ");
        int preu = scanner.nextInt();
        scanner.nextLine();  // Consumir la línia buida
        System.out.print("Garantia (dies): ");
        int garantia = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Codi de barres: ");
        String barcode = scanner.nextLine();

        if (preu < 0) throw new NegatiuException("El preu no pot ser negatiu", preu);
        return new Electronica(preu, nom, barcode, garantia);
    }

    private static int  getNumeroValid() {
        while (true) {
            try {
                int number = scanner.nextInt();

                // Verificar si el numbero en el rang 0-4
                if (number >= 0 && number <= 4) {
                    return number;
                } else if (number < 0) {
                    throw new NegatiuException("El numero introduit no pot negatiu", number);
                } else {
                    System.out.print("Numero invalid, introduiex un numero en el rang (0-4): ");
                }

            } catch (InputMismatchException e) {
                System.out.println("El valor ha de ser un numero: ");
                scanner.next(); // Elimininar invalid input
            } catch (NegatiuException e){
                System.out.println(e);
            }
        }
    }

    private static void addIfNotDuplicate(Producte t) throws LimitProductesException {
        // Verificar si el producte introduit ja existeix al carret
        boolean duplicate = Model.verifyDuplicates(t);

        // Si no existeix, afegir el poducte al carret,
        if (!duplicate) {
            Model.addToCart(t);
        }
            // Si es un que ja existeix (duplicat), avisar l'usuari
        else System.out.printf("%s amb el codi de barres %s ja existeix! %n", t.getNom(), t.getBarcode());
    }

}