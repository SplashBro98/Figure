package edu.epam.figure.repository;

import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.register.TetraRegister;
import edu.epam.figure.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public enum TetraRepository implements Repository<Tetrahedron> {
    INSTANCE;
    private List<Tetrahedron> tetrahedronList = new ArrayList<>();

    public int getAmount(){
        return tetrahedronList.size();
    }


    @Override
    public void add(Tetrahedron tetrahedron) {
        tetrahedronList.add(tetrahedron);
        TetraRegister.getInstance().addTetrahedron(tetrahedron);
    }

    @Override
    public void remove(Tetrahedron tetrahedron) {
        tetrahedronList.remove(tetrahedron);
    }

    @Override
    public void update(Tetrahedron tetrahedron) {

    }

    @Override
    public void sort(Comparator<Tetrahedron> comparator) {
        tetrahedronList.sort(comparator);
    }

    @Override
    public List<Tetrahedron> query(Specification specification) {
        List<Tetrahedron> result = new ArrayList<>();
        for(Tetrahedron tetr : tetrahedronList){
            if(specification.specify(tetr)){
                result.add(tetr);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Repository: \n");
        for(Tetrahedron tetr : tetrahedronList){
            builder.append(tetr.toString());
        }
        return builder.append("\n").toString();
    }
}
