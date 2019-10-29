package conneciont;

import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.apache.commons.collections4.ComparatorUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author ken
 * @date 2018-12-1  22:41
 * @description  对比工具类ComparatorUtils的使用
 */
public class th3 {

    @Test
    public void test()
    {
        Comparator<Boolean> booleanComparator = ComparatorUtils.booleanComparator(true);
        int compare = booleanComparator.compare(true, false);
        System.out.println(compare);

    }

    @Test
    public void test2()
    {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("21");
        list.add("1");

    }
}
