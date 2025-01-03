class Vehicule implements Unite {
    private String nom;
    private int coutPoints;
    private String typeVehicule; // Transport, Attaque
    private int capaciteTransport; // Seulement pour Transport

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
        if (capaciteTransport <= 0) {
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

    public void setCoutPoints(int coutPoints) {
        this.coutPoints = coutPoints;
    }

    public int getCapaciteTransport() {
        return capaciteTransport;
    }

    public void setCapaciteTransport(int capaciteTransport) {
        this.capaciteTransport = capaciteTransport;
    }

    @Override
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }
}
