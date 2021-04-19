/*
A forest is represented as a square grid consist of 0's an 1's only.
Few people stuck in the forest, where 1's are indicate people, and 0's are indicate as trees. 
A person cannot move from the tree.

You want to save people, a person can be saved, if he/she connected to other person 
who is at the boundary of forest
If 'a' is connected to 'b' and 'b' is connected to 'c',
then you can consider that 'a' is also connected to 'c'. They can connected in 4 directions only. 
(up, right, left and down)

You need to find out the number of persons, who cannot be saved from the given forest grid.


Input Format:
-------------
Line-1 -> An integer N, size of the grid N*N
next N lines -> N space separated integers(0's and 1's)

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
5
0 0 1 1 0
1 0 0 1 0
0 0 1 0 0
0 1 1 0 1
1 0 0 1 0

Sample Output-1:
----------------
3

Explanation:
------------
In the given grid, 1's at (2,2), (3,1), (3,2) positions are not connected to the boundary
So, number of people cannot be saved are 3

Sample Input-2:
---------------
5
0 0 1 1 0
1 0 0 1 0
0 0 1 1 0
0 1 1 0 1
1 0 0 1 0

Sample Output-2:
----------------
0

Explanation:
------------
In the given grid, each 1 is either at the boundary or connceted to 1 at boundary.
So, number of people cannot be saved are '0'


******* Testcases *******
case =1
input =5
0 0 1 1 0
1 0 0 1 0
0 0 1 0 0
0 1 1 0 1
1 0 0 1 0
output =3

case =2
input =5
0 0 1 1 0
1 0 0 1 0
0 0 1 1 0
0 1 1 0 1
1 0 0 1 0
output =0

case =3
input =10
0 1 1 0 0 1 1 0 1 0
0 0 1 1 1 0 0 0 1 0
0 1 1 1 0 1 0 1 1 1
1 1 0 1 0 1 0 1 0 0
0 1 1 0 0 0 0 0 1 1
0 1 0 0 1 0 1 0 1 1
1 1 0 0 1 1 1 0 1 1
0 1 0 0 1 1 1 1 1 1
1 0 1 1 1 0 1 0 1 0
0 1 1 0 1 0 1 0 1 0
output =2

case =4
input =10
0 1 1 0 1 1 1 1 0 0
0 0 1 0 0 0 0 0 1 0
0 1 0 1 1 1 1 1 0 1
1 1 1 0 0 0 1 1 0 0
0 0 0 1 1 0 0 0 1 0
1 0 1 0 0 1 0 0 0 1
0 1 1 1 1 1 0 1 0 1
0 0 1 0 0 1 0 1 1 0
0 0 1 0 0 0 1 1 0 1
1 0 1 1 0 1 0 0 1 1
output =16

case =5
input =15
0 1 1 1 0 1 1 0 1 1 0 1 0 1 0
1 1 0 1 1 1 0 1 0 1 0 1 0 1 1
0 0 0 1 1 1 0 1 1 1 1 1 0 1 1
0 1 1 0 1 1 0 1 0 1 1 1 0 0 1
0 0 1 0 0 1 0 1 0 1 1 0 0 1 1
1 0 1 0 0 0 1 1 0 0 1 0 1 0 1
1 1 1 0 1 1 1 1 1 0 0 0 0 0 0
1 0 1 1 1 0 1 1 1 0 0 0 0 1 1
1 0 1 1 1 0 1 1 0 0 0 0 1 0 1
1 0 0 1 1 0 1 0 1 1 0 1 1 0 1
1 1 0 1 0 1 1 0 1 0 1 1 1 0 1
1 1 1 0 1 1 1 1 1 0 0 0 0 1 1
0 1 1 1 0 1 0 1 0 1 1 0 1 1 0
0 0 1 1 1 1 0 1 1 1 0 1 1 0 1
0 0 0 1 1 0 1 1 0 0 1 0 0 0 0
output =7

case =6
input =15
1 0 0 1 0 1 0 0 1 1 0 0 0 0 0
1 1 0 1 1 1 1 0 1 1 1 1 1 1 0
1 1 1 0 1 1 1 1 0 1 0 1 1 1 1
1 0 1 0 1 0 0 1 1 0 0 0 1 1 1
1 1 1 0 1 1 0 1 1 0 1 0 1 0 1
1 0 1 1 0 0 1 0 0 1 1 1 1 1 1
0 1 0 1 1 0 1 1 0 1 0 0 0 1 1
0 0 1 1 0 1 0 0 1 1 1 0 0 1 0
1 0 1 0 1 0 1 1 0 0 0 0 0 0 0
0 0 1 0 1 0 0 1 1 1 0 1 0 1 0
1 1 1 0 1 1 0 1 1 1 1 0 0 0 0
0 1 1 1 1 0 1 0 0 0 1 0 1 0 1
0 0 0 0 0 1 1 0 0 0 1 0 0 0 0
0 0 0 0 1 0 1 0 1 0 0 1 0 1 0
0 0 0 1 0 0 0 1 0 0 1 1 0 1 1
output =25

case =7
input =20
0 1 0 1 1 1 0 1 0 1 1 0 1 0 0 1 0 1 0 0
1 0 0 1 0 1 0 1 0 1 0 0 1 0 1 1 0 0 0 1
1 1 1 1 0 1 1 1 0 0 1 0 0 1 1 0 0 1 1 0
0 1 1 0 0 1 0 0 0 1 1 0 0 0 0 0 0 0 1 1
0 0 0 0 0 1 1 0 1 1 0 1 0 1 0 1 0 0 0 1
1 0 0 1 1 0 1 0 0 0 1 0 1 0 0 0 1 1 1 1
1 0 1 1 1 0 0 1 0 0 1 0 1 1 0 0 1 0 0 1
0 1 1 1 0 0 0 0 1 0 1 0 1 0 0 0 1 0 1 0
1 0 0 0 1 1 0 1 0 0 0 1 0 1 0 0 0 0 0 1
1 1 1 1 1 1 1 0 0 0 1 0 1 1 0 0 0 1 0 0
0 0 1 0 1 1 1 1 0 1 0 0 1 1 0 1 0 0 0 1
1 0 1 0 1 1 1 1 1 0 1 1 1 0 0 1 1 1 0 1
0 0 0 1 0 1 0 1 1 1 0 1 0 0 0 1 1 1 1 0
0 0 1 0 0 1 1 0 1 0 1 1 1 1 0 1 0 1 1 0
0 1 1 1 1 0 0 1 0 0 1 1 0 1 1 0 0 1 1 0
0 0 0 1 1 0 0 1 0 0 0 1 1 1 1 1 1 0 0 1
0 0 0 1 0 0 1 0 0 0 0 0 1 1 1 1 1 0 1 1
0 1 1 0 0 0 1 1 0 1 0 1 1 0 0 0 1 1 1 1
1 0 1 0 1 0 1 1 0 0 0 1 1 1 0 1 0 0 0 0
0 0 1 0 0 1 1 1 0 0 0 0 1 0 1 0 1 1 0 1
output =58

case =8
input =25
1 0 1 1 0 0 1 1 0 1 1 1 1 0 0 0 1 0 0 0 1 1 0 0 1
1 0 0 1 0 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 1 0 0 1 0
1 0 1 1 1 1 1 1 0 0 1 0 1 0 1 1 1 1 0 0 0 0 1 0 1
1 0 1 0 0 0 0 1 0 1 1 1 1 1 1 0 1 1 1 1 1 0 1 1 1
0 0 0 0 0 1 0 0 1 1 1 0 1 1 0 1 1 0 0 1 1 1 1 0 1
0 1 0 1 0 1 0 0 1 1 0 1 1 0 1 1 0 0 0 1 0 0 0 1 0
1 1 1 0 0 1 1 1 1 1 0 1 1 0 1 0 1 1 0 0 1 0 0 0 1
1 0 1 0 0 0 1 1 0 1 1 0 0 1 0 0 1 1 1 1 1 1 1 0 1
1 0 1 1 0 1 1 0 0 0 0 1 0 0 1 1 1 1 0 1 1 0 0 0 1
0 0 0 1 0 1 1 0 0 1 1 0 1 1 0 1 1 0 0 1 1 1 1 1 0
1 0 1 1 1 1 0 1 1 1 0 0 1 0 1 0 1 1 1 0 1 1 0 0 1
0 1 0 1 1 1 0 1 1 0 1 1 1 0 0 1 1 1 0 0 1 1 0 0 0
1 0 0 1 0 0 1 0 1 0 1 1 0 0 1 0 1 0 1 0 0 0 1 0 0
1 1 0 0 1 0 1 0 1 1 1 0 1 1 1 1 0 1 0 1 1 1 0 1 1
1 1 0 0 0 1 0 1 1 1 1 1 0 1 1 0 0 1 0 1 0 1 1 1 1
0 0 1 1 0 1 0 0 1 0 0 0 1 0 0 1 1 0 1 0 0 1 1 0 0
0 1 0 0 1 0 0 1 0 1 1 1 1 1 1 0 1 0 1 1 0 0 1 0 1
1 0 1 0 1 0 1 0 1 1 1 0 1 0 1 0 1 1 1 1 0 0 0 1 0
1 1 1 0 0 1 1 1 0 0 0 0 0 0 1 0 1 1 1 1 0 0 1 0 0
0 0 1 1 0 0 1 0 1 1 1 1 1 1 0 0 0 1 1 1 0 0 0 1 0
1 1 1 1 0 1 0 0 1 1 1 0 1 0 1 0 0 0 1 1 0 0 0 0 0
0 1 1 0 1 0 1 0 1 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0
0 1 0 0 0 1 0 0 1 1 0 1 0 1 1 1 1 0 1 1 1 1 1 1 1
0 1 0 0 0 1 1 0 0 1 0 0 0 1 0 1 1 1 0 1 1 1 0 0 0
0 1 1 0 0 1 0 1 1 1 0 1 0 0 0 1 0 0 1 0 0 1 1 1 0
output =116

*/

import java.util.*;

class RescuePeople {
    public int rescuePeople(int[][] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1)
                    dfs(A, i, j);
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(A[i][j] == 1)
                    result++;
            }
        }
        
        return result;
    }
    
    public void dfs(int a[][], int i, int j) {
        if(i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
            a[i][j] = 0;
            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);
        }
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[][]=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				arr[i][j]=sc.nextInt();
		System.out.println(new RescuePeople().rescuePeople(arr));
	}
}