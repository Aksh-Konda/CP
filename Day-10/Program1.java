import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String word = scn.next();

        Trie trie = new Trie();

        System.out.println(trie.addAllSuffix(word));

        scn.close();
    }
}

class Trie {
    class Node {
        Node links[];

        Node() {
            links = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    int addAllSuffix(String word) {
        char[] chars = word.toCharArray();

        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            count += addWord(chars, i, root);
        }

        return count;
    }

    int addWord(char[] word, int i, Node curr) {
        if (word.length <= i)
            return 0;
        int idx = word[i] - 'a';
        int count = 0;
        if (curr.links[idx] == null) {
            curr.links[idx] = new Node();
            count++;
        }
        count += addWord(word, i + 1, curr.links[idx]);
        return count;
    }
}