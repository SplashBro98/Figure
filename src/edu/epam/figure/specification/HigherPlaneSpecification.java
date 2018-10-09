package edu.epam.figure.specification;

import edu.epam.figure.entity.Tetrahedron;

public class HigherPlaneSpecification implements Specification<Tetrahedron> {

    @Override
    public boolean specify(Tetrahedron tetr) {
        return (tetr.getA().getZ() >= 0 && tetr.getB().getZ() >= 0 &&
                tetr.getC().getZ() >= 0 && tetr.getD().getZ() >= 0);
    }
}
