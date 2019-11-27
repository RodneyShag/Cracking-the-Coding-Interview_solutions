// github.com/RodneyShag

package _16_20_T9__Trie_Solution;

import java.util.HashMap;

class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap();
    public int size;

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}
