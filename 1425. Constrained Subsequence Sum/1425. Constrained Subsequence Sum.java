class Solution {
    public int constrainedSubsetSum(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<answer> pq = new PriorityQueue<>();
        int[] dp = new int[n];
        
        dp[0] = arr[0];
        int ans = dp[0];
        pq.add(new answer(dp[0], 0));
        for(int i = 1; i < n; i++){
            while(i-pq.peek().b>k){
                pq.poll();
            }
            if(pq.peek().a>0){
                dp[i] = arr[i] + pq.peek().a;
            }
            else{
                dp[i] = arr[i];
            }
            ans = Math.max(ans, dp[i]);
            pq.add(new answer(dp[i], i));
        }
        return ans;
    }
    static class answer implements Comparable<answer>{
        int a;
        int b;

        public answer(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(answer o) {
            return o.a - this.a;
        }
    }
}