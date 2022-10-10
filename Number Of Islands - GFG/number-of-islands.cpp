//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {

  public:

  vector<int>row={-1,0,1,0};

        vector<int> col={0,1,0,-1};

        void dfs(int i,int j,int m,int n,vector<vector<int>>&grid)

        {

            grid[i][j]=2;

            for(int k=0;k<4;k++){

                int newrow= i+row[k];

                int newcol= j+col[k];

                if(newrow>=0 && newcol>=0 && newrow <m && newcol<n)

                {

                    if(grid[newrow][newcol]==1)

                    {

                        dfs(newrow,newcol,m,n,grid);

                    }

                }

            }

        }

        int f(int m, int n, vector<vector<int>>grid)

        {

            int nislands=0;

            for(int i=0;i<m;i++)

            {

                for(int j=0;j<n;j++)

                {

                    if(grid[i][j]==1)

                    {

                        nislands++;

                        dfs(i,j,m,n,grid);

                    }

                }

            }

            return nislands;

        }

    vector<int> numOfIslands(int n, int m, vector<vector<int>> &operators) {

        // code here

        vector<vector<int>>arr(n,vector<int>(m,0));

        

        vector<int>ans;

        for(int i=0;i<operators.size();i++)

        {

            int a=operators[i][0];

            int b=operators[i][1];

            

            arr[a][b]=1;

            int k=f(n,m,arr);

            ans.push_back(k);

        }

        return ans;

    }

};






//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,m,k; cin>>n>>m>>k;
        vector<vector<int>> a;
        
        for(int i=0; i<k; i++){
            vector<int> temp;
            for(int j=0; j<2; j++){
                int x; cin>>x;
                temp.push_back(x);
            }
            a.push_back(temp);
        }
    
        Solution obj;
        vector<int> res = obj.numOfIslands(n,m,a);
        
        for(auto x : res)cout<<x<<" ";
        cout<<"\n";
    }
}

// } Driver Code Ends