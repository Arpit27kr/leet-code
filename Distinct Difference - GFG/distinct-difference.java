//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends





class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        Set<Integer> prev=new HashSet<>();
        Set<Integer> next=new HashSet<>();
        Map<Integer,Integer> m=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:A){
            
                next.add(i);
            
            m.put(i,m.getOrDefault(i,0)+1);
        }
        
        for(int i:A){
           if(next.contains(i) && m.get(i)==1) next.remove(i);
           int nextDis=next.size();
           if(m.get(i)==1) m.remove(i);
           else if(m.get(i)>1){
               m.put(i,m.get(i)-1);
            //   nextDis++;
           }
           int prevDis=prev.size();
           prev.add(i);
           arr.add(prevDis-nextDis);
        }
        return arr;
    }
}
        