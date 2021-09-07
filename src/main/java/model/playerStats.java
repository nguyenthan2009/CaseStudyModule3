package model;

public class playerStats {
    private double height;
    private double weight;
    private double bmiIndex;
    private int formIndex;

    public playerStats( double height, double weight, double bmiIndex, int formIndex) {
        this.height = height;
        this.weight = weight;
        this.bmiIndex = bmiIndex;
        this.formIndex = formIndex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmiIndex() {
        return bmiIndex;
    }

    public void setBmiIndex(double bmiIndex) {
        this.bmiIndex = bmiIndex;
    }

    public int getFormIndex() {
        return formIndex;
    }

    public void setFormIndex(int formIndex) {
        this.formIndex = formIndex;
    }
}
