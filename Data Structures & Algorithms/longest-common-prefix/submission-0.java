class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int childCount; // Tracks how many unique branching paths exist from this node

    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }

    // Corrected insert method
    public void insert(String str) {
        TrieNode node = this;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a'; // 'a' is ASCII 97
            
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.childCount++; // Increment branching count
            }
            node = node.children[index]; // Move down to the child node
        }
        node.isEndOfWord = true; // Mark the end of the word
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
        
        // Step 1: Insert all words into the Trie
        for (String str : strs) {
            // If any string is empty, the common prefix is automatically empty
            if (str.isEmpty()) {
                return "";
            }
            root.insert(str);
        }

        // Step 2: Walk down the Trie to find the longest common prefix
        StringBuilder prefix = new StringBuilder();
        TrieNode node = root;
        
        // Loop through the first word to find matching prefix paths
        String firstWord = strs[0];
        for (int i = 0; i < firstWord.length(); i++) {
            char ch = firstWord.charAt(i);
            int index = ch - 'a';
            
            // LCP continues ONLY if the current node has exactly 1 child branch
            // AND we haven't hit the end of any shorter word in the array.
            if (node.childCount == 1 && !node.isEndOfWord) {
                prefix.append(ch);
                node = node.children[index];
            } else {
                break;
            }
        }

        return prefix.toString();
    }
}
