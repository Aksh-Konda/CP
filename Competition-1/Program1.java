import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> up = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            up.add(scn.nextInt());
        }
        List<Integer> down = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            down.add(scn.nextInt());
        }

        Set<Integer> downSet = new HashSet<>(down);
        int found = Integer.MAX_VALUE;
        for (int i = 0; i < args.length; i++) {
            if (up.get(i) != down.get(i)) {
                int temp = up.get(i);
                up.set(i, down.get(i));
                down.set(i, temp);

                if (!up.contains(down.get(i)) && !downSet.contains(down.get(i))) {
                    found = Math.min(found, down.get(i));
                }
            }
        }

        System.out.println(found == Integer.MAX_VALUE ? 0 : found);
        scn.close();
    }
}
