class Solution {
    char[] arr;
    int[][][] dp = new int[105][105][105];
    int n;
    public boolean checkValidString(String s) {
        arr = s.toCharArray();
        n = arr.length;
       
        for(int i = 0; i < 105; i++){
            for(int j = 0; j < 105; j++){
                for(int k = 0; k < 105; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return ans(0,0,0)==1? true: false;
        
    }
    
    public int ans(int index, int a, int b){
        if(index>=n){
            if(a==b){
                return 1;
            }
            return 0;
        }
        
        if(b>a){
            return dp[index][a][b] = 0;
        }
        
        if(dp[index][a][b]!=-1){
            return dp[index][a][b];
        }
        
        int opt;
        if(arr[index]=='*'){
            opt = ans(index + 1, a + 1, b) | ans(index + 1, a, b+1) | ans(index + 1, a, b);
        }
        else{
            if(arr[index]=='('){
                opt = ans(index + 1, a+1, b);
            }
            else{
                opt = ans(index + 1, a, b+1);
            }
        }
        
        return dp[index][a][b] = opt;
    }
}