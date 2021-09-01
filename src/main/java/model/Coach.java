package model;

public class Coach {
private int id;
private String nameCoach;
private int bornYear;
private String address;
private double salary;

<<<<<<< HEAD
    public Coach() {
    }

    public Coach(int id, String nameCoach, int bornYear, String address, double salary) {
        this.id = id;
        this.nameCoach = nameCoach;
        this.bornYear = bornYear;
        this.address = address;
        this.salary = salary;
    }

    public Coach(String nameCoach, int bornYear, String address, double salary) {
        this.nameCoach = nameCoach;
        this.bornYear = bornYear;
        this.address = address;
        this.salary = salary;
=======
    public Coach(String nameCoach, int bornYear, String address, double salary) {
>>>>>>> master
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCoach() {
        return nameCoach;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
