class Vehicule extends Unite {
    private String typeVehicule; // Transport, Attaque
    private int capaciteTransport; // Seulement pour Transport

    public Vehicule(String nom, int coutPoints, String typeVehicule, int capaciteTransport) {
        super(nom, coutPoints);
        if (typeVehicule == null) {
            throw new IllegalArgumentException("Vous devez fournir un type de véhicule.");
        }
        if (capaciteTransport <= 0) {
            throw new IllegalArgumentException("La capacité de transport doit être strictement positifs.");
        }
        this.typeVehicule = typeVehicule;
        this.capaciteTransport = capaciteTransport;
    }

    @Override
    public String toString(){
        return String.format("- %s - %s : (%d pts, capacité : %d)", this.typeVehicule, this.getNom(), this.getCoutPoints(), this.capaciteTransport);
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }
}
