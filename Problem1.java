class Solution {
    public int[] twoSum(int[] arr, int k) {
        int x=0,y=0;
        int ans[]=new int[2];
        int t[]=arr.clone();
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        while(i<j){
            int sum=arr[i]+arr[j];
            if(sum==k){
                x=arr[i];
                y=arr[j];
                break;
            }
            else if(sum>k)j--;
            else i++;
        }
        System.out.println(x+" "+y);
        for( i=0;i<t.length;i++){
            if(x==t[i]){
                ans[0]=i;
                break;
            }
        }
        for( i=0;i<t.length;i++){
            if(y==t[i] && i!=ans[0]){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}