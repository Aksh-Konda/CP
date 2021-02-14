import java.util.Arrays;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Brick bricks[] = new Brick[n];

        for (int i = 0; i < n; i++) {
            bricks[i] = new Brick(scn.nextInt(), scn.nextInt(), scn.nextInt());
        }

        System.out.println(maxStackHeight(bricks, n));

        scn.close();
    }

    static int maxStackHeight(Brick bricks[], int n) {

        int count = 3 * n;
        Brick[] rot = new Brick[count];

        for (int i = 0; i < n; i++) {
            Brick brick = bricks[i];
            rot[3 * i] = new Brick(brick.h, Math.max(brick.w, brick.d), Math.min(brick.w, brick.d));
            rot[3 * i + 1] = new Brick(brick.w, Math.max(brick.h, brick.d), Math.min(brick.h, brick.d));
            rot[3 * i + 2] = new Brick(brick.d, Math.max(brick.w, brick.h), Math.min(brick.w, brick.h));
        }

        Arrays.sort(rot);

        int[] msh = new int[count];
        for (int i = 0; i < count; i++) {
            Brick brick = rot[i];
            int val = 0;

            for (int j = 0; j < i; j++) {
                Brick prevBrick = rot[j];
                if (brick.w < prevBrick.w && brick.d < prevBrick.d) {
                    val = Math.max(val, msh[j]);
                }
            }
            msh[i] = val + brick.h;
        }

        int max = -1;

        for (int i = 0; i < count; i++) {
            max = Math.max(max, msh[i]);
        }

        return max;
    }
}

class Brick implements Comparable<Brick> {

    int h, w, d, area;

    public Brick(int h, int w, int d) {
        this.h = h;
        this.w = w;
        this.d = d;
        this.area = this.d * this.w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.area - this.area;
    }

}
