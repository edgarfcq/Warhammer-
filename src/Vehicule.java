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
}
