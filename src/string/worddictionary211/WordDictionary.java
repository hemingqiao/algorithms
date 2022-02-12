package src.string.worddictionary211;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/16 15:31:56
 * description:
 */
public class WordDictionary {
    static class Node {
        boolean isEnd;
        Node[] son = new Node[26];
    }

    Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(Node p, String s, int k) {
        if (k == s.length()) return p.isEnd;
        char c = s.charAt(k);
        if (c != '.') {
            int u = c - 'a';
            if (p.son[u] == null) return false;
            return dfs(p.son[u], s, k + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                if (p.son[i] != null && dfs(p.son[i], s, k + 1)) return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
