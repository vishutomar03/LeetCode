class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] arr = s.toCharArray();
        int n = arr.length, a = 0, b = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
    
        for(int i = n-2; i >= 0; i--){
            if(arr[i]=='0'){
                ar.add(i);
            }
        }

        if(arr[n-1] !='0'){
            return false;
        }
        
        set.add(n-1);
        int l, r, mid;
        
        for(Integer i : ar){
            if(set.ceiling(i + minJump)!=null){
                if(set.ceiling(i+minJump) <= i + maxJump){
                    set.add(i);
                }
            }
        }        
        return set.contains(0);
    }
}
