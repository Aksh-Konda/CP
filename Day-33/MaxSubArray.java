/*
Ashok is given an array of integers nums.
His task is to find the longest contiguous subsequence S, 
the product of all the numbers in the subsequence should be positive.

Return the length of longest contiguous subarray.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous subsequence


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MaxSubArray {
    public int getMaxLen(int[] nums) {
        // sum is used to count the number of negative numbers from zeroPosition to current index
        int firstNegative = -1, zeroPosition = -1, sum = 0, max = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] < 0){
                sum++;
				// we only need to know index of first negative number
                if(firstNegative == -1) firstNegative = i;
            }
			// if current number is 0, we can't use any element from index 0 to i anymore, so update zeroPosition, and reset sum and firstNegative. If it is a game, we should refresh the game when we meet 0. 
            if(nums[i] == 0){
                sum = 0;
                firstNegative = -1;
                zeroPosition = i;
            }
            else{
			    // consider index of zero
                if(sum%2 == 0) max = Math.max(i - zeroPosition, max);
				// consider index of first negative number
                else max = Math.max(i - firstNegative, max);   
            }
        }
        return max;
    }
	
	public static void main(String args[] ) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] sarr = str.split(" ");
		int[] nums = Arrays.asList(sarr).stream().mapToInt(Integer::parseInt).toArray();
		System.out.println(new MaxSubArray().getMaxLen(nums));
	}
}