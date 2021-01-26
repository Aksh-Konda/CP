import java.util.*;

public class One {
    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            System.out.println(i + " : " + Integer.lowestOneBit(i));
            while()
        }
    }

    static void printBits(int i) {
        for (; i < 8; i = i + Integer.lowestOneBit(i)) {
            System.out.println(i + ": " + Integer.toBinaryString(i));
        }
    }

    // static int getCountIsoTriangles(int [][]points) {
    // int count = 0;

    // HashMap<Double, Integer> map = new HashMap<>();

    // for(int i=0; i<points.length; i++) {
    // for(int j=0; j<points.length; j++) {
    // if(i != j) {
    // double dist = getDistance(points, i, j);
    // map.put(dist, map.getOrDefault(dist, 0)+1);
    // }
    // }
    // for(Double key: map.keySet()) {
    // int n = map.get(key);
    // if(n >= 2) {
    // count += map
    // }
    // }
    // }

    // return count;
    // }

    static double getDistance(int[][] points, int i, int j) {
        int x = points[i][0] - points[j][0];
        int y = points[i][1] - points[j][1];
        return Math.sqrt(x * x + y * y);
    }
}