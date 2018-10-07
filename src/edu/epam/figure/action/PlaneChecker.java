package edu.epam.figure.action;

import edu.epam.figure.entity.Tetrahedron;

public class PlaneChecker {

    public boolean isOnPlaneX(Tetrahedron tetr){
        if(tetr.getA().getX() == 0 && tetr.getB().getX() == 0 && tetr.getC().getX() == 0){
            return true;
        }
        return false;
    }
    public boolean isOnPlaneY(Tetrahedron tetr){
        if(tetr.getA().getY() == 0 && tetr.getB().getY() == 0 && tetr.getC().getY() == 0){
            return true;
        }
        return false;
    }
    public boolean isOnPlaneZ(Tetrahedron tetr){
        if(tetr.getA().getZ() == 0 && tetr.getB().getZ() == 0 && tetr.getC().getZ() == 0){
            return true;
        }
        return false;
    }

}
