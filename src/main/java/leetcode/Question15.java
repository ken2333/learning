package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2019/09/21
 */
public class Question15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zhengshu = new ArrayList<>();
        List<Integer> fushu = new ArrayList<>();
        boolean flag = false;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                int tem = nums[i] + nums[k];
                if (tem == 0 && flag) {
                    List<Integer> temlist = new ArrayList<>();
                    temlist.add(nums[i]);
                    temlist.add(nums[k]);
                    temlist.add(0);
                    result.add(temlist);
                } else if (tem > 0) {

                }

            }

        }

        return null;
    }

    public static void main(String[] args) {

    }
}
