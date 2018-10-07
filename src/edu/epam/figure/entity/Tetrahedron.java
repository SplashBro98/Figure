package edu.epam.figure.entity;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.exception.CustomException;
import edu.epam.figure.factory.Figure3D;
import edu.epam.figure.observer.Observable;
import edu.epam.figure.observer.Observer;
import edu.epam.figure.util.IdGenerator;
import edu.epam.figure.validator.TetraValidator;

import java.util.ArrayList;
import java.util.List;

public class Tetrahedron implements Figure3D, Observable {
    private long tetraId;
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private double volume;
    private double square;
    private double perimetr;
    List<Observer> observers;


    public Tetrahedron(Point a, Point b, Point c, Point d) throws CustomException{
        TetraValidator validator = new TetraValidator();
        Calculator calculator = new Calculator();
        if(!validator.isCorrectPoints(a,b,c,d)){
            throw new CustomException("These Points can`t be a Tetrahedron");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.tetraId = IdGenerator.getTetraId();
        this.observers = new ArrayList<>();
        this.volume = calculator.calculateVolume(this);
        this.square = calculator.calculateSquare(this);
        this.perimetr = calculator.calculatePerimetr(this);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.handleEvent(this);
        }
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObservers();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        notifyObservers();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        notifyObservers();
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
        notifyObservers();
    }

    public long getTetraId() {
        return tetraId;
    }

    public double getVolume() {
        return volume;
    }

    public double getSquare() {
        return square;
    }

    public double getPerimetr() {
        return perimetr;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setPerimetr(double perimetr) {
        this.perimetr = perimetr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tetrahedron that = (Tetrahedron) o;

        if (tetraId != that.tetraId) return false;
        if (!a.equals(that.a)) return false;
        if (!b.equals(that.b)) return false;
        if (!c.equals(that.c)) return false;
        return d.equals(that.d);
    }

    public boolean equalsIgnoreId(Tetrahedron tetr){
        if (this == tetr){
            return true;
        }
        if (tetr == null || !a.equals(tetr.a) || !b.equals(tetr.b) || !c.equals(tetr.c)){
            return false;
        }
        return d.equals(tetr.d);
    }

    @Override
    public int hashCode() {
        int result = (int) (tetraId ^ (tetraId >>> 32));
        result = 31 * result + a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + d.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Id: " + tetraId + ", a = (" + a.getX() + "," + a.getY() + "," + a.getZ() + "), " +
                "b = (" + b.getX() + "," + b.getY() + "," + b.getZ() + "), " +
                "c = (" + c.getX() + "," + c.getY() + "," + c.getZ() + "), " +
                "d = (" + d.getX() + "," + d.getY() + "," + d.getZ() + ")" + "\n" +
                "volume: " + volume + ", square: " + square;
    }
}
