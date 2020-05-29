package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Question19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        arrayList.add(head);
        ListNode next = head.next;
        while (next != null) {
            arrayList.add(next);
            next = next.next;
        }
        int size = arrayList.size();
        if (size == 1 && n == 1)
            return null;
        if (n > size)
            return head;
        int index = size - n;
        if (index == 0) {
            head = arrayList.get(1);
        } else if (index > 0) {
            ListNode before = arrayList.get(index - 1);
            ListNode after = arrayList.get(index).next;
            if (after != null) {
                before.next = after;
            } else {
                before.next = null;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        ListNode head5 = new ListNode(5);
        head4.next = head5;
        removeNthFromEnd(head, 1);
        System.out.println(head.val);
    }
}
