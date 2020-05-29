package leetcode;

/**
 * describe:
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * @author syh
 * @date 2020/03/19
 */
public class Question945 {
    /**
     *  解题的思路就遍历一遍数组，只要当前的位置的数值比前面大1就可以了。
     * @param A
     * @return
     */
    public static int minIncrementForUnique(int[] A) {
        quickSort(A, 0, A.length - 1);
        int length = A.length;
        int result = 0;
      /*  for (int i = 0; i < length; ) {
            if (i+1<length&&A[i] == A[i + 1]) {
                A[i] = A[i] + 1;
                result++;
                quickSort(A, i, length - 1);
            }else{
                i++;
            }
        }
        return result;*/
        if (length == 1||length==0)
            return 0;
        for (int i = 1; i < length; i++) {
            if (A[i]<=A[i-1])
            {
                result+=A[i-1]+1-A[i];
                A[i]=A[i-1]+1;
            }
        }
        return result;
    }


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
      /*  quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        int[] arr2 = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(arr2));

    }

}
