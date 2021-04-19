import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String raw[] = scn.nextLine().split(" ");
        int nums[] = new int[raw.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(raw[i]);
        }

        System.out.println(getMaxLenPositiveProduct(nums));

        scn.close();
    }

    static int getMaxLenPositiveProduct(int nums[]) {
        int pos = 0, neg = 0, res = 0;

        for (int num : nums) {
            if (num == 0) {
                pos = neg = 0;
            } else if (num > 0) {
                pos++;
                if (neg > 0) {
                    neg++;
                }

                res = pos > res ? pos : res;
            } else {
                int temp = pos;
                pos = neg;
                neg = temp;

                neg++;

                if (pos > 0) {
                    pos++;
                }

                res = pos > res ? pos : res;
            }
        }

        return res;
    }
}
