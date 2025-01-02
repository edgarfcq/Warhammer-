import java.util.*;

class Groupe {
    private String nom;
    private int points;
    private ArrayList<Unite> listeUnites;

    public Groupe(String nom, int points) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le groupe doit obligatoirement avoir un nom.");
        }
        if (points <= 0) {
            throw new IllegalArgumentException("Les points doivent être un entier positif.");
        }


        this.nom = nom;
        this.points = points;
        this.listeUnites = new ArrayList<>();
    }

    @Override
    public String toString(){
        String formattedString = "";
        formattedString += String.format("Groupes :\n- %s\n   ", this.nom);
        for(Unite unitePtr : listeUnites){
            formattedString += String.format("%s\n", unitePtr.toString());
        }
        return formattedString;
    }

    public void ajouterUnite(Unite unite) {
        listeUnites.add(unite);
    }

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }
}