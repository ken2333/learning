package leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * describe:矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * @author syh
 * @date 2020/03/18
 */
public class Question836 {

    private Question836 question836;

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int x2 = rec1[2];
        int y1 = rec1[1];
        int y2 = rec1[3];

        if (((x1 <= rec2[0] && x2 > rec2[0]) || ((x1 > rec2[0] && x1 < rec2[2]))) &&
                ((y1 <=rec2[1] && y2 > rec2[1]) || ((y1 > rec2[1] && y1< rec2[3])))) {
            return true;
        } else {
            return false;
        }
    }

    @Before
    public void before() {
        question836 = new Question836();
    }

    @Test
    public void test() {
        int[] test1 = new int[]{0, 0, 2, 2};
        int[] test2 = new int[]{1, 1, 3, 3};

        System.out.println(question836.isRectangleOverlap(test1, test2));
    }

}

