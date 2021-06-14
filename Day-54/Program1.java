import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int colors[] = new int[n];
        int k = scn.nextInt();
        for (int i = 0; i < colors.length; i++) {
            colors[i] = scn.nextInt();
        }

        System.out.println(getSubArrayUniqColors(colors, k));

        scn.close();
    }

    public static List<Integer> getSubArrayUniqColors(int[] colors, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>(colors.length - k + 1);
        int intermCount = 0;
        for (int i = 0; i < colors.length; i++) {
            if (countMap.containsKey(colors[i])) {
                countMap.put(colors[i], countMap.get(colors[i]) + 1);
            } else {
                countMap.put(colors[i], 1);
                intermCount++;
            }

            if (i >= k - 1) {
                if (i >= k) {
                    countMap.put(colors[i - k], countMap.get(colors[i - k]) - 1);
                    if (countMap.get(colors[i - k]) <= 0) {
                        countMap.remove(colors[i - k]);
                        intermCount--;
                    }
                }
                result.add(intermCount);
            }
        }

        return result;
    }
}