import java.util.*;

class Groupe {
    private final String nom;
    private int points;
    private final ArrayList<Unite> listeUnites;

    public Groupe(String nom) {
        if (nom == null || nom.trim().isEmpty()) { // on regarde que le nom est correct
            throw new IllegalArgumentException("Le groupe doit obligatoirement avoir un nom.");
        }
        this.nom = nom;
        this.points = 0;
        this.listeUnites = new ArrayList<>();
    }

    @Override
    public String toString(){
        String formattedString = "";
        formattedString += String.format("- %s\n   ", this.nom);
        for(Unite unitePtr : listeUnites){
            formattedString += String.format("%s\n   ", unitePtr.toString());
        }
        return formattedString;
    }


    public void ajouterUnite(Unite unite) {
        listeUnites.add(unite);
        this.points += unite.getCoutPoints(); // on ajoute les points de l'unité a la somme totale
    }

    public void supprimerUnite(String nomUnite) {
        Unite uniteASupprimer = null;
    
        // Trouver l'unité correspondante
        for (Unite unite : listeUnites) {
            if (unite.getNom().equalsIgnoreCase(nomUnite)) {
                uniteASupprimer = unite;
                break;
            }
        }
    
        if (uniteASupprimer != null) {
            listeUnites.remove(uniteASupprimer);
            this.points -= uniteASupprimer.getCoutPoints(); // on enlève les points de l'unité
        } else {
            throw new IllegalArgumentException("Unité introuvable dans le groupe.");
        }
    }
    

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }
}