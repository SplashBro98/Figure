package edu.epam.figure.repository;

import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.observer.TetraObserverImpl;
import edu.epam.figure.specification.Specification;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum TetraRepository implements Repository<Tetrahedron> {
    INSTANCE;
    private List<Tetrahedron> tetrahedronList = new ArrayList<>();

    public int getAmount(){
        return tetrahedronList.size();
    }


    @Override
    public void add(Tetrahedron tetrahedron) {
        tetrahedronList.add(tetrahedron);
        TetraObserverImpl.getInstance().addTetrahedron(tetrahedron);
    }

    @Override
    public void remove(Tetrahedron tetrahedron) {
        tetrahedronList.remove(tetrahedron);
        TetraObserverImpl.getInstance().removeTetrahedron(tetrahedron.getTetraId());
        tetrahedron.removeObserver(TetraObserverImpl.getInstance());
    }


    @Override
    public void sort(Comparator<Tetrahedron> comparator) {
        tetrahedronList.sort(comparator);
    }

    @Override
    public List<Tetrahedron> query(Specification specification) {
        return tetrahedronList.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Repository: \n");
        tetrahedronList.forEach(o -> builder.append(o.toString()));
        return builder.append("\n").toString();
    }
}
