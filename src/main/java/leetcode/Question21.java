package leetcode;

import java.util.ArrayList;

/**
 * describe:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author syh
 * @date 2020/03/14
 */
public class Question21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
        {
            return  l1==null?l2:l1;
        }
        ListNode next = l1;
        ArrayList<ListNode> list = new ArrayList<>();
        while (next != null) {
            list.add(next);
            next = next.next;
        }
        for (int i = 0; i < list.size(); i++) {
             insert(list.get(i), l2);
        }
        return l2;
    }

    public static ListNode insert(ListNode node, ListNode list) {
        if (list.val >= node.val) {
            node.next=list.next;
            list.next=node;
            Integer tem=list.val;
            list.val=node.val;
            node.val=tem;
            return list;
        }
        ListNode next = list;
        ListNode befor = null;
        while (next != null && next.val < node.val) {
            befor = next;
            next = next.next;
        }
        if (next == null) {
            befor.next = node;
            node.next = null;
        } else {
            befor.next = node;
            node.next = next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        l1.next = l11;
        ListNode l12 = new ListNode(4);
        l11.next = l12;


        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        l21.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;


        mergeTwoLists(l1, l21);
        System.out.println(l1.val);
    }
}
