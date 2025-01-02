class Infanterie extends Unite {
    private String typeInfanterie; // Soldat, Lourd, Spécial, Chef

    public Infanterie(String nom, int coutPoints, String typeInfanterie) {
        super(nom, coutPoints);
        if (typeInfanterie == null) {
            throw new IllegalArgumentException("Vous devez donner un type à l'infanterie.");
        }
        this.typeInfanterie = typeInfanterie;
    }


    @Override
    public String toString(){
        return String.format("- %s - %s : (%d pts)", this.typeInfanterie, this.getNom(), this.getCoutPoints());
    }

    public String getTypeInfanterie() {
        return typeInfanterie;
    }

    public void setTypeInfanterie(String typeInfanterie) {
        this.typeInfanterie = typeInfanterie;
    }
}