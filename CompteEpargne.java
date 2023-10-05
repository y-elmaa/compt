package tpCompte;

public class CompteEpargne extends Compte{
    private double taux;
    public CompteEpargne(double solde ,double taux) {
        super(solde);
        this.taux=taux/100;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }


    @Override
    public StatutDeCompte getStatut() {
        return super.getStatut();
    }

    @Override
    public void verser(double montant) throws Exception {
        super.verser(montant);
    }

    @Override
    public void retirer(double montant) throws Exception {
        if (montant>solde){
            throw new soldeinsuffisantException("solde est insuffisant");
        }else{
            super.retirer(montant);
        }
    }

    @Override
    public void updateSolde(double year)throws Exception{
        if(year>=1){
            for (int i=0 ; i<year;i++){
                solde+=solde*taux;
            }
        }else{
            throw new unansException("il te faut au moins 1 an");
        }
    }

    @Override
    public double totalVersements() {
        return totalVersements();
    }

    @Override
    public double totalRetraits() {
        return totalRetraits();
    }
}