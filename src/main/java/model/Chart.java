package model;

public class Chart {
 private  int percent;
 private int week;
 private  double salaryofWeek;

    public Chart(int percent, int week, double salaryofWeek) {
        this.percent = percent;
        this.week = week;
        this.salaryofWeek = salaryofWeek;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public double getSalaryofWeek() {
        return salaryofWeek;
    }

    public void setSalaryofWeek(double salaryofWeek) {
        this.salaryofWeek = salaryofWeek;
    }
}
