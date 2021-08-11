class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] suffix = new long[n];
        suffix[n-1] = nums[n-1];
        
        for(int i = n-2; i >=0;i --){
            suffix[i] = nums[i] + suffix[i+1];
        }
        
        int l, r, mid, ans = 0;
        
        for(int i = 0; i < n; i++){
            l = -1;
            r = i;
            while(l+1<r){
                mid = (l + r)/2;
                if(suffix[mid] + k  - suffix[i] <(long) nums[i] * (long)(i - mid)){
                    l = mid;
                }
                else{
                    r = mid;
                }
            }
            ans = Math.max(ans, i - r  + 1);
        }
        return ans;
    }
    
}