package blogandquestion.algorithms.others.trie208;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/14 18:33:56
 * description:
 */
public class Trie0 {
    private List<String> container = new ArrayList<>();

    /** Initialize your data structure here. */
    public Trie0() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (container.contains(word)) return;
        container.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return container.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String s : container) {
            if (s.startsWith(prefix)) return true;
        }
        return false;
    }
}
