class Solution {
    char[] arr;
    int length;
    int[] dp;
    int MOD = 1000000007;
    public int numDecodings(String message) {
        arr = message.toCharArray();
        length = message.length();
        dp = new int[length + 1];
        
        for(int j = 0; j <= length; j++){
            dp[j] = -1;
        }
        return noOfWays(0);
    }
    public int noOfWays(int index){
        if(index >= length){
            return 1;
        }
        if(arr[index]=='0'){
            return 0;
        }        
        if(dp[index] != -1){
            return dp[index];
        }
        int opt = 0;
        if(arr[index]=='*'){
            for(int i = 1; i < 10; i++){
                opt = (opt%MOD + noOfWays(index +  1)%MOD)%MOD;
            }
        }
        else{
            opt = (opt%MOD +  noOfWays(index +  1)%MOD)%MOD;
        }
        
        if(index + 1 < length){
            if(arr[index]=='*' && arr[index+1]=='*'){
                for(int i = 11; i <= 25; i++){
                    opt = (opt%MOD + noOfWays(index + 2)%MOD)%MOD;
                }
            }
            else if(arr[index]=='*'){
                for(int i = 1; i < 10; i++){
                    if(i*10 + arr[index + 1]-'0' <= 26){
                        opt = (opt%MOD + noOfWays(index + 2)%MOD)%MOD;
                    }
                    else{
                        break;
                    }
                }
            }
            else if(arr[index + 1] == '*'){
                for(int i = 1; i < 10; i++){
                    if((arr[index]-'0') * 10 + i <= 26){
                        opt = (opt%MOD + noOfWays(index + 2)%MOD)%MOD;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                if(Integer.parseInt(arr[index]+""+arr[index + 1]) <= 26){
                    opt = (opt%MOD + noOfWays(index +  2)%MOD)%MOD;
                }
            }
        }
        return dp[index] = opt%MOD;
    }
}
