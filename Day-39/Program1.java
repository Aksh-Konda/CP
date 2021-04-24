import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        Position tPos = new Position(scn.nextInt(), scn.nextInt());
        Position sPos = new Position(scn.nextInt(), scn.nextInt());

        int w = scn.nextInt();

        Position[] wPos = new Position[w];

        for (int i = 0; i < w; i++) {
            wPos[i] = new Position(scn.nextInt(), scn.nextInt());
        }

        System.out.println(minTotalDistance(tPos, sPos, w, wPos));

        scn.close();
    }

    static int minTotalDistance(Position tPos, Position currPos, int w, Position[] wPos) {
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < w; i++) {
            minDist = Math.min(minDist, getTotalDist(currPos, tPos, wPos, i));
        }

        return minDist;
    }

    static int getTotalDist(Position curr, Position tPos, Position[] wPos, int i) {
        int dist = getDistance(curr, wPos[i]) + getDistance(tPos, wPos[i]);

        for (int j = 0; j < wPos.length; j++) {
            if (i != j) {
                dist += 2 * getDistance(tPos, wPos[j]);
            }
        }

        return dist;
    }

    static int getDistance(Position tPos, Position wPos) {
        int totDist = Math.abs(tPos.x - wPos.x) + Math.abs(tPos.y - wPos.y);
        return totDist;
    }
}

class Position {
    int x;
    int y;

    Position(int a, int b) {
        x = a;
        y = b;
    }
}

/**
 * 5 7 2 2 4 4 2 3 0 2 5 5 1 4 2 6 3 0 2 5 4 5
 */