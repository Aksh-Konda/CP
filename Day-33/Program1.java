import java.util.*;

public class Program1 {
    static HashSet<String> memo = new HashSet<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x1 = scn.nextInt(), y1 = scn.nextInt(), x2 = scn.nextInt(), y2 = scn.nextInt();

        System.out.println(canTranformTo(x1, y1, x2, y2));

        scn.close();
    }

    static boolean canTranformTo(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2)
            return true;
        if (x1 > x2 || y1 > y2)
            return false;

        String key = x1 + ", " + y2;
        if (memo.contains(key))
            return false;

        memo.add(key);

        return canTranformTo(x1 + y1, y1, x2, y2) || canTranformTo(x1, x1 + y1, x2, y2);
    }
}