class Solution {
    List<List<String>> list = new ArrayList<>();
    ArrayList<Integer> array = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int N){
        n = N;
        ans(0);
        return list;
    }
    public void ans(int index){
        if(index == n){
            ArrayList<String> arr = new ArrayList<>();
            StringBuilder s;
            int ab;
            for(int i = 0; i < n; i++){
                s = new StringBuilder();
                ab = array.get(i);
                for(int j = 0; j < n; j++){
                    if(ab==j){
                        s.append("Q");
                    }
                    else{
                        s.append(".");
                    }
                }
                arr.add(s.toString());
            }
            list.add(arr);
            return;
        }
        for(int i = 0; i < n; i++){
            if(possible(index, i)){
                array.add(i);
                ans(index+1);
                array.remove(array.size()-1);
            }
        }
    }

    public boolean possible(int x, int y){
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) == y){
                return false;
            }
            if(Math.abs(array.get(i) - y) == x - i){
                return false;
            }
        }
        return true;
    }
}
