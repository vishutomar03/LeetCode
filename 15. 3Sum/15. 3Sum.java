class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, l, r, a, b;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n ; i++){
            if(arr[i] > 0){
                return list;
            }
            if(i!=0 && arr[i]==arr[i-1]){
                continue;
            }
            l = i+1;
            r = n-1;
            
            while(l < r){
                if(arr[l] + arr[r] < -1 * arr[i]){
                    l++;
                }                
                else if(arr[l] + arr[r] > -1 * arr[i]){
                    r--;
                }
                else{
                    list.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    a = l;
                    b = r;
                    while(l < r && arr[l]==arr[a]){
                        l++;
                    }
                    while(l < r && arr[r]==arr[b]){
                        r--;
                    }
                }
            }
        }
        return list;
    }
}
