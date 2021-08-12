class Solution {
    int[] arr;
    double time;
    int n;
    public int minSpeedOnTime(int[] dist, double hour) {
        int l, r, mid;
        arr = dist;
        n = arr.length;
        time = hour;
        l = 0;
        r = 10000001;
        while(l+1< r) {
            mid = (l + r)/2;
            if(!ans(mid)){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        if(r==10000001)
            return -1;
        return r;
    }    
    
    public boolean ans(int mid){
        double a = 0;
        for(int i = 0; i < n - 1; i++){
            a += Math.ceil((double)arr[i]/(double)mid);
        }
        a+=(double)arr[n-1] / (double)mid;
        if(a<=time){
            return true;
        }
        return false;
    }
}