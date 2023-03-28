//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        

        while(t-->0){
            Shop shop = new Shop();

            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            long k = Long.parseLong(s[1]);

            s = br.readLine().trim().split(" ");

            for(String x: s){
                shop.addChocolate(Integer.parseInt(x));
            }
            
            ot.println(new Solution(shop).find(n, k));
        }
        ot.close();
    }
    
    
}
class Shop{
    private static List<Integer> chocoloates;
    private static int countOfCalls;
    Shop(){
        chocoloates = new ArrayList<>();
        countOfCalls = 0;
    }
    public static void addChocolate(int price){
        chocoloates.add(price);
    }

    public static int get(int i){
        countOfCalls++;
        if(countOfCalls > 50 || i >= chocoloates.size() || i < 0)
            return -1;
        return chocoloates.get(i);
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    public static long[] binarySearch (int n,long k,long arr[]){
        // System.out.println("k is"+k);
        long a[]=new long[2];
        a=arr;
    int low=0,high=n-1;
        int mid=0;
        int cost = -1; 
         while(low <= high){
                mid = (low+high)/2;
                int curCost = shop.get(mid);
                // System.out.println("mid value: "+curCost);
                if(curCost > cost && curCost <= k){ // desired chocolate found
                    cost = curCost; 
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
            a[0]=cost;
            a[1]=mid;
         return a;
    }
    static long find(int n, long k){
        // int arr[]=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=shop.get(i);
        // }
        long count=0;
        long optimumChocolateValue = shop.get(n-1);
        long arr[]=new long[2];
        for(int i=n-1;i>=0;i--){
            
            if(k/optimumChocolateValue>=0)
            {
                // System.out.println("values are: "+shop.get(i)+" "+k);
                count= count +k/optimumChocolateValue;
                k= k - (k/optimumChocolateValue)*optimumChocolateValue;
            }
            binarySearch(n,k,arr);
            
            optimumChocolateValue=arr[0];
            n=(int)arr[1];
        }
        // System.out.println("ans is: "+count);
        return count;
    }

}