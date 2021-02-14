import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String raw[] = scn.nextLine().split(" ");
        int levels[] = new int[raw.length];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = Integer.parseInt(raw[i]);
        }

        System.out.println(getWaterFilled(levels));

        scn.close();
    }

    static int getWaterFilled(int[] levels) {
        int water = 0;
        int i = 0;
        while (i < levels.length - 1) {
            int max = Integer.MIN_VALUE;
            int idxMax = i;
            int idxG = i;
            for (int j = i + 1; j < levels.length; j++) {
                if (max < levels[j]) {
                    max = levels[j];
                    idxMax = j;
                }
                if (levels[j] > levels[i] && idxG == i) {
                    idxG = j;
                    break;
                }
            }

            int j = idxG != i ? idxG : idxMax;
            int min = Math.min(levels[i], levels[j]);

            for (int k = i + 1; k < j; k++) {
                water += min - levels[k];
            }

            i = j;
        }

        return water;
    }
}
