package TP_JAVA;

public class Film extends Emission {
    private int year;
    private String director;
    private boolean isRerun;
    private int duration;

    public Film(String name, int year, String director, boolean isRerun, int duration) {
        super(name);
        this.year = year;
        this.director = director;
        this.isRerun = isRerun;
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }
    // Getters et setters
    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isRerun() {
        return isRerun;
    }

    public void setRerun(boolean rerun) {
        isRerun = rerun;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("impossible");
        }
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }
 // Vérifie les règles de programmation pour un film
    @Override
    public boolean canBeScheduledAt(int hour) {
        if (!isRerun) {
            return hour == 21;// Les nouveaux films sont diffusés à 21h
        } else {
            return hour >= 0 && hour <= 23;// Les rediffusions peuvent être programmées n'importe quand
        }
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + getName() + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", isRerun=" + isRerun +
                ", duration=" + duration +
                ", startTime=" + getStartTime() +
                ", endTime=" + getEndTime() +
                '}';
    }
}
