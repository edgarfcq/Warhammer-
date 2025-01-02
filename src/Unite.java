abstract class Unite {
    private String nom;
    private int coutPoints;

    public Unite(String nom, int coutPoints) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du groupe est obligatoire.");
        }
        if (coutPoints <= 0) {
            throw new IllegalArgumentException("Le cout de l'unité doit être positifs.");
        }
        this.nom = nom;
        this.coutPoints = coutPoints;
    }
}