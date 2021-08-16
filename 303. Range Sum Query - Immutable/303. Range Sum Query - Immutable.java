class NumArray {
    int[] arr;
    int[][] st;
    int k = 25, n;
    public NumArray(int[] nums) {
        arr = nums;
        n = arr.length;        
        st = new int[n + 1][k + 1];
        for(int i = 0; i < n; i++){
            st[i][0] = arr[i];
        }
        
        for(int j = 1; j < k; j++){
            for(int i = 0; (i +(1<<j)) <=n; i++){
                st[i][j] = st[i][j-1] + st[i+(1<<(j-1))][j-1];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        int ans = 0;
        int range = right - left + 1;
        for(int i = 0; i <= k; i++){
            if(((1<<i) & range) > 0) {
                ans += st[left][i];
                left+=(1<<i);
            }
        }
        return ans;
    }
}
