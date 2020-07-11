package dataStruct;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/08
 */
public class Node {

    private  Node left;

    private Node right;

    private  Integer value;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;

    }

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
