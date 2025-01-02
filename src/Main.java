public class Main {
    public static void main(String[] args) {
        try {
            Armee armee = new Armee("Légion Rouge", "Alliance", 1000);

            Groupe groupe1 = new Groupe("Infanterie", 300);
            Groupe groupe2 = new Groupe("Cavalerie", 400);

            armee.ajouterGroupe(groupe1);
            armee.ajouterGroupe(groupe2);

            // Cette ligne lève une exception
            armee.ajouterGroupe(null);

        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        System.out.println("Programme terminé.");
    }
}
