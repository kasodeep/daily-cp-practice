package daily.leetcode;

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodes {

    // One of the best solutions, self prove!
    public static ListNode removeZeroSumSubLists(ListNode head) {
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        int prefixSum = 0;

        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(prefixSum, startNode);
        while (head != null) {
            prefixSum += head.val;
            map.put(prefixSum, head);
            head = head.next;
        }

        head = startNode;
        prefixSum = 0;
        while (head != null) {
            prefixSum += head.val;
            head.next = map.get(prefixSum).next;
            head = head.next;
        }
        return startNode.next;
    }
}
