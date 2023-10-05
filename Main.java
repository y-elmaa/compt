package tpCompte;

import static tpCompte.Compte.listOperation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        CompteCourant c1 = new CompteCourant(1500,2000);
        CompteEpargne c2 = new CompteEpargne(1000,5);

        try {
            c1.verser(2000);
            c1.retirer(1000);
            c1.verser(100);
            c1.retirer(15);
            c1.verser(1440);
            c1.retirer(2600);
            c1.verser(4000);
            c1.retirer(6600);

            c1.versement(500, c2);
            c2.updateSolde(5);

            System.out.println("solde compte courant: " + c1.consulterSolde());
            System.out.println("solde compte epargne: " + c2.consulterSolde());


            System.out.println(c1.totalVersements());
            System.out.println(c1.totalRetraits());



            PrintWriter writer = new PrintWriter(new FileWriter("Client1.txt"));
            for (Operation operation : listOperation) {
                writer.println(operation.getNumero() + " - " + operation.getDateOperation() + " - " + operation.getMontant());
            }



        } catch (IOException e){
            System.out.println("Erreur" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur" + e.getMessage());
        }
    }
}
