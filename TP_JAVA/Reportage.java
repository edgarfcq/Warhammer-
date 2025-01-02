package TP_JAVA;


public class Reportage extends Emission {
    private String theme; // "information", "animalier", or "culturel"
    private int duration;

    public Reportage(String name, String theme, int duration) {
        super(name);
        if (!theme.equals("information") && !theme.equals("animalier") && !theme.equals("culturel")) {
            throw new IllegalArgumentException("Theme must be 'information', 'animalier', or 'culturel'");
        }
        if (duration > 1) {
            throw new IllegalArgumentException("Reportage duration must be less than or equal to 1 hour");
        }
        this.theme = theme;
        this.duration = duration;
    }

    public String getTheme() {
        return theme;
    }
    // Getters et setters
    public void setTheme(String theme) {
        if (!theme.equals("information") && !theme.equals("animalier") && !theme.equals("culturel")) {
            throw new IllegalArgumentException("Theme must be 'information', 'animalier', or 'culturel'");
        }
        this.theme = theme;
    }

    @Override
    public int getDuration() {
        return duration;
    }
    // Vérifie les plages horaires 
    @Override
    public boolean canBeScheduledAt(int hour) {
        return (hour >= 0 && hour < 6) || (hour >= 14 && hour < 18);
    }

    @Override
    public String toString() {
        return "Reportage{" +
                "name='" + getName() + '\'' +
                ", theme='" + theme + '\'' +
                ", duration=" + duration +
                ", startTime=" + getStartTime() +
                ", endTime=" + getEndTime() +
                '}';
    }
}