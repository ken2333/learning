package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * describe:
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2020/03/23
 */
public class Question148 {
    public static ListNode sortList(ListNode head) {

        List<ListNode> listNode = new ArrayList<>();
        ListNode next = head;
        while (next != null) {
            listNode.add(next);
            next = next.next;
        }
        ListNode[] objects = listNode.toArray(new ListNode[]{});
        quickSort(objects, 0, objects.length - 1);
        int length = objects.length;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length)
                objects[i].next = objects[i + 1];
            else {
                objects[i].next = null;
            }
        }

        return objects[0];
    }

    public static void quickSort(ListNode[] arr, int low, int high) {
        int i, j;
        ListNode temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = (ListNode) arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp.val <= arr[j].val && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp.val >= arr[i].val && i < j) {
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
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(7);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(1);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;
        sortList(listNode);
    }
}
