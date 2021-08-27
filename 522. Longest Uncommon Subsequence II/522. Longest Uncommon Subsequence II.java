class Solution {
    int p, q;
    String s, s1;
    int[][] dp = new int[15][15];
    public int findLUSlength(String[] strs) {
        int n = strs.length, a, ans = -1;
        
        for(int i = 0; i < n; i++){
            a = 0;
            s = strs[i];
            p = s.length();
            for(int j = 0; j < n; j++){
                if(i!=j){
                    s1 = strs[j];
                    q = s1.length();
                    for(int k = 0; k < 15; k++){
                        for(int l = 0; l < 15; l++){
                            dp[k][l] = -1;
                        }
                    }
                    
                    if(ans(0,0) == p){
                        a++;
                    }
                }
            }
            if(a==0){
                ans = Math.max(ans, s.length());
            }
        }
        return ans;
        
    }
    public int ans(int i, int j){
        if(i>=p || j>=q){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int opt = 0;
        if(s.charAt(i)==s1.charAt(j)){
            opt = 1 + ans(i+1, j+ 1);
        }
        else{
            opt = ans(i, j+ 1);
            opt = Math.max(opt, ans(i+1, j));
        }
        return dp[i][j] = opt;
    }
}
