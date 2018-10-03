package edu.epam.figure.entity;

import edu.epam.figure.exception.CustomException;
import edu.epam.figure.util.IdGenerator;
import edu.epam.figure.validator.TetraValidator;

import java.io.Serializable;

public class Tetrahedron implements Figure3D{
    private long tetraId;
    private Point a;
    private Point b;
    private Point c;
    private Point d;


    public Tetrahedron(Point a, Point b, Point c, Point d) throws CustomException{
        TetraValidator validator = new TetraValidator();
        if(!validator.correctPoints(a,b,c,d)){
            throw new CustomException("These Points can`t be a Tetrahedron");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.tetraId = IdGenerator.getTetraId();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    public long getTetraId() {
        return tetraId;
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
                "d = (" + d.getX() + "," + d.getY() + "," + d.getZ() + ")";
    }
}
