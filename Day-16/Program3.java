import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String raw1[] = scn.nextLine().split(" ");
        String raw2[] = scn.nextLine().split(" ");

        int box1[] = new int[raw1.length];
        int box2[] = new int[raw2.length];

        for (int i = 0; i < box1.length; i++) {
            box1[i] = Integer.parseInt(raw1[i]);
        }
        for (int i = 0; i < box2.length; i++) {
            box2[i] = Integer.parseInt(raw2[i]);
        }

        System.out.println(getNextLargestGoldCoins(box1, box2));

        scn.close();
    }

    static List<Integer> getNextLargestGoldCoins(int[] box1, int[] box2) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < box2.length; i++) {
            indexMap.put(box2[i], i);
        }

        List<Integer> result = new ArrayList<>(box1.length);

        for (int coin : box1) {
            int pos = indexMap.get(coin) + 1;
            for (; pos < box2.length; pos++) {
                if (coin < box2[pos]) {
                    result.add(box2[pos]);
                    break;
                }
            }
            if (pos == box2.length) {
                result.add(-1);
            }
        }

        return result;
    }
}
