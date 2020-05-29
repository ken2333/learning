package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author syh
 * @date 2020/03/24
 */
public class Question1617 {
    public static int massage(int[] nums) {
        if (nums.length == 0)
            return 0;
        else
        {
            int result=0;
            for(int i=0;i<nums.length;i++)
            {
                int jisuan=jisuan(nums,i);
                if(jisuan>result)
                    result=jisuan;
            }
            return result;
        }
    }

    public static int jisuan(int[] nums, int start) {
        int length = nums.length;
        int result = nums[start];
        if (start + 2 < length) {
            int tem = 0;
            for (int i = start + 2; i < length; i = i + 1) {
                int jisuan = jisuan(nums, i);
                if (jisuan > tem)
                    tem = jisuan;
            }
            result = result + tem;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(massage(nums));
    }
}
