package _16_20_T9__Trie_Solution;

class Trie {
    TrieNode root = new TrieNode();

    Trie() {} // default constructor

    Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    public void add(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public boolean find(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return false;
            }
        }
        return true;
    }
}
