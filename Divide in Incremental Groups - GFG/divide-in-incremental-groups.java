//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    
    public int solve(int n , int k , int i,int count ,int left,int[][][] dp){
        
     
        // left-j >= 0 ;
        // left >= k-count 
        
        if(count == k){
            if(left == 0){
                return 1 ;
            }
            else{
                return 0;
            }
        }
        if(dp[i][count][left] != -1){
            return dp[i][count][left] ;
        }
        int ans =0 ; 
        for(int j = i ; j<=n;j++){
            
            if(left-j>=0){
                ans += solve(n,k,j,count+1 , left-j,dp) ; 
            }
            else{
                break;
            }
            
        }
        dp[i][count][left] = ans;
        return ans;
        
        
        
        
    }
       
        
       
       
    
    public int countWaystoDivide(int N, int K) {
        int[][][] dp = new int[N+1][K][N+1] ;
        
         for(int i =0 ; i<dp.length;i++){
            for(int  j = 0 ; j< dp[0].length ; j++){
                for(int k= 0 ;k<dp[0][0].length ; k++){
                    dp[i][j][k] = -1 ;
                }
            }
        }
        return solve(N,K,1,0,N,dp);
        // Code here
    }
}