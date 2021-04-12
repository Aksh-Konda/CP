import java.util.*;

public class Program2 {
    static {
        System.out.println(1);
    }

    public Program2() {
        super();
        System.out.println("danf");
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int items[] = new int[n];
        int rooms[] = new int[k];

        for (int i = 0; i < items.length; i++) {
            items[i] = scn.nextInt();
        }
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = scn.nextInt();
        }

        System.out.println(getMaxDelivered(items, rooms));

        scn.close();
    }

    static int getMaxDelivered(int items[], int rooms[]) {
        Arrays.sort(items);

        int count = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = Math.min(min, rooms[i]);
            min = rooms[i];
        }

        boolean[] occupied = new boolean[rooms.length];
        int j = rooms.length - 1;

        for (int i = 0; i < items.length; i++) {
            while (j >= 0) {
                if (rooms[j] >= items[i] && !occupied[j]) {
                    occupied[j--] = true;
                    count++;
                    break;
                }
                j--;
            }
        }

        return count;
    }

    {
        System.out.println(2);
    }
}

class sub extends Program2 {
    protected final int size;

    sub() {
        this.size = 5;
    }
}