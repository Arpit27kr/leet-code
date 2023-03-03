//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long B = Long.parseLong(input_line[1]);

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<Long>();
            ans = ob.minimumSquares(L, B);
            System.out.print(ans.get(0)+" ");
            System.out.println(ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution{

    static List<Long> minimumSquares(long L, long B)

    {

        // code here

        List<Long> ans = new ArrayList<>();

 

 

long min = Math.min(L, B);

long k1 = 1, res  =  1,  L1 = L, B1 =  B;

while(k1<=min)

{

    if(L1%k1==0 && B1%k1==0)

    {

        res*=k1;

        L1=  L1/k1;

        B1 = B1/k1;

        k1 = 1;

        min = Math.min(L1, B1);

    }

 

        k1++;

 

}

 

long areaRectangle = L*B;

long areaSquare = res *  res;

 

long number = (long)areaRectangle /areaSquare ;

 

ans.add(number);

ans.add(res);

return ans;

    }

}