import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int p = getMax(n);
        int q = getMin(n);

        System.out.println(p - q);

        scn.close();
    }

    static int getMax(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 10);
            n /= 10;
        }

        int result = 0;
        int d = -1;
        while (!stack.isEmpty()) {
            int dd = stack.pop();
            if (d != -1) {
                result = result * 10 + (d == dd ? 9 : dd);
                continue;
            } else if (dd != 9) {
                d = dd;
            }
            result = result * 10 + 9;
        }

        return result;
    }

    static int getMin(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 10);
            n /= 10;
        }

        int result = 0;
        int d = -1;
        int temp = stack.pop(), rep = 0;
        if (temp != 1) {
            d = temp;
            rep = 1;
            result = result * 10 + 1;
        } else {
            result = result * 10 + temp;
        }
        while (!stack.isEmpty()) {
            int dd = stack.pop();
            if (d != -1) {
                result = result * 10 + (d == dd ? rep : dd);
                continue;
            } else if (dd > 1) {
                d = dd;
                dd = 0;
            }
            result = result * 10 + dd;
        }

        return result;
    }
}