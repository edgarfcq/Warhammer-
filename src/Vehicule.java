class Vehicule implements Unite {
    private final String nom;
    private final int coutPoints;
    private final String typeVehicule; // Transport, Attaque
    private final int capaciteTransport; // Seulement pour Transport

    public Vehicule(String nom, int coutPoints, String typeVehicule, int capaciteTransport) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'unité est obligatoire.");
        }
        if (coutPoints <= 0) {
            throw new IllegalArgumentException("Le cout de l'unité doit être positifs.");
        }

        if (typeVehicule == null) {
            throw new IllegalArgumentException("Vous devez fournir un type de véhicule.");
        }
        if (capaciteTransport < 0) {
            throw new IllegalArgumentException("La capacité de transport doit être strictement positifs.");
        }
        this.nom = nom;
        this.coutPoints = coutPoints;
        this.typeVehicule = typeVehicule;
        this.capaciteTransport = capaciteTransport;
    }

    @Override
    public String toString(){
        return String.format("- %s - %s : (%d pts, capacité : %d)", this.typeVehicule, this.nom, this.coutPoints, this.capaciteTransport);
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
