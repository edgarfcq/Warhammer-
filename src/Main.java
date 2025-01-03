import java.util.Scanner;
import java.util.ArrayList  ;
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Armee testArmees;

    public static void main(String[] args) {
        try {

            initialisationArmee();
            while (true) {
                afficherMenuPrincipal();
                int choix = lireEntier("Votre choix : ");
                switch (choix) {
                    case 1 -> initialisationArmee();
                    case 2 -> creerGroupe();
                    case 3 -> afficherArmee();
                    case 4 -> {
                        System.out.println("quelle armée terrifiante !");
                        return; // Quitte le programme
                    }
                    default -> System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nProgramme terminé.");
    }

    private static void initialisationArmee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ecrire le nom de l'armée: ");
        String nomArmee = scanner.nextLine();


        System.out.print("Ecrire le nom de la faction: ");
        String nomFaction = scanner.nextLine();

        System.out.print("Ecrire la taille de l'armée ");
        int tailleArmee = 0;
        String input = scanner.nextLine();
        tailleArmee = Integer.parseInt(input);
        Armee armee = new Armee(nomArmee,nomFaction,tailleArmee);
        testArmees = armee;
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Créer une nouvelle armée");
        System.out.println("2. Créer un nouveau Groupe");
        System.out.println("3. Afficher Armee");
        System.out.println("4. Quitter");
    }

    private static void creerGroupe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ecrire le nom du groupe: ");
        String nomGroupe = scanner.nextLine();
        Groupe groupe = new Groupe(nomGroupe);
        gererGroupe(groupe);
        return;
    }

    private static void gererGroupe(Groupe groupe) {
        while (true) {
            System.out.printf("\n--- Gestion du Groupe : %s ---\n", groupe.getNom());
            System.out.println("1. Ajouter une unité");
            System.out.println("2. Retour au menu principal");

            int choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> ajouterUnite(groupe);
                case 2 -> {
                    testArmees.ajouterGroupe(groupe);
                    System.out.println("Retour au menu principal...");
                    return; // Sort de la gestion de cette armée
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void ajouterUnite(Groupe groupe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Ajouter une unité ---");
        System.out.println("1. Ajouter une infanterie");
        System.out.println("2. Ajouter un véhicule");
        System.out.println("3. Retour à la gestion du groupe");

        int choix = lireEntier("Votre choix : ");
        switch (choix) {
            case 1 -> {
                System.out.print("Nom de l'infanterie : ");
                String nomInfanterie = scanner.nextLine();
                int pointsInfanterie = lireEntier("Points de l'infanterie : ");
                System.out.print("Type de l'infanterie (Soldat, Lourd, Spécial, Chef): ");
                String typeInfanterie = scanner.nextLine();
                groupe.ajouterUnite(new Infanterie(nomInfanterie, pointsInfanterie, "soldat"));
            }
            case 2 -> {
                int capaciteVehicule = 0;
                System.out.print("Nom du véhicule : ");
                String nomVehicule = scanner.nextLine();
                int pointsVehicule = lireEntier("Points du véhicule : ");
                System.out.print("Type du véhicule : ");
                String typeVehicule = scanner.nextLine();
                typeVehicule = typeVehicule.toUpperCase();
                if(typeVehicule.equals("TRANSPORT")) {
                    capaciteVehicule = lireEntier("Capacité du véhicule : ");
                }
                groupe.ajouterUnite(new Vehicule(nomVehicule, pointsVehicule, typeVehicule, capaciteVehicule));
            }
            case 3 -> {
                System.out.println("Retour à la gestion du groupe...");
                return;
            }
            default -> System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    private static void afficherArmee(){
        System.out.println(testArmees);
        for(Groupe groupePtr : testArmees.getGroupes()) {
            System.out.println(groupePtr);
        }
    }

    private static int lireEntier(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Erreur : Vous devez entrer un nombre entier.");
            }
        }
    }
}
