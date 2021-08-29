class Solution {
    List<List<Integer>> list;
    ArrayList<Integer> array;
    int[] arr;
    int n;
    Set<String> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<>();
        arr = nums;
        Arrays.sort(arr);
        n = arr.length;
        
        ans(0, 0);
        
        return list;
        
    }
    
    public void ans(int index, int a){
        if(index>=n){
            array = new ArrayList<>();
            String s= "";
            for(int i = 0; i < n; i++){
                if((a&(1<<i))>0){
                    array.add(arr[i]);
                    s = s + arr[i];
                }
            }
            if(!set.contains(s)){
                list.add(array);
                set.add(s);
            }
            return;
        }
        ans(index + 1, a ^ (1<<index));
        ans(index + 1, a);
    }
}