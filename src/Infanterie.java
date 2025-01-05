class Infanterie implements Unite {
    private final String nom;
    private final int coutPoints;
    private final String typeInfanterie; // Soldat, Lourd, Spécial, Chef

    public Infanterie(String nom, int coutPoints, String typeInfanterie) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'unité est obligatoire.");
        }
        if (coutPoints <= 0) {
            throw new IllegalArgumentException("Le cout de l'unité doit être positifs.");
        }

        if (typeInfanterie == null) {
            throw new IllegalArgumentException("Vous devez donner un type à l'infanterie.");
        }
        this.typeInfanterie = typeInfanterie;
        this.nom = nom;
        this.coutPoints = coutPoints;
    }


    @Override
    public String toString(){
        return String.format("- %s - %s : (%d pts)", this.typeInfanterie, this.nom, this.coutPoints);
    }

    @Override
    public int getCoutPoints() {
        return coutPoints;
    }

    @Override
    public String getNom() {
        return nom;
    }

}