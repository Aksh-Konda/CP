import java.util.*;

class Solution {

    // segemnt tree node class
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        boolean isOccupied;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            isOccupied = false;
        }
    }

    SegmentTreeNode root;

    // Method to return the maximum programs can attend
    public int maxPrograms(int[][] programs) {
        int minL = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        for (int i = 0; i < programs.length; i++) {
            if (minL > programs[i][0])
                minL = programs[i][0];
            if (maxR < programs[i][1])
                maxR = programs[i][1];
        }
        root = buildSegmentTree(root, minL, maxR);

        Arrays.sort(programs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        int count = 0;
        for (int[] program : programs) {
            if (query(root, program[0], program[1])) {
                count++;
            }
        }

        return count;
    }

    // Method to build segment tree
    private SegmentTreeNode buildSegmentTree(SegmentTreeNode curr, int start, int end) {
        if (curr == null) {
            curr = new SegmentTreeNode(start, end);
            if (curr.start == curr.end)
                return curr;
        }
        int m = (start + end) / 2;
        curr.left = buildSegmentTree(curr.left, start, m);
        curr.right = buildSegmentTree(curr.right, m + 1, end);

        return curr;
    }

    // method to perform update segment tree
    // private void update(SegmentTreeNode curr, int lastDay) {

    // }

    // Method to perform Query
    private boolean query(SegmentTreeNode curr, int left, int right) {
        if (left > right || curr == null || curr.isOccupied)
            return false;
        if (curr.left == curr.right) {
            if (curr.isOccupied)
                return false;
            curr.isOccupied = true;
            return true;
        }
        boolean result = query(curr.left, left, curr.left.end < right ? curr.left.end : right)
                || query(curr.right, curr.right.start > left ? curr.right.start : left, right);
        curr.isOccupied = curr.right.isOccupied && curr.left.isOccupied;

        return result;
    }

}