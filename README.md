## Descripció del projecte

Aquest projecte implementa una aplicació de gestió de productes en un sistema de venda. Permet afegir productes al carret de compra, gestionar el magatzem, generar tiquets de compra i consultar informació específica dels productes.

## Contingut

- **Model**: Conjunt de classes que defineixen els productes (Alimentació, Electrònica, Textil) i les operacions que poden realitzar-se sobre ells, el comparator i les excepcions personalitzades.
- **Vista**: Interfície per a mostrar diferents opcions, mostrar el carret, el tiquets, etc.
- **Controlador**: La lògica del sistema que coordina les accions de l'usuari amb el model i la vista.

## Decisions de disseny

### 1. **Model de Productes:**

Els productes es modelen com a **Producte** amb les classes **Alimentacio**, **Electronica** i **Textil** que hereten de la super classe **Producte**.

- **Producte** conté atributs comuns com el **preu**, **nom** i **barcode**.
- Cada tipus de producte té la seva funció `calcularPreu()` per calcular el preu:
    - **Alimentació**: El preu es calcula tenint en compte els dies de caducitat.
    - **Electrònica**: El preu s'ajusta en funció dels dies de garantia.
    - **Textil**: El preu no es modifica.

#### Justificació:

- La classe **Producte** és abstracta perquè no té sentit instanciar-la directament. Així es força a implementar la lògica específica per cada tipus de producte.
- La classe **ProducteComparator** permet ordenar els productes en funció de les seves característiques específiques:
    -  Els aliments primers i s'ordenen segon la data de caducitat.
    -  Els textils segon i s'ordenen segon la composició
    -  Electronica al final de tot.

### 2. **Gestió del Carret:**

- S'ha utilitzat una **ArrayList** per emmagatzemar els productes afegits al carret i un **HashMap** per convertir els productes en el carret en una estructura de dades que associï el codi de barres amb la quantitat d'unitats.
- **Model.convertCartToHashmap()** converteix l'ArrayList a un HashMap on la clau és el codi de barres i el valor és la quantitat de productes afegits, el hashMap s'utilitza per l'impressió del tiquet de compra al moment de passar per caixa, i s'utilitza també per l'impressio del carret.
- **ArrayList** s'utilitza per emmagatzemar els productes en el carret per la seva flexibilitat, ja que ens permet afegir o eliminar elements fàcilment.
- El **HashMap** s'utilitza per la cerca de productes per codi de barres.

### 3. **Gestió del Magatzem:**

- Espermet afegir productes amb les diverses opcions: aliments, tèxtils i electrònica, i emmagatzemar-los a través de funcions per cada tipus de producte.
- Guardem els registres de compres utilitzant una **LinkedList** per mantendre l'ordre cronologic de les compres de manera natural.
- S'utilitza el mètode `Comparator` per ordenar els productes de forma flexible segons les característiques específiques de cada tipus de producte (caducitat, composició).
## Estructura del codi

- **Model**:
    - **Producte**: Classe abstracta base per a tots els productes.
    - **Alimentacio**: Productes d'alimentació amb caducitat.
    - **Electronica**: Productes electrònics amb garantia.
    - **Textil**: Productes tèxtils amb composició.
    - **ProducteComparator**: Comparador per ordenar productes en funció de la tipologia i les seves característiques.
    - **Les Excepcions personalitzades** (DataCaducitatException, EnumFailException, LimitCaracteresException, LimitProductesException, NegatiuException)
    - **Model**: Gestió dels productes al carret i les operacions relacionades (afegir productes, verificar duplicats, generar tiquets).
- **Vista**:
    - **View**: Classe amb funcions estàtiques per mostrar els menús, el carret, els tiquets de compra ... etc.
- **Controlador**:
    - **Sapamercat**: Classe principal on es fa la gestió de l'execució del programa i la interacció amb l'usuari, organitzant la comunicacio entre el model i vista.