class Solution {
    public int maxSumMinProduct(int[] arr) {
        Stack<answer> left = new Stack<>();
        Stack<answer> right = new Stack<>();
        int n = arr.length, MOD = (int) 1e9+7;
        int[] l = new int[n];
        int[] r = new int[n];
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        
        for(int i = 0; i <  n; i++){
            while(left.size()!=0 && left.peek().a >= arr[i]){
                left.pop();
            }
            if(left.size()==0){
                l[i] = -1;
            }
            else{
                l[i] = left.peek().b;
            }
            left.add(new answer(arr[i], i));
            if(i==0){
                prefix[i] = arr[i];
            }
            else{
                prefix[i] = (long)arr[i] + prefix[i-1];
            }
        }                
        
        for(int i = n-1;i >= 0; i--){
            while(right.size()!=0 && right.peek().a >= arr[i]){
                right.pop();
            }
            if(right.size()==0){
                r[i] = n;
            }
            else{
                r[i] = right.peek().b;
            }
            right.add(new answer(arr[i], i));
        }
        long ans = 0;
        
        for(int i = 0; i < n; i++){
            l[i]++;
            r[i]--;
            if(l[i]==0){
                ans = Math.max(ans, prefix[r[i]] * (long)arr[i]);
            }
            else{
                ans = Math.max(ans, (prefix[r[i]] - prefix[l[i]-1]) *(long) arr[i]);
            }
        }
        ans %=MOD;
        return (int)ans;
    }
    
    public class answer{
        int a, b;
        public answer(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}