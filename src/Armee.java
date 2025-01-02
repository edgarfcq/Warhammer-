import java.util.ArrayList;
import java.util.List;

public class Armee {
    private String nom;
    private String faction;
    private int maxPoints;
    private int totalPoints; // Pour suivre les points des groupes
    private List<Groupe> groupes;

    // Constructeur avec validations
    public Armee(String nom, String faction, int maxPoints) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'armée est obligatoire.");
        }
        if (faction == null || faction.trim().isEmpty()) {
            throw new IllegalArgumentException("La faction est obligatoire.");
        }
        if (maxPoints <= 0) {
            throw new IllegalArgumentException("Le nombre maximal de points doit être positif.");
        }

        this.nom = nom;
        this.faction = faction;
        this.maxPoints = maxPoints;
        this.totalPoints = 0; // Initialisation à zéro
        this.groupes = new ArrayList<>();
    }

    // Méthode pour ajouter un groupe avec validation des points
    public void ajouterGroupe(Groupe groupe) {

    }

    // Méthodes pour accéder aux données de l'armée
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
        return new ArrayList<>(groupes); // Retourne une copie pour éviter les modifications externes
    }
}
