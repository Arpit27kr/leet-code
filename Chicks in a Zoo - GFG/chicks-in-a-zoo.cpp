//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
	long long int NoOfChicks(int n){
	    // Code here
	    long dp[n];
        memset(dp, 0, sizeof dp);
        dp[0] = 1;
        for (int i = 1; i < n; i++){for (int j = 1; j <= 5; j++){if (i - j >= 0){dp[i] += dp[i - j] * 2;}}}
        long res = 0;
        for (int i = max(0, n - 6); i < n; i++){res += dp[i];}
        return res;
	}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution obj;
		long long int ans = obj.NoOfChicks(N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends