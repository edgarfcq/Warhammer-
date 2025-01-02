package TP_JAVA;

public class Divertissement extends Emission {
    private String presenter;
    private final int duration = 2;

    public Divertissement(String name, String presenter) {
        super(name);
        this.presenter = presenter;
    }
// Getters et setters
    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    @Override
    public int getDuration() {
        return duration;
    }
    // Vérifie si l'émission peut être programmée entre 18h et 21h
    @Override
    public boolean canBeScheduledAt(int hour) {
        return hour >= 18 && hour <= 21;
        
    }
    @Override
    public String toString() {
        return "Divertissement{" +
                "name='" + getName() + '\'' +
                ", presenter='" + presenter + '\'' +
                ", duration=" + duration +
                ", startTime=" + getStartTime() +
                ", endTime=" + getEndTime() +
                '}';
    }
}