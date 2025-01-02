package TP_JAVA;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Liste pour stocker les émissions programmées
        List<Emission> program = new ArrayList<>();

        // Création des objets
        Divertissement divertissement = new Divertissement("TPMP", "Hanouna");
        if (divertissement.scheduleAt(19)) {
            program.add(divertissement);
        }

        Film film = new Film("Bienvenue chez les chti", 2010, "Dany boon", false,2);
        if (film.scheduleAt(21)) {
            program.add(film);
        }

        Reportage reportage = new Reportage("Enquete d'action", "information", 1);
        if (reportage.scheduleAt(2)) {
            program.add(reportage);
        }
        // Affiche les émissions programmées
        System.out.println("Programme de la journée:");
        for (Emission emission : program) {
            System.out.println(emission);
        }

        // Vérifie les chevauchements dans la programmation
        boolean hasOverlap = checkOverlap(program);
        System.out.println("chevauchement dans la programmation: " + hasOverlap);

        // Affiche la programmation heure par heure
        displayHourlySchedule(program);
    }

    private static boolean checkOverlap(List<Emission> program) {
        // Parcourt chaque paire d'émissions dans la liste
        for (int i = 0; i < program.size(); i++) {
            for (int j = i + 1; j < program.size(); j++) {
                Emission e1 = program.get(i); // Première émission
                Emission e2 = program.get(j); // Deuxième émission

                // Vérifie si les horaires des deux émissions se chevauchent
                if (e1.getEndTime() > e2.getStartTime() && e1.getStartTime() < e2.getEndTime()) {
                    return true; // Retourne vrai si un chevauchement est détecté
                }
            }
        }
        return false; // Retourne faux si aucun chevauchement n'est trouvé
    }

    private static void displayHourlySchedule(List<Emission> program) {
        System.out.println("Programme:");
        
        // Parcourt chaque heure de la journée
        for (int hour = 0; hour < 24; hour++) {
            System.out.print(hour + "h: ");
            boolean found = false; // Indique si une émission a été trouvée pour cette heure
            
            // Parcourt toutes les émissions programmées
            for (Emission emission : program) {
                // Vérifie si l'émission est active à l'heure actuelle
                if (emission.getStartTime() <= hour && emission.getEndTime() > hour) {
                    System.out.print(emission.getName() + " "); // Affiche le nom de l'émission
                    found = true; // Une émission a été trouvée pour cet horaire
                }
            }

            // Si aucune émission n'est trouvée pour cette heure, affiche un message par défaut
            if (!found) {
                System.out.print("Pas d'émissions");
            }
            System.out.println(); // Passe à la ligne suivante pour l'heure suivante
        }
    }
}
