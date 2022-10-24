//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++


struct alphanumeric {
    string name;
    int count;
};
class Solution {
  public:
    vector<alphanumeric> sortedStrings(int N, vector<string> A) 

    {

        struct alphanumeric obj[N];

        vector<alphanumeric> ans;

        map<string,int> hash;

        int j=0;

        for(int i=0;i<N;i++)

        {

            hash[A[i]]++;

        }

        for(auto x:hash)

        {

            obj[j].name=x.first;

            obj[j].count=x.second;

            ans.push_back(obj[j]);

            j++;

        }

        return ans;

        // code here

    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        cin.ignore();
        vector<string> v;
        for (int i = 0; i < N; i++) {
            string s;
            getline(cin, s);
            v.push_back(s);
        }
        Solution ob;
        vector<alphanumeric> ans = ob.sortedStrings(N, v);
        for (auto u : ans) cout << u.name << " " << u.count << "\n";
    }
}
// } Driver Code Ends