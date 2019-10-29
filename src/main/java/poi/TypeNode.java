package poi;

/**
 * @author ken
 * @date 2019-5-23  11:45
 * @description
 */
public class TypeNode  implements  Comparable<TypeNode>{


    private  int row;
    private  int column;
    private int  range;

    @Override
    public int compareTo(TypeNode o) {
        return   o.getRange()-this.range;
    }

    public TypeNode(int row, int column, int range) {
        this.row = row;
        this.column = column;
        this.range = range;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "TypeNode{" +
                "row=" + row +
                ", column=" + column +
                ", range=" + range +
                '}';
    }
}
