class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.endOfWord = false;
    }
}

class PrefixTree {

    TrieNode root;
    
    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(null == current.children[i]) {
                current.children[i] = new TrieNode();
            }
            current = current.children[i];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(null == current.children[i])
                return false;
            current = current.children[i];
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()) {
            int i = c - 'a';
            if(null == current.children[i])
                return false;
            current = current.children[i];
        }
        return true;
    }
}
