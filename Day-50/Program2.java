import java.util.*;

public class Program2 {
    final static String open = "<i>";
    final static String close = "</i>";

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.nextLine(); // clearing new line character
        String keys[] = scn.nextLine().split(" ");

        System.out.println(emphasize(s, keys));

        scn.close();
    }

    static String emphasize(String s, String keys[]) {
        Trie trie = new Trie(keys);
        char chars[] = s.toCharArray();

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            int end = -1;
            int k = i;
            while (k <= end + 1) {
                end = Math.max(end, trie.find(chars, k));
                k++;
            }
            if (end == -1) {
                result.append(chars[i++]);
            } else {
                result.append(open);
                while (i <= end) {
                    result.append(chars[i++]);
                }
                result.append(close);
            }
        }

        return result.toString();
    }
}

class Node {
    Node next[];
    boolean isEnd;

    Node() {
        next = new Node[256];
    }
}

class Trie {
    Node root;

    Trie(String words[]) {
        root = new Node();
        for (String word : words) {
            add(word.toCharArray());
        }
    }

    public void add(char[] word) {
        Node curr = root;

        for (char ch : word) {
            if (curr.next[ch] == null) {
                curr.next[ch] = new Node();
            }
            curr = curr.next[ch];
        }

        curr.isEnd = true;
    }

    public int find(char[] word, int i) {
        Node curr = root;

        int presrv = -1;
        for (; i < word.length; i++) {
            if (curr.next[word[i]] == null)
                return presrv;
            if (curr.next[word[i]].isEnd) {
                presrv = i;
            }
            curr = curr.next[word[i]];
        }

        return presrv;
    }
}

// <i>aaaaabb</i>bbb<i>bcc</i>cc