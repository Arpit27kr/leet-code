//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

class Solution
{
	public static String removeBrackets(String Exp){
	    char[] expChars = Exp.toCharArray();
        int n = expChars.length;

        int[] ans = new int[n + 1];
        Arrays.fill(ans, 1);
        int[] lastOperator = new int[n + 1];
        int[] nextOperator = new int[n + 1];

        int l = -1;
        for (int i = 0; i < n; i++) {
            lastOperator[i] = l; // initialize lastOperator with the last operator
            if (expChars[i] == '*' || expChars[i] == '+' || expChars[i] == '-' || expChars[i] == '/')
                l = expChars[i]; // update lastOperator if an operator is found
        }
        l = -1;
        for (int i = n - 1; i >= 0; i--) {
            nextOperator[i] = l; // initialize nextOperator with the next operator
            if (expChars[i] == '*' || expChars[i] == '+' || expChars[i] == '-' || expChars[i] == '/')
                l = expChars[i]; // update nextOperator if an operator is found
        }

        Stack<Integer> st = new Stack<>(); // create a stack to store the index of opening brackets
        int[] operatorSign = new int[256]; // create an array to store the index of each operator
        int[] operatorMap = new int[256]; // create an array to store whether an operator is present or not
        Arrays.fill(operatorSign, -1); // initialize operatorSign with -1
        char[] operators = {'*', '+', '-', '/'};

        for (int p = 0; p < n; p++) {
            for (char x : operators) {
                operatorMap[x] = 0; // initialize operatorMap with 0
                if (x == expChars[p])
                    operatorSign[x] = p; // update operatorSign with the index of the operator
            }
            if (expChars[p] == '(')
                st.push(p); // push the index of the opening bracket to the stack
            else if (expChars[p] == ')') {
                int i = st.pop(); // get the index of the opening bracket
                int j = p; // get the index of the closing bracket

                int next = nextOperator[j]; // get the next operator after the closing bracket
                int last = lastOperator[i]; // get the last operator before the opening bracket

                for (char x : operators)
                    if (operatorSign[x] >= i)
                        operatorMap[x] = 1; // update operatorMap with 1 if the operator is found between the brackets

                // check if the bracket is redundant or not
                // This code defines a boolean variable isValid, which is initially set to false.
                boolean isValid = false;

                // This condition checks if the current sub-expression is surrounded by parentheses.
                // If so, it sets isValid to true.
                if (i > 0 && j + 1 < n && expChars[i - 1] == '(' && expChars[j + 1] == ')')
                    isValid = true;

                // This condition checks if there are no operators in the expression.
                // If so, it sets isValid to true.
                if (operatorMap['+'] == 0 && operatorMap['*'] == 0 && operatorMap['-'] == 0 && operatorMap['/'] == 0)
                    isValid = true;

                // This condition checks if the current sub-expression is the entire expression.
                // If so, it sets isValid to true.
                if (last == -1 && next == -1)
                    isValid = true;

                // These conditions check if the last and next characters around the sub-expression
                // allow it to be removed. If so, they set isValid to true.
                if (last == '/') {}
                else if (last == '-' && (operatorMap['+'] == 1 || operatorMap['-'] == 1)) {}
                else if (operatorMap['-'] == 0 && operatorMap['+'] == 0)
                        isValid = true;
                else if ((last == -1 || last == '+' || last == '-') && (next == -1 || next == '+' || next == '-'))
                    isValid = true;

            // If the sub-expression is valid, it marks its characters for removal.
                if (isValid) {
                    ans[i] = 0;
                    ans[j] = 0;
                }
            }
        }
        // This section builds the resulting expression string from the characters that were not marked for removal.
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (ans[i] > 0)
                res.append(expChars[i]);
        return res.toString();
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String Exp = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.removeBrackets(Exp));
        }
        
    }
}
// } Driver Code Ends