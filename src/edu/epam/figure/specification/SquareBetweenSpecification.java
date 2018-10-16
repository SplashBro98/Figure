package edu.epam.figure.specification;

import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.observer.TetraObserverImpl;

public class SquareBetweenSpecification implements Specification<Tetrahedron> {
    private double minSquare;
    private double maxSquare;

    public SquareBetweenSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    public double getMinSquare() {
        return minSquare;
    }

    public void setMinSquare(double minSquare) {
        this.minSquare = minSquare;
    }

    public double getMaxSquare() {
        return maxSquare;
    }

    public void setMaxSquare(double maxSquare) {
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        double square = TetraObserverImpl.getInstance().getParametrs().get(tetrahedron.getTetraId()).getSquare();
        return (square > minSquare && square < maxSquare);
    }
}
