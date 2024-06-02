package cpclub.weekfive;

import daily.leetcode.ListNode;

public class ReorderList {

    ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;

        mid.next = null;
        head2 = reverseRecursive(head2);

        ListNode node = head;
        ListNode temp;
        while (node != null || head2 != null) {
            temp = node.next;
            node.next = head2;

            node = node.next;
            head2 = temp;
        }
    }
}
