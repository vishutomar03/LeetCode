class Solution {
    public int longestSubarray(int[] arr) {
        int n = arr.length, j = 0, a = 0, ans = 0;

        for(int i = 0; i < n; i++){
            if(arr[i]==0){
                if(a!=0){
                    while(arr[j]!=0){
                        j++;
                    }
                    j++;
                }
                else{
                    a++;
                }
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}