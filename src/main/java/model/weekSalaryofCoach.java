package model;

import model.Coach;

public class weekSalaryofCoach {
    private String  nameCoach;
    private int week;
    private double weekSalary;

    public int getWeek() {
        return week;
    }

    public weekSalaryofCoach(String nameCoach, int week, double weekSalary) {
        this.nameCoach = nameCoach;
        this.week = week;
        this.weekSalary = weekSalary;
    }

    public String getNameCoach() {
        return nameCoach;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        this.weekSalary = weekSalary;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public double getWeekSaraly() {
        return weekSalary;
    }

    public void setWeekSaraly(double weekSaraly) {
        this.weekSalary = weekSaraly;
    }
}
