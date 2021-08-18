class Solution {
    public String longestPalindrome(String s) {
        int n;
        n = s.length();
        
        if(n==1){
            return s;
        }
        
        char[] arr = s.toCharArray();
        
        int ans = 0;
        int a, b = 0, c = 0, d = 0, j , k;
        
        for(int i = 1; i < n; i++){
            a = 0;
            for(j = i-1, k = i+1 ; j>=0 && k<n ; j--, k++){
                if(arr[j]!=arr[k]){
                    if(ans<(k-1) - (j+1) + 1){
                        ans = (k-1) - (j+1) + 1;
                        b = j+1;
                        c = k;
                    }
                    a++;
                    break;
                }
            }
            if(a==0){
                if(ans<(k-1) - (j+1) + 1){
                        ans = (k-1) - (j+1) + 1;
                        b = j+1;
                        c = k;
                    }
            }
            a = 0;
            
            for(j = i-1, k = i; j>=0 && k<n ; j--, k++){
                if(arr[j]!=arr[k]){
                    if(ans<(k-1) - (j+1) + 1){
                        ans = (k-1) - (j+1) + 1;
                        b = j+1;
                        c = k;
                    }
                    a++;
                    break;
                }
            }
            if(a==0){
                if(ans<(k-1) - (j+1) + 1){
                        ans = (k-1) - (j+1) + 1;
                        b = j+1;
                        c = k;
                    }
            }
       
        }
        return s.substring(b,c);
    }
}