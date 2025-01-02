class Infanterie extends Unite {
    private String typeInfanterie; // Soldat, Lourd, Spécial, Chef

    public Infanterie(String nom, int coutPoints, String typeInfanterie) {
        super(nom, coutPoints);
        if (typeInfanterie == null) {
            throw new IllegalArgumentException("Vous devez fournir un objet de type Groupe.");
        }
        this.typeInfanterie = typeInfanterie;
    }
}