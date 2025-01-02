package Projet_java;

class Vehicule extends Unite {
    private String typeVehicule; // Transport, Attaque
    private int capaciteTransport; // Seulement pour Transport

    public Vehicule(String nom, int coutPoints, String typeVehicule, int capaciteTransport) {
        super(nom, coutPoints);
        this.typeVehicule = typeVehicule;
        this.capaciteTransport = capaciteTransport;
    }
}
