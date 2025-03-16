package model;

import java.time.LocalDate;
import java.time.Period;

public class Alimentacio extends Producte{
    protected String dataCaducitat;

    public Alimentacio(int preu, String nom, String barcode, String dataCaducitat) {
        super(preu, nom, barcode);
        this.dataCaducitat = dataCaducitat;
    }

    // Getter
    public LocalDate getDataCaducitat() {
        String[] dataStrValues = dataCaducitat.split("/");
        int[] dataIntValues =new int [3];
        for (int i = 0; i < dataStrValues.length; i++){
            dataIntValues[i] = Integer.parseInt(dataStrValues[i]);
        }

        return LocalDate.of(dataIntValues[2], dataIntValues[1], dataIntValues[0]);

    }

    // Setter
    public void setDataCaducitat(String dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public double calcularPreu() {
        int diesCaducitat = calcularDiesCaducitat(dataCaducitat);
        return preu - preu * (((double) 1 / diesCaducitat) + 1) + (preu * 0.1);
    }

    private int calcularDiesCaducitat(String data){
        String[] dataStrValues = data.split("/");

        int[] dataIntValues =new int [3];

        for (int i = 0; i < dataStrValues.length; i++){
            dataIntValues[i] = Integer.parseInt(dataStrValues[i]);
        }

        LocalDate dataCaducitat =LocalDate.of(dataIntValues[2], dataIntValues[1], dataIntValues[0]);
        int diesCaducitat = Period.between(dataCaducitat, LocalDate.now()).getDays();

        return diesCaducitat;
    }


}
