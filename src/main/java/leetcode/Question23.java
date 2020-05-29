package leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author syh
 * @date 2020/03/18
 */
public class Question23 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
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

    public ListNode insert(ListNode node, ListNode list) {
        if (list.val >= node.val) {
            node.next = list.next;
            list.next = node;
            Integer tem = list.val;
            list.val = node.val;
            node.val = tem;
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

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 1 || length == 0)
            return length == 0 ? null : lists[0];
        ListNode node = lists[0];
        for (int i = 1; i < length; i++) {
            mergeTwoLists(lists[i], node);
        }
        return node;
    }


    public static void main(String[] args) {
        Question23 question23=new Question23();
        System.out.println(question23.mergeTwoLists(new ListNode(), new ListNode(1)));
    }
}

