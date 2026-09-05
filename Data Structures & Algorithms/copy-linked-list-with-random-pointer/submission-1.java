/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(null == head)
            return null;
        List<Node> list = new ArrayList<>();
        List<Node> deepCopyList = new ArrayList<>();
        Node current = head;
        while(null != current) {
            list.add(current);
            current = current.next;
        }

        Node prev = null;
        for(Node node : list) {
            Node newNode = new Node(node.val);
            deepCopyList.add(newNode);
            if(prev != null) {
                prev.next = newNode;
            }
            prev = newNode;
        }

        for(int i = 0; i < list.size(); i++) {
            int index = list.indexOf(list.get(i).random);
            if(index != -1)
                deepCopyList.get(i).random = deepCopyList.get(index);
        }

        return deepCopyList.get(0);
    }
}
