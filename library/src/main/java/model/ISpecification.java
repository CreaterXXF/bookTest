package model;

public interface ISpecification<T> {
    boolean isSatisfiedBy(T t);
}
