class Solution {
    public boolean find132pattern(int[] arr) {
        Stack<Integer>st=new Stack<>();
        int secondMax=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<secondMax) return true;
            
            while(!st.isEmpty() && arr[i]>st.peek()){
                secondMax=Math.max(secondMax,st.pop());
            }
            st.push(arr[i]);
        }
        return false;
    }
}