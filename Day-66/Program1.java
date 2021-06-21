import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(getMaxXor(n, nums));

        scn.close();
    }

    public static int getMaxXor(int n, int nums[]) {
        Trie trie = new Trie(nums);
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, trie.getMaxXor(num));
        }

        return max;
    }
}

class Trie {
    class Node {
        Node left, right;
    }

    Node root;

    Trie(int[] nums) {
        this.root = new Node();

        for (int num : nums) {
            add(num);
        }
    }

    public void add(int num) {
        Node curr = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (curr.left == null) {
                    curr.left = new Node();
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new Node();
                }
                curr = curr.right;
            }
        }
    }

    public int getMaxXor(int num) {
        Node curr = root;
        int res = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 1) {
                if (curr.left != null) {
                    curr = curr.left;
                    res += (1 << i);
                } else {
                    curr = curr.right;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                    res += (1 << i);
                } else {
                    curr = curr.left;
                }
            }
        }

        return res;
    }
}