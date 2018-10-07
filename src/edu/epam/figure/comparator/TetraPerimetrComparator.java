package edu.epam.figure.comparator;

import edu.epam.figure.entity.Tetrahedron;

import java.util.Comparator;

public class TetraPerimetrComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return (int) (o1.getPerimetr() - o2.getPerimetr());
    }
}
