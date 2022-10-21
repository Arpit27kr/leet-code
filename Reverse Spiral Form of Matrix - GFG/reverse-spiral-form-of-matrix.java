//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a) {
        int m = R, n = C;
        int[] ans = new int[R * C];
        int k = 0;
        
        int rowS = 0, rowE = R-1, colS = 0, colE = C-1;
        while (rowS <= rowE && colS <= colE) {
            for (int j=colS; j <= colE; j++) {
                ans[k++] = a[rowS][j]; 
            }
            rowS++;
            
            for (int i=rowS; i <= rowE; i++) {
                ans[k++] = a[i][colE]; 
            }
            colE--;
            
            if (rowS <= rowE) {
                for (int j=colE; j >= colS; j--) {
                    ans[k++] = a[rowE][j]; 
                }
                rowE--;
            }
            
            
            if (colS <= colE) {
                for (int i=rowE; i >= rowS; i--) {
                    ans[k++] = a[i][colS];
                }
                colS++;
            }
        }
        
        int left = 0, right = (R * C) - 1;
        while (left < right) {
            int temp = ans[left];
            ans[left] = ans[right];
            ans[right] = temp;
            left++; right--;
        }
        
        return ans;
    }
}