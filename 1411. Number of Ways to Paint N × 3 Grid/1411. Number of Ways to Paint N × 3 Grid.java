class Solution {
    int MOD = (int) 1e9 + 7;
    int n;
    long[][] dp = new long[63][5005];
    public int numOfWays(int a) {
        n = a;        
        for(int i = 0; i < 63; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return (int)(ans(0,0,0,0)%MOD);
    }
    public long ans(int i, int j, int prev, int curr){
        if(j==3){
            return ans(i+1, 0, curr, 0);
        }        
        if(i==n){
            return 1;
        }        
        if(dp[prev][i]!=-1){
            return dp[prev][i];
        }
        
        long opt = 0;
        int up = (prev >>  (j * 2)) & 3, left = (curr >> ((j-1) * 2) & 3);
        for(int k = 1; k <= 3; k++){
            if(k!=left && k!= up){
                opt = (opt%MOD + ans(i, j+1, prev, curr ^ (k<<(2*j)))%MOD)%MOD;
            }
        }
        if(j==0){
            return dp[prev][i] = opt % MOD;
        }
        return opt;
    }
}
