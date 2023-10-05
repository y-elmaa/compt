package tpCompte;

import java.util.List;

public interface iCompte {
    StatutDeCompte getStatut();
    void setStatut(StatutDeCompte statut);
    void verser(double montant) throws Exception;
    void retirer(double montant) throws Exception;
    void versement(double montant, Compte compte) throws Exception;
    double consulterSolde();
    void updateSolde(double solde) throws Exception;
    List<Operation> consulterOperations();
    double totalVersements();
    double totalRetraits();
}