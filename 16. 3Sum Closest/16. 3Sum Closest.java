class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int l, r, mid, ans = 0, min = Integer.MAX_VALUE, a;
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n -1; j++){
                a = target - (arr[i] + arr[j]);
                l = j;
                r = n;
                while(l+1 < r){
                    mid = (l + r)/2;
                    if(arr[mid]<=a){
                        l = mid;
                    }
                    else{
                        r = mid;
                    }
                }
                
                if(l==j){
                    if(min > Math.abs(target - (arr[i] + arr[j] + arr[r]))){
                        min = Math.abs(target - (arr[i] + arr[j] + arr[r]));
                        ans = arr[i] + arr[j] + arr[r];
                    }
                }
                else if(r==n){
                    if(min > Math.abs(target - (arr[i] + arr[j] + arr[l]))){
                        min = Math.abs(target - (arr[i] + arr[j] + arr[l]));
                        ans = arr[i] + arr[j] + arr[l];
                    }
                }
                else{
                    if(min > Math.abs(target - (arr[i] + arr[j] + arr[r]))){
                        min = Math.abs(target - (arr[i] + arr[j] + arr[r]));
                        ans = arr[i] + arr[j] + arr[r];
                    }
                    
                    if(min > Math.abs(target - (arr[i] + arr[j] + arr[l]))){
                        min = Math.abs(target - (arr[i] + arr[j] + arr[l]));
                        ans = arr[i] + arr[j] + arr[l];
                    }
                }
        
            }
        }
        
        return ans;
        
    }
}