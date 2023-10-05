package tpCompte;

import java.util.Date;

public class Operation {
    private int numero;
    private Date dateOperation;
    private double montant;
    public Operation(Date date, double montant) {
        this.numero +=1;
        this.dateOperation = new Date();
        this.montant = montant;
    }


    public int getNumero() {
        return numero;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public double getMontant() {
        return montant;
    }
}
