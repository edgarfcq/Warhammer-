import java.util.Scanner;
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
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
                    case 3 -> modifierGroupe();
                    case 4 -> afficherArmee();
                    case 5 -> {
                        System.out.println("Fin du programme...");
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
        // joli dessin en ascii car pourquoi pas  :)
        System.out.print("__        ___    ____  _   _    _    __  __ __  __ _____ ____  \r\n" + //
                        "\\ \\      / / \\  |  _ \\| | | |  / \\  |  \\/  |  \\/  | ____|  _ \\ \r\n" + //
                        " \\ \\ /\\ / / _ \\ | |_) | |_| | / _ \\ | |\\/| | |\\/| |  _| | |_) |\r\n" + //
                        "  \\ V  V / ___ \\|  _ <|  _  |/ ___ \\| |  | | |  | | |___|  _ < \r\n" + //
                        "   \\_/\\_/_/   \\_\\_| \\_\\_| |_/_/   \\_\\_|  |_|_|  |_|_____|_| \\_\\");
        System.out.print("\r\n\n");
        // on récupère le nom donné par l'utilisateur pour l'arùée la faction et la taille max de l'armée
        System.out.println("+----------------------------------------+");

        System.out.print("| Écrire le nom de l'armée : ");
        String nomArmee = scanner.nextLine();
        System.out.println("+----------------------------------------+");



        System.out.print("| Écrire le nom de la faction : ");
        String nomFaction = scanner.nextLine();
        System.out.println("+----------------------------------------+");

        System.out.print("| Écrire la taille de l'armée :");

        int tailleArmee;
        String input = scanner.nextLine();
        System.out.println("+----------------------------------------+");
        tailleArmee = Integer.parseInt(input);
        testArmees = new Armee(nomArmee,nomFaction,tailleArmee);
    }

    private static void afficherMenuPrincipal() {
        System.out.println("      +---------------------------+");
        System.out.println("      |       Menu Principal      |");
        System.out.println("      +---------------------------+");
        System.out.println("+----------------------------------------+");
        System.out.println("| 1. Créer une nouvelle armée           |");
        System.out.println("| 2. Créer un nouveau Groupe            |");
        System.out.println("| 3. Modifier Groupe                    |");
        System.out.println("| 4. Afficher Armee                     |");
        System.out.println("| 5. Quitter                            |");
        System.out.println("+----------------------------------------+");
    }

    private static void creerGroupe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+----------------------------------------+");
        System.out.print("|  Écrire le nom du groupe: ");

        String nomGroupe = scanner.nextLine();
        System.out.println("+----------------------------------------+");

        Groupe groupe = new Groupe(nomGroupe);
        gererGroupe(groupe);
    }


    private static void modifierGroupe() {
        int nombreGroupe = testArmees.getGroupes().size();
        if (nombreGroupe == 0) { // on vérifie s'il existe au moins 1 groupe
            System.out.println("Il n'y a actuellement aucun groupe.\nRetour au menu principal...");
            return;
        }

        int indice;
        do {
            System.out.printf("Il y a actuellement %d groupes.\n", nombreGroupe);
            indice = lireEntier(String.format("Donner l'indice du groupe (0 à %d) : ",(nombreGroupe - 1)));
            if (indice < 0 || indice >= nombreGroupe) {
                System.out.println("Indice invalide. Veuillez entrer un indice valide.");
            }
        } while (indice < 0 || indice >= nombreGroupe); // on vérifie qu'on l'nidice donné est correcth

        gererGroupe(testArmees.getGroupes().get(indice));
    }



    private static void gererGroupe(Groupe groupe) {
        while (true) {
            System.out.println("+----------------------------------------+");
            System.out.printf("|    Gestion du Groupe : %-15s |\n", groupe.getNom());
            System.out.println("+----------------------------------------+");
            System.out.println("|  1. Ajouter une unité                  |");
            System.out.println("|  2. Supprimer une unité                |"); // Nouvelle option
            System.out.println("|  3. Retour au menu principal           |");
            System.out.println("+----------------------------------------+");


            int choix = lireEntier("| Votre choix : ");
            System.out.println("+----------------------------------------+");

            switch (choix) {
                case 1 -> ajouterUnite(groupe);
                case 2 -> supprimerUnite(groupe); // Appelle la méthode ajoutée
                case 3 -> {
                    try {
                        if (!testArmees.getGroupes().contains(groupe)) { // Évite les doublons
                            testArmees.ajouterGroupe(groupe);
                        }
                    } catch (IllegalArgumentException e) { // dépassement des pts max
                        System.err.println("Erreur : " + e.getMessage());
                    }
                    System.out.println("Retour au menu principal...");
                    return;
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
    

    private static void supprimerUnite(Groupe groupe) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("| Nom de l'unité à supprimer : ");
        String nomUnite = scanner.nextLine();

        try {
            groupe.supprimerUnite(nomUnite); // on appelle la méthode de suppression dans la classe Groupe
            System.out.println("| Unité supprimée avec succès !         |");
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }


    private static void ajouterUnite(Groupe groupe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+----------------------------------------+");
        System.out.println("|           Ajouter une unité            |");
        System.out.println("+----------------------------------------+");
        System.out.println("| 1. Ajouter une infanterie              |");
        System.out.println("| 2. Ajouter un véhicule                 |");
        System.out.println("| 3. Retour à la gestion du groupe       |");
        System.out.println("+----------------------------------------+");
        int choix = lireEntier("| Votre choix : ");
        System.out.println("+----------------------------------------+");

        switch (choix) {
            case 1 -> {
                System.out.print("Nom de l'infanterie : ");
                String nomInfanterie = scanner.nextLine();
                int pointsInfanterie = lireEntier("Points de l'infanterie : ");
                System.out.print("Type de l'infanterie (Soldat, Lourd, Spécial, Chef): ");
                String typeInfanterie = scanner.nextLine();
                groupe.ajouterUnite(new Infanterie(nomInfanterie, pointsInfanterie, typeInfanterie));
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
                groupe.ajouterUnite(new Vehicule(nomVehicule, pointsVehicule, typeVehicule, capaciteVehicule)); // on créé une unité avec les caractéristique donnée
            }
            case 3 -> System.out.println("Retour à la gestion du groupe...");
            default -> System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    private static void afficherArmee(){
        System.out.println(testArmees);
        for(Groupe groupePtr : testArmees.getGroupes()) { // on parcourt tout les groupes et on affiche leurs contenue (rendu possible avec la surchage de la fonction tostring)
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
