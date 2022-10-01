// Decode Ways

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 1){
            return Integer.parseInt(s) == 0 ? 0 : 1;
        }
        int[] memo = new int[s.length()+1];
        memo[0] = 1;
        for(int i = 0; i < memo.length-1; i++){
            if(s.charAt(i) != '0'){
                if(i+1 < memo.length){
                    int temp = s.charAt(i) - '0';
                    memo[i+1] += memo[i];
                }
                if(i+2 < memo.length){
                    int temp = (s.charAt(i) - '0')*10 + s.charAt(i+1)-'0';
                    if(temp <= 26)
                        memo[i+2] += memo[i];
                }
            }
        }
        return memo[memo.length - 1];
    }
}