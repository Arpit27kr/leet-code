//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution
{
  public:
    //Function to find maximum of each subarray of size k.
    vector <int> max_of_subarrays(int *arr, int n, int k)
    {
        //sliding window
        // vector<int> ans;
        // for(int i=0;i<=n-k;i++)
        // {
        //     int maxi=0;
        //     for(int j=0;j<k;j++)
        //     {
        //         maxi=max(maxi,arr[j+i]);
        //     }
        //     ans.push_back(maxi);
        // }
        // return ans;

        vector<int> ans;
        deque<int> q;
        int low=0,high=0;
        while(high<n)
        {
            while(!q.empty() && q.back()<arr[high]) q.pop_back();
            q.push_back(arr[high]);
            if(high-low+1<k) high++; // to get length of window size k
            else if(high-low+1==k)
            {
                ans.push_back(q.front());
                //now shifting
                if(q.front()==arr[low]) q.pop_front(); //front is max
                low++;
                high++;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
	
	int t;
	cin >> t;
	
	while(t--){
	    
	    int n, k;
	    cin >> n >> k;
	    
	    int arr[n];
	    for(int i = 0;i<n;i++) 
	        cin >> arr[i];
	    Solution ob;
	    vector <int> res = ob.max_of_subarrays(arr, n, k);
	    for (int i = 0; i < res.size (); i++) 
	        cout << res[i] << " ";
	    cout << endl;
	    
	}
	
	return 0;
}
// } Driver Code Ends