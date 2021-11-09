package metier;

import java.util.*;

public class Client {

    /* propriétés privées */
    private int idClient;
    private String raisonSociale;
    private Double caClient;
    private Categorie categorie;
    private List<Commande>lesCommandes;

    /* getters et setters */
    public void setIdClient(int idcli){
        this.idClient=idcli;
    }
    
    public int getIdClient(){
        return this.idClient;
    }
    
    public void setRaisonSociale(String raisoc){
        this.raisonSociale=raisoc;
    }
    
    public String getRaisonSociale(){
        return this.raisonSociale;
    }
    
    public void setCaClient(Double cacli ){
        this.caClient=cacli;
    }
    
    public Double getCaClient(){
        return this.caClient;
    }
    
    
    public Client(int idClient, String raisonSociale, Categorie uneCategorie) {
        /* Affectations */
        this.idClient=idClient;
        this.raisonSociale=raisonSociale;
        this.categorie=uneCategorie;
    }
    
    public List<Commande> getLesCommandes() {
        return this.lesCommandes;
    }
    
    public void setLesCommandes(){
        this.lesCommandes=new ArrayList<Commande>();
    }
    
    public void setCategorie(Categorie unecategorie){
        this.categorie=unecategorie;
    }
    
    public Categorie getCategorie(){
        return this.categorie;
    }
            
    public Client() {
        this.lesCommandes = new ArrayList<Commande>();
    }

    /**
     * Ajoute une commande à la liste des commandes
     * du client. Prendre la précaution de vérifier
     * que la liste a bien été instanciée
     * @param uneCommande 
     */
    public void ajouterCommande(Commande uneCommande) {
        if (getLesCommandes() == null){
            setLesCommandes();
        }
        if (!getLesCommandes().contains(uneCommande)) {
            this.lesCommandes.add(uneCommande);
        }
    }

    /**
     * Affecte la somme des valorisations des commandes
     * au CA du client. Prendre la précaution de 
     * l'initialiser avant de commencer
     */
    public void cumulCA(Client unClient) {
            caClient=0.0;
            for(Commande uneCommande: lesCommandes){
                caClient+=uneCommande.valoriserCommande(uneCommande);
            }
    }
    /**
     * Recherche une commande sur son numéro en 
     * parcourant la liste des commandes, Retourne
     * une Commande si trouvée, sinon retourne null
     * @param idCommande
     * @return Commande
     */
    
    
    
    public Commande getCommandeById(int idCommande) {
        Client unClient = new Client();
        for(Commande uneCommande : getLesCommandes()){//je vais chercher dans la classe Commande l'id et la date
            if(uneCommande.getIdCommande()==idCommande){
                return uneCommande;
            }        
        }
        return null;
    }
    /**
     * Retire une commande la liste des commandes.
     * Remarque : en supprimant une commande on supprime
     * aussi ses lignes (Composition)
     * @param uneCommande 
     */
    public void supprimerCommande(Commande uneCommande) {
       /* A compléter */
    }
    

}
