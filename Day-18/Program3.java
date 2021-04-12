import java.util.*;

public class Program3 {
    public static void main(String[] args) {

        // Arrays.stream(scn.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int c = scn.nextInt();
        int lock[] = new int[n];

        for (int i = 0; i < lock.length; i++) {
            lock[i] = scn.nextInt();
        }

        System.out.println(test.getOriginalLock(lock, c));

        scn.close();
    }

    static List<Integer> getOriginalLock(int[] lock, int c) {
        if (c == 0) {
            return Arrays.asList(new Integer[lock.length]);
        }

        List<Integer> result = new ArrayList<>();

        int prefixSum[] = new int[lock.length + 1];
        for (int i = 0; i < lock.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + lock[i];
        }

        for (int i = 0; i < lock.length; i++) {
            result.add(getSum(i + 1, i + c, prefixSum));
        }

        return result;
    }

    static int getSum(int i, int j, int[] prefixSum) {
        int max = prefixSum.length - 1;
        if (i < 0) {
            return 0;
        } else if (j >= max) {
            i = i % max;
            int sum = prefixSum[max] - prefixSum[i];
            j -= max - i;
            sum += (prefixSum[max]) * (j / max);
            sum += prefixSum[j % max] - prefixSum[0];
            return sum;
        } else {
            return prefixSum[j + 1] - prefixSum[i];
        }
    }
}

class test {
    static List<Integer> getOriginalLock(int[] lock, int c) {
        if (c == 0) {
            return Arrays.asList(new Integer[lock.length]);
        }

        boolean forwd = c > 0;
        c = Math.abs(c);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < lock.length; i++) {
            int sum = 0;
            int j = i;
            for (int k = 1; k <= c; k++) {
                if (forwd) {
                    j++;
                    j = j == lock.length ? 0 : j;
                    sum += lock[j];
                } else {
                    j--;
                    j = j < 0 ? lock.length - 1 : j;
                    sum += lock[j];
                }
            }
            result.add(sum);
        }

        return result;
    }
}