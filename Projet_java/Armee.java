package Projet_java;
import java.util.*;
import java.util.Scanner;

class Armee {
    private String nom;
    private String faction;
    private int maxPoints;
    private List<Groupe> groupes;

    public Armee(String nom, String faction, int maxPoints) {
        this.nom = nom;
        this.faction = faction;
        this.maxPoints = maxPoints;
        this.groupes = new ArrayList<>();
    }

    public void ajouterGroupe(Groupe groupe) {
        groupes.add(groupe);
    }
}
