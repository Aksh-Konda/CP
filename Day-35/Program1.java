import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int s = scn.nextInt();
        int bookings[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            bookings[i][0] = scn.nextInt();
            bookings[i][1] = scn.nextInt();
            bookings[i][2] = scn.nextInt();
        }

        System.out.println(canFullFil(n, s, bookings));

        scn.close();
    }

    static boolean canFullFil(int n, int s, int bookings[][]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] bk : bookings) {
            map.put(bk[1], map.getOrDefault(bk[1], 0) + bk[0]);
            map.put(bk[2], map.getOrDefault(bk[2], 0) - bk[0]);
        }
        Object keys[] = map.keySet().toArray();
        Arrays.sort(keys);
        for (Object key : keys) {
            s -= map.get(key);
            if (s < 0)
                return false;
        }

        return true;
    }
}