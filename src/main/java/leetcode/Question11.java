package leetCode;

/**
 * describe:给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2019/09/08
 */
public class Question11 {
    public static int maxArea(int[] height) {
        int length=height.length;
        if(length==2)
        {
            return  Math.min(height[0],height[1]);
        }
        int result=0;
        for (int i = 0; i < length; i++) {
            int m=height[i];
            int k=0;
           while(k<i)
           {
               int  n=height[k];
               if(m<=n)
               {
                   int tem=m*(i-k);
                   if(tem>result)
                       result=tem;
                   break;
               }
               k++;
           }
           int j=length-1;
            while(j>i)
            {
                int  n=height[j];
                if(m<=n)
                {
                    int tem=m*(j-i);
                    if(tem>result)
                        result=tem;
                    break;
                }
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       int [] i=new int[]{1,2,4,3};
        System.out.println(maxArea(i));
    }
}
