package edu.epam.figure.register;

public class Parametr {
    private double volume;
    private double square;
    private double perimetr;

    public Parametr(double volume, double square, double perimetr) {
        this.volume = volume;
        this.square = square;
        this.perimetr = perimetr;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimetr() {
        return perimetr;
    }

    public void setPerimetr(double perimetr) {
        this.perimetr = perimetr;
    }
}
