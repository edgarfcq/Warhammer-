package TP_JAVA;

// Classe abstraite représentant une émission générique
public abstract class Emission {
    // Attributs généraux pour toutes les émissions
    private String name; 
    private int startTime; 
    private int endTime; 

    // Constructeur pour initialiser le nom de l'émission
    public Emission(String name) {
        this.name = name;
    }

    // Getters et setters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
    // Définit les heures de début et de fin en fonction de la durée
    protected void setStartAndEndTime(int startTime, int duration) {
        this.startTime = startTime;
        this.endTime = startTime + duration;
    }

    // Méthode abstraite pour vérifier si une émission peut être programmée à une heure donnée
    public abstract boolean canBeScheduledAt(int hour);

    // Programme l'émission si l'heure est valide
    public boolean scheduleAt(int hour) {
        if (canBeScheduledAt(hour)) {
            setStartAndEndTime(hour, getDuration());
            return true; // Succès de la programmation
        }
        return false; // Échec de la programmation
    }

    // Méthode abstraite pour obtenir la durée de l'émission
    public abstract int getDuration();

    @Override
    public String toString() {
        return "Emission{name='" + name + '\'' + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}