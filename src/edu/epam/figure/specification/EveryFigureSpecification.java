package edu.epam.figure.specification;

import edu.epam.figure.entity.Tetrahedron;


public class EveryFigureSpecification implements Specification<Tetrahedron> {
    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        return true;
    }

}
