import java.util.*;

public class Program2 {
    static void swap(int ar[], int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void findNextLargestNum(int arr[], int n) {
        int i;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            Arrays.sort(arr);
        } else {
            int x = arr[i - 1], min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > x && arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i - 1, min);
            Arrays.sort(arr, i, n);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String raw[] = scn.nextLine().split(" ");
        int digits[] = new int[raw.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(raw[i]);
        }

        findNextLargestNum(digits, digits.length);

        System.out.println(Arrays.toString(digits));

        scn.close();
    }
}