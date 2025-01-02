import java.util.*;

class Groupe {
    private String nom;
    private int points;
    private List<Unite> unites;

    public Groupe(String nom, int points) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du groupe est obligatoire et doit être une chaîne non vide.");
        }
        if (points <= 0) {
            throw new IllegalArgumentException("Les points doivent être un entier positif.");
        }


        this.nom = nom;
        this.points = points;
        this.unites = new ArrayList<>();
    }

    public void ajouterUnite(Unite unite) {
        unites.add(unite);
    }


    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }
}