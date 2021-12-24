package blogandquestion.algorithms.others.trie208;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/14 18:40:28
 * description:
 */
public class Trie1 {
    private Set<String> container = new HashSet<>();

    /** Initialize your data structure here. */
    public Trie1() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        container.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // return container.contains(word);
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
