package dataStruct;

/**
 * describe: 简单的二叉树
 *
 * @author syh
 * @date 2020/06/08
 */
public class SimpleTree implements  TwoTree {

    Node root;

    Node current;

    @Override
    public void add(Node object) {
        if (root == null) {
            root = object;
            current=root;
        }else  {
            Integer value = current.getValue();
            Integer value1 = object.getValue();
            if(current==null)
            {
                current = object;
            }
            if(value>value1)
            {
                current = root.getRight();
                
            }else {

            }
        }
    }

    @Override
    public void remove(Node object) {

    }

    @Override
    public boolean contain(Node object) {
        return false;
    }

    @Override
    public void each() {

    }
}
