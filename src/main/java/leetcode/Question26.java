package leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author syh
 * @date 2020/03/18
 */
public class Question26 {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && nums[i] == nums[i + 1]) {
                int count = 1;
                i++;
                while (i + 1 < length && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                dele(nums, i , count);
                i-=count;
                length-=count;
            }
        }
        return length;
    }

    public static void dele(int[] nums, int index, int count) {
        for (int i = (index - count); i < nums.length - count; i++) {
            nums[i] = nums[count + i];
        }
    }


    public static void main(String[] args) {
        int[] i = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5};

        int i1 = removeDuplicates(i);
        System.out.println(i1);
    }
}

