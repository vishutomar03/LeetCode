class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, a = 0, j = 0;
        Set<Character> set = new HashSet<>();
        for (int  i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                ans = Math.max(set.size(), ans);
                while(s.charAt(j)!=s.charAt(i)){
                    set.remove(s.charAt(j));
                    j++;
                }
                j++;
            }
            else{
                set.add(s.charAt(i));
            }
        }
        return ans = Math.max(set.size(), ans);
    }
}