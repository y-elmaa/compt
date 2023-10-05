package tpCompte;

public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant(double solde,double decouvert){
        super(solde);
        this.decouvert=decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }


    @Override
    public void verser(double montant) throws Exception {
        super.verser(montant);
    }

    @Override
    public void retirer(double montant) throws Exception{
        if (montant>solde+decouvert){
            throw new soldeinsuffisantException("solde est insuffisant");
        }else{
            super.retirer(montant);
        }

    }


    public double totalVersements() {
        return super.totalVersements();
    }

    public double totalRetraits() {
        return super.totalRetraits();
    }
}
