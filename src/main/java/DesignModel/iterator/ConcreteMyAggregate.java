package DesignModel.iterator;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/07
 */
public class ConcreteMyAggregate<T> {

    List<T> list = new ArrayList<>();



    int curosr = 0;

    public  void add(T object)
    {
        list.add(object);
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    public MyIterater getIterator() {
        return  new Iterator();
    }

    private class Iterator implements MyIterater<T> {
        private Iterator() {
        }

        @Override
        public boolean isFirst() {
            if (curosr == 0)
                return true;
            else
                return false;
        }

        @Override
        public boolean hasNext() {
            if (list.size() > curosr)
                return true;
            else
                return false;
        }

        @Override
        public T next() {
            return list.get(curosr++);
        }

        @Override
        public boolean isLast() {
            if (list.size()-1==curosr) {
                return true;
            }else {
                return false;
            }
        }

        @Override
        public T getObject() {
            return list.get(curosr);
        }
    }
}
