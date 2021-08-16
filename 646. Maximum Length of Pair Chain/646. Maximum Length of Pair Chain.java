class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        answer[] arr = new answer[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = new answer(pairs[i][0], pairs[i][1]);
        }
        
        Arrays.sort(arr);
        
        int[] dp = new int[1005];
        
        dp[0] = 1;
        int max = 0;
        for(int i = 1; i < n; i++){
            max = 0;
            for(int j = 0; j < i; j++){
                if(arr[j].b < arr[i].a){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
        }
        
        max = 0;
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
        
    }
    public class answer implements Comparable<answer>{
        int a, b;
        public answer(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(answer o){
            return this.a - o.a;
        }
    }
}