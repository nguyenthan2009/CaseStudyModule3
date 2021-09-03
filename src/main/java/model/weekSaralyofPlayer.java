package model;

public class weekSaralyofPlayer {
    private String namePlayer;
    private int week;
    private double weekSalary;

    public weekSaralyofPlayer(String namePlayer, int week, double weekSalary) {
        this.namePlayer = namePlayer;
        this.week = week;
        this.weekSalary = weekSalary;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        this.weekSalary = weekSalary;
    }
}

