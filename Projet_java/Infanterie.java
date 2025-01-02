package Projet_java;
import java.util.*;
import java.util.Scanner;

class Infanterie extends Unite {
    private String typeInfanterie; // Soldat, Lourd, Spécial, Chef

    public Infanterie(String nom, int coutPoints, String typeInfanterie) {
        super(nom, coutPoints);
        this.typeInfanterie = typeInfanterie;
    }
}