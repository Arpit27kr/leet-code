//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	public:
	vector<int> downwardDigonal(int N, vector<vector<int>> A)
	{
		// Your code goes here
		vector<int> ans;

    for(int i=0;i<N;i++)
    {
        int j=i+1;
        int start=0;
        int end=i;
          while(start<j)
          {
              ans.push_back(A[start][end]);
              start++;
              end--;
          }
      }
      for(int k=1;k<N;k++)
      {
          int start=k;
          int end=N-1;
          while(start<N)
          {
              ans.push_back(A[start][end]);
              start++;
              end--;
          }
      }
      return ans;
	}

};

//{ Driver Code Starts.



int main()
{

    
    int t;
    cin >> t;
    while(t--) 
    {
        int n;
        cin >> n;

        vector<vector<int>> A(n, vector<int>(n));

        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		cin >> A[i][j];

        Solution obj;
        vector<int> ans = obj.downwardDigonal(n, A);

        for(auto i:ans)
        	cout << i << " ";

	    cout << "\n";
    }

    return 0;
}

// } Driver Code Ends