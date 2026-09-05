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
            if(null == current.children[c - 'a']) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(null == current.children[c - 'a'])
                return false;
            current = current.children[c - 'a'];
        }
        if(current.endOfWord)
            return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()) {
            if(null == current.children[c - 'a'])
                return false;
            current = current.children[c - 'a'];
        }
        return true;
    }
}
