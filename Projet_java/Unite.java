package Projet_java;
import java.util.*;

abstract class Unite {
    private String nom;
    private int coutPoints;

    public Unite(String nom, int coutPoints) {
        this.nom = nom;
        this.coutPoints = coutPoints;
    }
}