package edu.epam.figure.specification;

public interface Specification<T> {
    boolean specify(T t);
}
