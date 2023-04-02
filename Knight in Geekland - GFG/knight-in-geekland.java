//{ Driver Code Starts
//Initial Template for Java

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
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution{
    int[] moves_x = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] moves_y = {-1, 1, -2, 2, 2, -2, 1, -1};
    
    public boolean isValid(int i,int j,int[][] arr,boolean[][] visited)
    {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || visited[i][j]==true) return false;
        
            return true;
    }
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        
        int n=arr.length,m=arr[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start_x,start_y});
        
        boolean[][] visited=new boolean[n][m];
        visited[start_x][start_y]=true;
        ArrayList<Integer> points=new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int size=q.size();
            
            int sum=0;
            for(int i=0;i<size;i++)
            {
                int[] coor=q.poll();
                
                int curX=coor[0];
                int curY=coor[1];
                
                sum+=arr[curX][curY];
                
                for(int index=0;index<8;index++)
                {
                    int xIndex=moves_x[index]+curX;
                    int yIndex=moves_y[index]+curY;
                    
                    if(isValid(xIndex,yIndex,arr,visited))
                    {
                        visited[xIndex][yIndex]=true;
                        q.add(new int[]{xIndex,yIndex});
                    }
                }
            }
            
            points.add(sum);
        }
        
        int[] pointsArr=new int[points.size()];
        
        for(int i=0;i<points.size();i++) pointsArr[i]=points.get(i);
        
        
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=points.size()-1;i>=0;i--)
        {
            if(pointsArr[i]+i<points.size())
            {
                pointsArr[i]+=pointsArr[pointsArr[i]+i];
            }
            
            if(pointsArr[i]>=max)
            {
                max=pointsArr[i];
                ans=i;
            }
        }
        
        return ans;
    }
}