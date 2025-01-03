import java.util.ArrayList;
import java.util.List;

public class Armee {
    private String nom;
    private String faction;
    private int maxPoints;
    private int totalPoints; // Pour suivre les points des groupes
    private ArrayList<Groupe> groupes;

    // Constructeur avec les vérifications

    /**
     *
     * @param nom
     * @param faction
     * @param maxPoints
     */
    public Armee(String nom, String faction, int maxPoints) {

        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'armée est obligatoire et doit être une chaîne non vide.");
        }

        if (faction == null || faction.trim().isEmpty()) {
            throw new IllegalArgumentException("La faction est obligatoire et doit être une chaîne non vide.");
        }

        if (maxPoints <= 0) {
            throw new IllegalArgumentException("Le nombre maximal de points doit être un entier positif.");
        }

        this.nom = nom;
        this.faction = faction;
        this.maxPoints = maxPoints;
        this.totalPoints = 0; // Initialisation à zéro
        this.groupes = new ArrayList<>();
    }

    /**
     *
     * @param groupe
     */
    public void ajouterGroupe(Groupe groupe) {
        if (groupe == null) {
            throw new IllegalArgumentException("Vous devez fournir un objet de type Groupe.");
        }
        if (groupe.getPoints() <= 0) {
            throw new IllegalArgumentException("Les points du groupe doivent être positifs.");
        }
        if (totalPoints + groupe.getPoints() > maxPoints) {
            throw new IllegalArgumentException("Ajout impossible : dépassement des points maximum de l'armée.");
        }

        groupes.add(groupe);
        totalPoints += groupe.getPoints(); // Mise à jour du total
    }



    @Override
    public String toString(){
        String formattedString = "";
        formattedString += String.format("Nom de l'armée : %s \nNom de la faction : %s \nPoints max : %d \nPoints utilisés : %d", this.nom, this.faction, this.maxPoints, this.totalPoints);
        formattedString += String.format("\nGroupes :");
        return formattedString;
    }


    // Getters et Setters
    public String getNom() {
        return nom;
    }
    public String getFaction() {
        return faction;
    }
    public int getMaxPoints() {
        return maxPoints;
    }
    public int getTotalPoints() {
        return totalPoints;
    }
    public List<Groupe> getGroupes() {
        return this.groupes;
    }
}
