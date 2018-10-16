package edu.epam.figure.action;

import edu.epam.figure.entity.Tetrahedron;

public class PlaneChecker {

    public boolean isOnPlaneX(Tetrahedron tetr){
        return (tetr.getA().getX() == 0 && tetr.getB().getX() == 0 && tetr.getC().getX() == 0);
    }
    public boolean isOnPlaneY(Tetrahedron tetr){
        return (tetr.getA().getY() == 0 && tetr.getB().getY() == 0 && tetr.getC().getY() == 0);
    }
    public boolean isOnPlaneZ(Tetrahedron tetr){
        return (tetr.getA().getZ() == 0 && tetr.getB().getZ() == 0 && tetr.getC().getZ() == 0);
    }
}
