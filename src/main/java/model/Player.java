package model;

public class Player {
private int id;
private String namePlayer;
private int bornYear;
private String address;
private String playPossition;
private int salary;
private String status;
private String image;

    public Player(int id, String namePlayer, int bornYear, String address, String playPossition, int salary, String status, String image) {
        this.id = id;
        this.namePlayer = namePlayer;
        this.bornYear = bornYear;
        this.address = address;
        this.playPossition = playPossition;
        this.salary = salary;
        this.status = status;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getPlayPossition() {
        return playPossition;
    }

    public void setPlayPossition(String playPossition) {
        this.playPossition = playPossition;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
