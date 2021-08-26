class Solution {
    int[] arr;
    int[] ans;
    int n , m, ind = 0;
    int[][] dp;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        n = people.size();
        m = req_skills.length;
        arr = new int[n];
        dp = new int[n+1][1<<m];
        int a, b;
        boolean flag;
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < (1<<m); j++){
                dp[i][j] = 1000;
            }
        }
                
        for(int i = 0; i < n; i++){
            a = 0;
            b = 1;
            for(int j = m-1; j >=0; j--){
                flag = false;
                for(int k = 0; k < people.get(i).size(); k++){
                    if(people.get(i).get(k).equals(req_skills[j])){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    a+=b;
                }
                b = b<<1;
            } 
            arr[i] = a;
        }
        
        int index = ans((1<<m) -1, 0);
        ans = new int[index];
        
        path((1<<m) -1, 0);
        return ans;
    }
    
    public int ans(int skillsLeft, int index){
        if(index>=n){
            if(skillsLeft!=0){
                return 100;
            }
            return 0;
        }
        if(skillsLeft==0){
            return 0;
        }

        if(dp[index][skillsLeft]!=1000){
            return dp[index][skillsLeft];
        }
        
        int opt, a = skillsLeft;
        for(int i = 0; i < m; i++){
            if(((skillsLeft) & (1<<i)) > 0 && ((arr[index]) & (1<<i)) > 0){
                skillsLeft = (skillsLeft)^(1<<i);
            }
        }
        if(a==skillsLeft){
            opt = ans(a, index+1);
        }
        else{
            opt = 1 + ans(skillsLeft, index+1);
            opt = Math.min(opt, ans(a, index+1));
        }
        return dp[index][a] = opt;
    }
    
    public void path(int skillsLeft, int index){
        if(index>=n){
            return;
        }
        if(skillsLeft==0){
            return;
        }
        int opt, a = skillsLeft;
        for(int i = 0; i < m; i++){
            if(((skillsLeft) & (1<<i)) > 0 && ((arr[index]) & (1<<i)) > 0){
                skillsLeft = (skillsLeft)^(1<<i);
            }
        }
        if(a==skillsLeft){
            path(a, index+1);
        }
        else{
            if(1 + ans(skillsLeft, index+1) < ans(a, index+1)){
                ans[ind++] = index;
                path(skillsLeft, index+1);
            }
            else{
                path(a, index+1);
            }
        }
    }    
}