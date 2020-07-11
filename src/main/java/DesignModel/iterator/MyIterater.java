package DesignModel.iterator;

public interface MyIterater<T> {


    public boolean isFirst();

    public boolean hasNext();

    public T  next();

    public boolean isLast();

    public T getObject();

}
