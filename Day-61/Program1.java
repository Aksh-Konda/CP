import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coups = new int[n];
        int[] xpD = new int[n];

        for (int i = 0; i < n; i++) {
            coups[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            xpD[i] = scn.nextInt();
        }

        System.out.println(getCouponsUsed(coups, xpD));

        scn.close();
    }

    static int getCouponsUsed(int coups[], int xpD[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.exp - o2.exp;
            }
        });

        int used = 0;

        int i;
        for (i = 0; i < coups.length; i++) {
            while (!pq.isEmpty() && pq.peek().exp < i + 1) {
                pq.poll();
            }

            if (coups[i] > 0) {
                pq.offer(new Pair(coups[i], i + xpD[i]));
            }

            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                p.c -= 1;
                used++;
                if (p.c > 0) {
                    pq.offer(p);
                }
            }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.exp > i) {
                p.c -= 1;
                used++;
                if (p.c > 0) {
                    pq.offer(p);
                }
                i++;
            }
        }

        return used;
    }
}

class Pair {
    int c;
    int exp;

    Pair(int c, int exp) {
        this.c = c;
        this.exp = exp;
    }
}