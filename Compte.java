package tpCompte;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte extends Exception implements iCompte{
    private int code;
    double solde;
    private StatutDeCompte statut;
    public static List<Operation> listOperation;


    public Compte(double solde) {
        this.code +=1;
        this.solde = solde;
        this.statut=StatutDeCompte.CREATED;
        this.listOperation = new ArrayList<>();
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    public StatutDeCompte getStatut() {
        return statut;
    }

    public void setStatut(StatutDeCompte statut) {
        this.statut = statut;
    }

    public void verser(double montant)throws Exception{
        if(montant<0){
            throw new negativemtException("le montant doit etre superior a 0");
        }else{
            solde+=montant;
            Versement versement = new Versement(new Date(),montant);
            listOperation.add(versement);
        }
    }
    public void retirer(double montant)throws Exception{
        solde-=montant;
        Retrait retrait = new Retrait(new Date(),montant);
        listOperation.add(retrait);
    }
    public void versement(double montant,Compte compte) throws Exception {
        this.retirer(montant);
        compte.verser(montant);
    }
    public double consulterSolde(){
        return getSolde();
    }

    public void updateSolde(double solde) throws Exception {}

    public List<Operation> consulterOperations(){
        return listOperation;
    }


    public double totalVersements(){
        double totalVersements = 0;
        for (Operation operation : listOperation) {
            if (operation instanceof Versement) {
                totalVersements += operation.getMontant();
            }
        }
        return totalVersements;
    }
    public double totalRetraits(){
        double totalRetraits = 0;
        for (Operation operation : listOperation) {
            if (operation instanceof Retrait) {
                totalRetraits += operation.getMontant();
            }
        }
        return totalRetraits;

    }
}
