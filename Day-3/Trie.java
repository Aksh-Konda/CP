public class Trie {
    Node root = new Node();

    class Node {
        boolean isEnd = false;
        Node[] links = new Node[26];
    }

    public void addWord(char[] word) {
        Node curr = root;

        for (char ch : word) {
            if (curr.links[ch - 'a'] == null)
                curr.links[ch - 'a'] = new Node();
            curr = curr.links[ch - 'a'];
        }

        curr.isEnd = true;
    }
}
