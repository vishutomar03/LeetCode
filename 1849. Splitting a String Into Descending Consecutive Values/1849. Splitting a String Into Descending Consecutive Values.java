class Solution {
    char[] arr;
    String s;
    public boolean splitString(String s1) {
        s = s1;
        arr = s.toCharArray();
        return ans(0, 0, -1, 0);
    }
    public boolean ans(int index, int started, long prev, int a){
        if(index >= arr.length){
            if(started == index || started == 0||prev == -1){
                if(a <= 1){
                    return false;
                }
                return true;
            }
            if(prev - Long.parseLong(s.substring(started, index)) == 1)
                return true;
            return false;
        }
        boolean opt = false;
        if(Long.parseLong(s.substring(started, index + 1)) < (long)1e10){
            opt = ans(index + 1, started, prev, a);
        }
        else{
            return false;
        }
        if(prev == -1){
            opt =  opt || ans(index+1, index+1, Long.parseLong(s.substring(started, index+1)), a + 1);
        }
        else{
            if(prev - Long.parseLong(s.substring(started, index+1)) == 1){
                opt = opt || ans(index+1, index+1, Long.parseLong(s.substring(started, index+1)), a + 1);
            }
        }
        return opt;
    }
}
