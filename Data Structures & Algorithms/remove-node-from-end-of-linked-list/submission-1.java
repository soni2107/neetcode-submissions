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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(null == head || null == head.next) {
            return null;
        }
        
        List<ListNode> nodeList = new ArrayList<>();
        ListNode current = head;
        while(null != current) {
            nodeList.add(current);
            current = current.next;
        }

        int indexToRemove = nodeList.size() - n;
        int indexPrev = indexToRemove - 1;
        int indexNext = indexToRemove + 1;

        if(indexPrev >= 0 && indexNext < nodeList.size()) {
            nodeList.get(indexPrev).next = nodeList.get(indexNext);
        }
        else if(indexPrev >= 0) {
            nodeList.get(indexPrev).next = null;
        }
        else {
            return nodeList.get(indexToRemove).next;
        }
        
        return head;
    }
}
