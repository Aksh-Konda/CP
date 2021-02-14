import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        System.out.println(getQuads(nums, n));

        scn.close();
    }

    public static int getQuads(int nums[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = nums[i] * nums[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int result = 0;
        for (int key : map.keySet()) {
            int c = map.get(key);
            if (c > 1) {
                result += c * (c - 1) * 4;
            }
        }

        return result;
    }
}