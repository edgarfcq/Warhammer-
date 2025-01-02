package Projet_java;
import java.util.*;

class Groupe {
    private String nom;
    private List<Unite> unites;

    public Groupe(String nom) {
        this.nom = nom;
        this.unites = new ArrayList<>();
    }

    public void ajouterUnite(Unite unite) {
        unites.add(unite);
    }
}