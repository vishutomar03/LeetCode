class Solution {
    public boolean judgeSquareSum(int c) {
        long a, b = c;
        for(long i = 0; i*i <= c; i++){
            a = b - i*i;
            if((long)Math.pow(a,0.5) * (long)Math.pow(a,0.5) == a)
                return true;
        }
        return false;
    }
}