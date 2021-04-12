import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int rooms[] = new int[n];
        int items[] = new int[k];

        for (int i = 0; i < items.length; i++) {
            items[i] = scn.nextInt();
        }

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = scn.nextInt();
        }

        System.out.println(maxDeliveries(items, rooms));

        scn.close();
    }

    static int maxDeliveries(int items[], int rooms[]) {
        int n = rooms.length;
        int temp[][] = new int[2][n];

        temp[0][0] = rooms[0];
        temp[1][0] = rooms[n - 1];

        for (int i = 1, j = n - 2; i < n; i++, j--) {
            temp[0][i] = rooms[i] < temp[0][i - 1] ? rooms[i] : temp[0][i - 1];
            temp[1][i] = rooms[j] < temp[1][i - 1] ? rooms[j] : temp[1][i - 1];
        }

        Arrays.sort(items);

        int count = 0;

        int i = n - 1;
        int j = 0;

        boolean occupied[] = new boolean[n];

        while (j < items.length && i >= 0) {
            if (temp[0][i] >= items[j]) {
                j++;
                count++;
                occupied[i] = true;
            }
            i--;
        }

        i = n - 1;
        while (j < items.length && i >= 0) {
            if (temp[1][i] >= items[j] && !occupied[i]) {
                j++;
                count++;
            }
            i--;
        }

        return count;
    }
}