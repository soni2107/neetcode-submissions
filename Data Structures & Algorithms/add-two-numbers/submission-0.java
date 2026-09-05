/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carryOver = 0;
        while(null != l1 && null != l2) {
            int sum = l1.val + l2.val + carryOver;
            if(sum < 10) {
                head.next = new ListNode(sum);
                carryOver = 0;
            }
            else {
                head.next = new ListNode(sum % 10);
                carryOver = 1;
            }
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(null != l1) {
            int sum = l1.val + carryOver;
            if(sum < 10) {
                head.next = new ListNode(sum);
                carryOver = 0;
            }
            else {
                head.next = new ListNode(sum % 10);
                carryOver = 1;
            }
            l1 = l1.next;
            head = head.next;
        }

        while(null != l2) {
            int sum = l2.val + carryOver;
            if(sum < 10) {
                head.next = new ListNode(sum);
                carryOver = 0;
            }
            else {
                head.next = new ListNode(sum % 10);
                carryOver = 1;
            }
            l2 = l2.next;
            head = head.next;
        }

        if(carryOver != 0) {
            head.next = new ListNode(carryOver);
        }
        return result.next;
    }

    
}
