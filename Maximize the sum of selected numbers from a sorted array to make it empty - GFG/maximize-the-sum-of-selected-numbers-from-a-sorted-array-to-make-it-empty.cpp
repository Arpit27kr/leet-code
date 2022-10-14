//{ Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 
  

// } Driver Code Ends
class Solution{
    public:
int maximizeSum(int a[], int n) 

    {

        // Complete the function

        map<int,int> store;

        for(int i=0;i<n;i++){

            store[a[i]]++;

        }

        sort(a,a+n);

        int sum=0;

        for(int i=n-1;i>=0;i--){

            int x = a[i];

            int y=a[i]-1;

            if(store[x]>=1){

                sum+=x;

                store[x]--;

                if(store[y]>=1){

                    store[y]--;

                }

            }

            

        }

        return sum;

        

    }
};


//{ Driver Code Starts.



int main()
{
    
    int t;cin>> t;
    while(t--)
    {
        int n;
        cin >> n;
        int arr[n];
        
        for(int i=0;i<n;i++)
            cin>>arr[i];
        sort(arr, arr+n);
        Solution ob;
        
        cout << ob.maximizeSum(arr, n) << endl;
        
        
    }

}


// } Driver Code Ends