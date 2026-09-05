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
    public void reorderList(ListNode head) {
        if(null == head || null == head.next)
            return;

        List<ListNode> nodeList = new ArrayList<>();
        ListNode current = head;

        while(current != null) {
            nodeList.add(current);
            current = current.next;
        }

        int l = 0;
        int r = nodeList.size() - 1;
        while(l <= r) {
            nodeList.get(l).next = nodeList.get(r);
            l++;
            nodeList.get(r).next = nodeList.get(l);
            r--;
        }
        nodeList.get(l).next.next = null;
    }
}
