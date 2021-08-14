class Solution {
    int[] arr;
    public int minAbsDifference(int[] nums, int goal) {
        arr = nums;
        int n = arr.length;
        ArrayList<Long> array = new ArrayList<>();
        ans(0,0,n/2, array);
        ArrayList<Long> array1 = new ArrayList<>();
        ans(n/2, 0, n, array1);
        
        Collections.sort(array);
        Collections.sort(array1);
    
        int l, r, mid;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.size(); i++){
            l = -1;
            r = array1.size();
            while(l+1<r){
                mid = (l+r)/2;
                if(array1.get(mid) <= goal - array.get(i)){
                    l = mid;
                }
                else{
                    r = mid;
                }
            }
    
            if(l!=-1){
                min = (int)Math.min(min, Math.abs(array.get(i) + array1.get(l)  - goal));
                if(r!=array1.size()){
                    min = (int)Math.min(min, Math.abs(array.get(i) + array1.get(r)  - goal));
                }
            }
            else{
                if(r!=array1.size()){
                    min = (int)Math.min(min, Math.abs(array.get(i) + array1.get(r)  - goal));
                }
            }
            
        }
        return min;
    }
    public void ans(int index, long sum, int n, ArrayList<Long> array){
        if(index>=n){
            array.add(sum);
            return;
        }        
        ans(index + 1, sum + arr[index], n, array);
        ans(index + 1, sum, n, array);
    }
}
