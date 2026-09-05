/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(null == node)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Stack<Node> visitedStack = new Stack<>();
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            visitedStack.push(current);
            map.put(current, new Node(current.val));
            List<Node> neighbors = current.neighbors;
            for(Node nNode: neighbors) {
                if(!visitedStack.contains(nNode))
                    stack.push(nNode);
                map.putIfAbsent(nNode, new Node(nNode.val));
            }
        }

        for(Node oNode : map.keySet()) {
            Node newNode = map.get(oNode);
            for(Node nNode : oNode.neighbors) {
                newNode.neighbors.add(map.get(nNode));
            }
        }

        return map.get(node);
    }
}