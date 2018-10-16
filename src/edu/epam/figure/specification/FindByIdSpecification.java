package edu.epam.figure.specification;

import edu.epam.figure.entity.Tetrahedron;

public class FindByIdSpecification implements Specification<Tetrahedron> {
    private long id;

    public FindByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        return (id == tetrahedron.getTetraId());
    }
}
