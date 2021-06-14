import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = scn.nextInt();
        }

        int[] ordered = getOrdered(tokens);

        for (int num : ordered) {
            System.out.print(num + " ");
        }

        System.out.println();

        scn.close();
    }

    static int[] getOrdered(int[] tokens) {
        int n = tokens.length;
        Arrays.sort(tokens);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(q);
            result[q.poll()] = tokens[i];   
            q.add(q.poll());
        }

        return result;
    }

    static int[] getOrdered(int[] tokens, int k) {
        int n = tokens.length - k;
        int[] result = new int[n];
        if (n == 1) {
            result[0] = tokens[k];
        }
        int j = k;
        for (int i = 0; i < n; i += 2, j++) {
            result[i] = tokens[j];
        }

        if (n - j >= 1) {
            int[] temp = getOrdered(tokens, j);
            j = temp.length - 1;
            for (int i = 3; i < n; i += 2, j--) {
                result[i] = temp[j];
            }
            result[1] = temp[j];
        }

        return result;
    }

}