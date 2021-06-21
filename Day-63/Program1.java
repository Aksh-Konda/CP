
import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int start = scn.nextInt();
        int end = scn.nextInt();

        System.out.println(getAndOfRange(start, end));

        scn.close();
    }

    static int getAndOfRange(int start, int end) {
        int count = 0;

        while (start != end) {
            start = start >> 1;
            end = end >> 1;
            count++;
        }

        return start << count;
    }
}