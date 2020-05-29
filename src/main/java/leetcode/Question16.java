package leetcode;

import java.util.*;

/**
 * describe:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数
 * ，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2019/09/21
 */
public class Question16 {


    public static int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        Integer tem = null;
        Integer result = null;
        for (int i = 0; i < size; i++) {
            for (int k = i + 1; k < size; k++) {
                for (int j = k + 1; j < size; j++) {
                    int l = nums[i] + nums[k] + nums[j];
                    if (tem == null && result == null) {
                        tem = minu(l, target);
                        result = l;
                    } else {
                        int m = minu(l, target);
                        if (m < tem) {
                            result = l;
                            tem=m;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int minu(int a, int b) {
        if (a == b)
            return 0;
        if (b > a) {
            int tem = b;
            b = a;
            a = tem;
        }
        if (a > 0 && b > 0) {
            return a - b;
        } else if (a < 0 && b < 0) {
            return -b - (-a);
        } else {
            return a + (-b);
        }
    }

    public static void main(String[] args) {
        //System.out.println(minu(1, 1));
        int  [] test=new int[]{-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(test, -1));
    }
}
