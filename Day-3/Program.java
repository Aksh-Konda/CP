public class Program {
    public static void main(String[] args) {
        MinSegmentTree segmentTree = new MinSegmentTree(
                new int[] { 66905, 11444, 18252, 54299, 10208, 59466, 17861, 24128, 31974, 69081 }, 10);
        System.out.println(segmentTree.findMinimum(10, 2, 9));
    }
}
