package combination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ken
 * @date 2019/5/19  0:11
 * @description
 */
public class Company implements  Root,Iterable<Root> {
    List<Root > list =new ArrayList<>();

    private  String name;

    public List<Root> getList() {
        return list;
    }

    public void setList(List<Root> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }

    @Override
    public void add(Root child) {
        list.add(child);
    }

    @Override
    public void remove(Root child) {
        list.remove(child);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }

    @Override
    public void handle() {

    }

    @Override
    public Iterator<Root> iterator() {
        return list.iterator();
    }
}
