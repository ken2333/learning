package guava;

import org.junit.Test;

import java.util.EnumSet;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/12
 */
public enum EnumDay {
    MON("星期一", 1), TUE("星期二", 2), WED("星期三", 3),FRI("星期4",4);

    private String name;
    private int index;

    EnumDay(String name, int index) {
        this.name = name;
        this.index = index;
    }


    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }


}

