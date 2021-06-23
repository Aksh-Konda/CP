//Sample Binary tree node sturcture for reference 

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public BinaryTreeNode horizontalFlippedTree(BinaryTreeNode root) {
        if (root == null || root.data == -1 || root.left == null || root.left.data == -1)
            return root;
        BinaryTreeNode newRoot = horizontalFlippedTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}
