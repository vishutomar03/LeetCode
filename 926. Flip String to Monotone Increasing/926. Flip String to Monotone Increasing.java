class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int a = 0, ans, n;
        n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i]=='1'){
                a++;
            }
        }        
        ans = a;
        int b = 0;
        for(int i = n-1; i >= 0; i--){
            if(arr[i]=='0'){
                b++;
                ans = Math.min(ans, b+a);
            }
            else{
                a--;
                ans = Math.min(ans, b+a);
            }
        }
        return ans;
    }
}