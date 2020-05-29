package leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author syh
 * @date 2020/03/18
 */
public class Question24 {
    public  static  ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode before=null;
        while (head != null) {
            ListNode next = head.next;
            if (next != null) {
                head.next = next.next;
                next.next = head;
                if(before!=null)
                {
                    before.next=next;
                }
                before=head;
            }
            head = head.next;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        listNode.next=listNode2;
        ListNode listNode3=new ListNode(3);
        listNode2.next=listNode3;
        ListNode listNode4=new ListNode(4);
        listNode3.next=listNode4;

        ListNode listNode1 = swapPairs(listNode);
        System.out.println(listNode1);

    }
}

