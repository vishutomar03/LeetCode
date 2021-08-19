class Solution {
    char[] arr;
    int length;
    int[] dp;
    public int numDecodings(String message) {
        arr = message.toCharArray();
        length = message.length();
        dp = new int[length + 1];
        
        
        for(int j = 0; j  <= length; j++){
            dp[j] = -1;
        }
        return noOfWays(0);
    }
    public int noOfWays(int index){
        if(index>=length){
            return 1;
        }
        if(arr[index]=='0'){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int opt;
        opt = noOfWays(index +  1);
        if(index + 1 < length && Integer.parseInt(arr[index]+""+arr[index + 1]) <= 26){
            opt += noOfWays(index +  2);
        }
        return dp[index] = opt;
        
    }
}