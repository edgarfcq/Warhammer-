import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        try {

            initialisationArmee();
            while (true) {
                afficherMenuPrincipal();
                int choix = lireEntier("Votre choix : ");
                switch (choix) {
                    case 1 -> initialisationArmee();
                    //case 2 -> selectionnerArmee();
                    case 3 -> {
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

            }

    private static void afficherMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Créer une nouvelle armée");
        System.out.println("2. Sélectionner une armée");
        System.out.println("3. Quitter");
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
