public class FenwickTree {
    int[] BIT;

    FenwickTree(int[] nums) {
        BIT = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            update(nums[i], i);
        }
    }

    public void update(int num, int i) {
        i += 1;
        while (i < BIT.length) {
            BIT[i] = Math.max(BIT[i], num);
            i = i + Integer.lowestOneBit(i);
        }
    }

    public int max(int i) {
        i += 1;
        int max = Integer.MIN_VALUE;
        while (i > 0) {
            max = Math.max(BIT[i], max);
            i = i - Integer.lowestOneBit(i);
        }

        return max;
    }
}