package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * 参考答案:https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 */
public class Question15_1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnArr = new ArrayList<>();
        if (nums.length == 0)
            return returnArr;
        quickSort(nums, 0, nums.length - 1);
        int size = nums.length;
        for (int i = 0; i < size; ) {
            int k = i + 1;
            int j = size - 1;
            while (k < j) {
                int temSum = nums[i] + nums[k] + nums[j];
                if (temSum == 0) {
                    ArrayList<Integer> tem = new ArrayList<>();
                    tem.add(nums[i]);
                    tem.add(nums[k]);
                    tem.add(nums[j]);
                    returnArr.add(tem);
                } else if (temSum > 0) {
                    while ((j-1)>=0&&nums[j] == nums[j - 1]) {
                        j--;
                    }
                    j--;
                } else if (temSum < 0) {
                    while ((k+1)<size&&nums[k] == nums[k + 1]) {
                        k++;
                    }
                    k++;
                }
                if (j == k)
                    break;

            }
            while ((i + 1) < size && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }

        return returnArr;
    }


    public static void main(String[] args) {
        /*List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        lists.forEach((list) -> {
            System.out.println(list);
        });
        */
        int[] ints = new int[]{-1, -1, 1, -1, -1, 4};
        quickSort(ints,0,ints.length-1);
        int size=ints.length;
        for(int i=0;i<ints.length;)
        {
            while((i+1)<size&&ints[i]==ints[i+1])
            {
                i++;
            }
            i++;

        }
    }


    public static void quickSort(int[] a, int star, int end) {
        int i = star;
        int j = end;
        int m = a[i];
        while (i < j) {
            while (a[j] > m && j > i) {
                j--;
            }
            if (j > i) {
                a[i] = a[j];
                i++;
            }
            while (a[i] < m && j > i) {
                i++;
            }
            if (j > i) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = m;

        if (i - 1 > star) {
            quickSort(a, star, i - 1);
        }
        if (i + 1 < end) {
            quickSort(a, i + 1, end);
        }
    }


}
