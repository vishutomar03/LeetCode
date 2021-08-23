class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, result = 0, M = (int)1e9 + 7;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[n];
        dp[0] = arr[0];
        stack.push(0);
        result+=dp[0];
        
        for (int i = 1; i < n; i++) {
            while (stack.size() != 0 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.size()==0){
                dp[i] = ((i+1)*arr[i])%M;
            }
            else{
                dp[i] = (dp[stack.peek()] + (i - stack.peek()) * arr[i]) % M;
            }
            stack.push(i);
            result += dp[i];
            result %= M;
        }
        return result;
    }
}