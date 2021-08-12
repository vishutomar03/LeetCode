class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.getOrDefault(s.charAt(i), null)==null){
                map.put(s.charAt(i), new ArrayList<Integer>());
            }
            map.get(s.charAt(i)).add(i);
        }
        int[] arr = new int[26];
        
        int ans = 0, b = 0;
        for(Character c: map.keySet()){
            if(map.get(c).size()==1){
                continue;
            }
            b = 0;
            for(int i = map.get(c).get(0); i <= map.get(c).get(map.get(c).size()-1); i++){
                arr[ s.charAt(i)-'a'] = 1;
            }
            
            for(int i = 0;i < 26; i++){
                if(arr[i]==1 && i!=c-'a'){
                    b++;
                }
            }
            
            if(map.get(c).size() >= 3){
                b++;
            }
            
            if(b>=0){
                ans+=b;
            }
            
            for(int i = 0; i < 26; i++){
                arr[i] = 0;
            }
        }
        
        return ans;
        
        
    }
}