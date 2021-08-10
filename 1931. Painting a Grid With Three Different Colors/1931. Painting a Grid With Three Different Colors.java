class Solution {
    int MOD = (int)1e9 + 7;
    long[][] dp;
    int n, m;
    public int colorTheGrid(int a, int b) {
        n = a;
        m = b;
        dp = new long[m][1024];
        
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 1024; k++){
                    dp[j][k] =-1;
                }                          
            }
        
        return (int)(ans(0,0,0,0) % MOD);
    }
    public long ans(int i, int j, int prev, int curr){
        if(i==n){
            return ans(0,j+1,curr,0);
        }
        
        if(j==m){
            return 1;
        }
        
        if(dp[j][prev]!=-1){
            return dp[j][prev];
        }
        long opt = 0;
        int up = i == 0 ? 0 : (curr >>  ((i - 1) * 2)) & 3, left = prev >> (i * 2) & 3;
        
        for(int k = 1; k <= 3; k++){
            if(k!=up && k!=left){
                opt = (opt%MOD + ans(i+1, j, prev,  curr + (k<<(2*i))) % MOD) % MOD;
            }
        }
        if(i==0)
            return dp[j][prev] = opt % MOD;
        return opt;
        
    }
}
