class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int childCount; 
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }

    public void insert(String str) {
        TrieNode node = this;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a'; 
            
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.childCount++; 
            }
            node = node.children[index]; 
        }
        node.isEndOfWord = true; 
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        TrieNode root = new TrieNode();
        
        for (String str : strs) {
            
            if (str.isEmpty()) {
                return "";
            }
            root.insert(str);
        }

        TrieNode node = root;
        String firstWord = strs[0];
        int prefixLength = 0;

        // Traverse down the Trie using the characters of the first word
        for (int i = 0; i < firstWord.length(); i++) {
            char ch = firstWord.charAt(i);
            int index = ch - 'a';

            // Conditions to continue the prefix:
            // 1. Current node has exactly one child (no branching)
            // 2. Current node is NOT the end of a word (cannot go past the shortest word)
            if (node.childCount == 1 && !node.isEndOfWord) {
                prefixLength++;
                node = node.children[index];
            } else {
                break; // Divergence or end of a word reached
            }
        }

        // Return the substring from root up to the tracked length
        return firstWord.substring(0, prefixLength);

    }
}
