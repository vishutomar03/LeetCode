class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int a = 0, ans, n, b = 0;
        n = arr.length; // length of the array
        for(int i = 0; i < n; i++){
            if(arr[i]=='1'){
                a++;
            }
        }        
        ans = a;
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
        return ans; // minimum number of flips
    }
}
