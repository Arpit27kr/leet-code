//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        // Complete the function
        if(n==3){
            return arr[0]*arr[1]*arr[2];
        }
        int y=Integer.MIN_VALUE;
        int x=Integer.MAX_VALUE;
        Arrays.sort(arr);
        long a=y,b=y,c=y,p=x,q=x,s=x;
        for(int i=0;i<n;i++){
            if(p>=arr[n-i-1] && arr[n-i-1]!=0){
                q=p;
                p=arr[n-i-1];
            }
            if(a<=arr[i]){
                c=b;
                b=a;
                a=arr[i];
            }
            // System.out.println(i+" "+a+" "+b+" "+c+" "+p+" "+q);
        }
        long ans=Math.max(p*q*a,a*b*c);
        // System.out.println(a+" "+b+" "+c+" "+p+" "+q);
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        return ans;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends