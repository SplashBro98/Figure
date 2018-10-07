package edu.epam.figure.comparator;

import edu.epam.figure.entity.Tetrahedron;

import java.util.Comparator;

public class TetraSquareComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        if(o1.getSquare() < o2.getSquare()){
            return -1;
        }
        if(o1.getSquare() > o2.getSquare()){
            return 1;
        }
        return 0;
    }
}
