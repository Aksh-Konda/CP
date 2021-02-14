import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String words[] = scn.nextLine().split(",");
        int p = scn.nextInt();

        System.out.println(getTopUsedWords(words, p));

        scn.close();
    }

    static List<String> getTopUsedWords(String[] words, int p) {
        Trie trie = new Trie();
        trie.addWords(words);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        trie.pushWords(trie.root, pq);

        List<String> result = new ArrayList<String>();
        while (p > 0 && !pq.isEmpty()) {
            result.add(pq.poll().word);
            p--;
        }
        return result;
    }
}

class Trie {
    class Node {
        int count;
        String endString;
        Node links[];

        Node() {
            links = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void addWords(String[] words) {
        for (String word : words) {
            addWord(word);
        }
    }

    public void addWord(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.links[idx] == null) {
                curr.links[idx] = new Node();
            }
            curr = curr.links[idx];
        }

        curr.endString = word;
        curr.count += 1;
    }

    public void pushWords(Node curr, Queue<Pair> pq) {
        if (curr == null)
            return;

        for (Node link : curr.links) {
            if (link != null) {
                if (link.endString != null)
                    pq.offer(new Pair(link.endString, link.count));
                pushWords(link, pq);
            }
        }
    }
}

class Pair implements Comparable<Pair> {
    String word;
    int count;

    public Pair(String w, int c) {
        word = w;
        count = c;
    }

    @Override
    public int compareTo(Pair p) {
        if (p.count == this.count)
            return this.word.compareTo(p.word);
        return p.count - this.count;
    }
}