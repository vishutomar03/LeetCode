class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    int n, a = 0, index = 0;
    public boolean isValidSerialization(String preorder) {
        n = preorder.length();
        
        for(int i = 0; i < n; i++){
            if(preorder.charAt(i) == '#'){
                arr.add(0);
                i++;
            }
            else{
                while(i < n && preorder.charAt(i) != ',')
                    i++;                
                arr.add(1);
            }
        }
        
        n = arr.size();
        
        if(n % 2 == 0)
            return false;
        
        ans();
    
        if(index + 1 == n)
            return true;
        return false;
        
    }
    
    public void ans(){
        if(index >= n){
            a++;
            return;
        }
        if(arr.get(index) == 0){
            return;
        }
        index++;
        ans();
        index++;
        ans(); 
    }
}
