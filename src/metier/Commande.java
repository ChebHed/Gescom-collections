package metier;

import dao.BdD;
import java.util.*;

public class Commande {

    /* propriétés privées */
    private int idCommande;
    private Date dateCommande;
    private List<Ligne> lesLignes;
    
    /* getters et setters */
    public void setIdCommande(int idcomm){
        this.idCommande=idcomm;
    }
    
    public int getIdCommande(){
        return this.idCommande;
    }
    
    public void setDate(Date date){
        this.dateCommande=date;
    }
    
    public Date getDate(){
        return this.dateCommande;
    }
    
    
    public Commande (int idCommande, Date dateCommande){
        /* Affectations */
        this.idCommande=idCommande;
        this.dateCommande=dateCommande;
        
    }
    
    public List<Ligne> getLesLignes() {
        return this.lesLignes;
    }
    
    public void setLesLignes(){

        this.lesLignes=new ArrayList<Ligne>();
    }
    
    public Commande() {
        this.lesLignes = new ArrayList<Ligne>();
    }
    
    
    /**
     * Ajoute une ligne à une commande.
     * Si la liste des lignes n'est pas instanciée,
     * l'instancier
     * Si l'article n'est pas dans la liste des
     * lignes, créer la ligne et l'ajouter à la liste
     * @param unArticle
     * @param qteCde 
     */
    public void ajouterLigne(Article unArticle, int qteCde) {
        if (getLesLignes() == null) {
            setLesLignes();
        }
        Ligne uneLigne = new Ligne(unArticle, qteCde);
        this.lesLignes.add(uneLigne);
    }

    /**
     * Supprime la ligne passée en paramètre
     * @param ligneASupprimer Ligne à supprimer
     */
    public void supprimerLigne(Ligne ligneASupprimer) {
        /* A compléter */
    }
    
    /**
     * Recherche la ligne contenant l'article ayant
     * l'id passé en paramètre. 
     * Utiliser la méthode equals() pour comparer deux objets.
     */    
    public Ligne chercherLigne(Article art) {
        Ligne uneLigneTrouve=null ;
        for(Ligne uneLigne: this.lesLignes ){
           if(uneLigne.getArticle().equals(art)){
               uneLigneTrouve=uneLigne;
               break;
           }
       }
       return uneLigneTrouve;
    }

    /**
     * Calcule le montant total HT de la commande 
     * à partir du prix des articles présents dans
     * les lignes de commande
     * @return Montant total HT de la commande
     */
    public double valoriserCommande(Commande uneCommande) {
       
        double somme=0;
        
            for(Ligne uneLigne : uneCommande.getLesLignes()){
                somme = somme+((uneLigne.getArticle().getPrix())*(uneLigne.getQteCommande()));
            }    
    return somme;
    }
}
