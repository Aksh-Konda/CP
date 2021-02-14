import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String raw[] = scn.nextLine().split(" ");
        int nums[] = new int[raw.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(raw[i]);
        }

        System.out.println(getMinCost(nums));

        scn.close();
    }

    static int getMinCost(int nums[]) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }

        int min = 0;

        while (minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll();
            min += cost;
            minHeap.offer(cost);
        }

        return min;
    }
}
