package edu.epam.figure.repository;

import edu.epam.figure.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T t);
    void remove(T t);
    void sort(Comparator<T> comparable);

    List<T> query(Specification specification);

}
