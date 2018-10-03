package edu.epam.figure.entity;

import edu.epam.figure.exception.CustomException;

public class RegularTetrahedron extends Tetrahedron {
    private double length;

    public RegularTetrahedron(Point a, Point b, Point c, Point d, double length) throws CustomException {
        super(a, b, c, d);
        this.length = length;
    }

    public RegularTetrahedron(Point a, Point b, Point c, Point d) throws CustomException{
        super(a, b, c, d);
        this.length = Math.pow((Math.sqrt(this.getA().getX() - this.getB().getX()) + Math.sqrt(this.getA().getY() - this.getB().getY()) +
                Math.sqrt(this.getA().getZ() - this.getB().getZ())),0.5);
    }

    public double getLength() {
        return length;
    }
}
