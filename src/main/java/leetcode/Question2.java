package leetCode;

/**
 * describe:
 *
 * @author syh
 * @date 2019/08/28
 */
public class Question2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tem1 = l1;
        ListNode tem2 = l2;
        ListNode newNode = null;
        ListNode header = null;
        boolean flag = false;
        while ((tem1 != null || tem2 != null) || flag) {
            int result = 0;
            if (tem1 != null && tem2 != null) {
                result = tem1.val + tem2.val;
            } else if (tem1 != null || tem2 != null) {
                result = (tem1 != null) ? tem1.val : tem2.val;
            }
            if (flag) {
                result += 1;
                flag = false;
            }
            if (result > 9) {
                result -= 10;
                flag = true;
            }
            if (newNode == null) {
                newNode = new ListNode(result);
                header = newNode;
            } else {
                newNode.next = (new ListNode(result));
                newNode = newNode.next;
            }
            tem1 = (tem1 != null) ? tem1.next : null;
            tem2 = (tem2 != null) ? tem2.next : null;
        }
        return header;
    }

    public static void main(String[] args) {

        //321
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        //54
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode result = addTwoNumbers(l1, l4);
        System.out.println(result);
    }
}
