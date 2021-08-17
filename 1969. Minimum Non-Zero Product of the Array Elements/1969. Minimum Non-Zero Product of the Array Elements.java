class Solution {
    long MOD;
    public int minNonZeroProduct(int p) {
        MOD = 2L*(long)1e18;
        long a = power(2,p) - 1;
        long ans;
        MOD = 1000000007;
        ans = (a%MOD * (power(a-1, (a-1)/2))%MOD)%MOD;
        return (int)(ans % MOD);
    }
    public long power(long base, long pow){
        if(pow == 0){
            return 1L;
        }
        if(pow %2 != 0){
            return (base%MOD * power(base%MOD, pow-1)%MOD)%MOD;
        }
        return power((base%MOD * base%MOD)%MOD, pow/2);
    }
    public long power(long base, int pow){
        if(pow == 0){
            return 1;
        }
        if(pow %2 != 0){
            return base * power(base, pow-1);
        }
        return power(base * base, pow/2);
    }
}