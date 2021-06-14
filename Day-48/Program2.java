import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int h = scn.nextInt();
        int hts[] = new int[n];

        for (int i = 0; i < n; i++) {
            hts[i] = scn.nextInt();
        }

        System.out.println(getPositions(hts, h));

        scn.close();
    }

    static List<Integer> getPositions(int hts[], int h) {
        List<Integer> result = new ArrayList<>(2);

        int l = 0, u = hts.length - 1, m;

        while (l <= u) {
            m = (l + u) / 2;
            if (hts[m] > h) {
                u = m - 1;
            } else if (hts[m] < h) {
                l = m + 1;
            } else {
                if (m - 1 < 0 || hts[m - 1] != h) {
                    result.add(m);
                    break;
                } else {
                    u = m - 1;
                }
            }
        }

        if (l > u) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        l = 0;
        u = hts.length - 1;
        while (l <= u) {
            m = (l + u) / 2;
            if (hts[m] > h) {
                u = m - 1;
            } else if (hts[m] < h) {
                l = m + 1;
            } else {
                if (m + 1 >= hts.length || hts[m + 1] != h) {
                    result.add(m);
                    break;
                } else {
                    l = m + 1;
                }
            }
        }

        return result;
    }
}