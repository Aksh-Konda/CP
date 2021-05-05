import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int s = scn.nextInt();

        // System.out.println(findLeftOut(n, s));

        scn.close();
    }

    // static int findLeftOut(int n, int s) {
    // for (int i = 1; i <= n; i++) {
    // CircularLL.addNew(i);
    // }

    // CircularLL curr = CircularLL.root;

    // while (n > 1) {
    // for (int i = 2; i < s; i++) {
    // curr = curr.next;
    // }

    // // CircularLL.removeNext(curr);
    // }
    // }

}

class CircularLL {
    int num;
    CircularLL next;

    static CircularLL last;
    static CircularLL root;

    CircularLL(int n) {
        this.num = n;
    }

    static void addNew(int n) {
        CircularLL temp = new CircularLL(n);
        if (root == null) {
            root = temp;
            last = root;
        } else {
            temp.next = root;
            last.next = temp;
            last = temp;
        }
    }

    // static void removeNext(CircularLL curr) {
    // if(curr != null)
    // }
}