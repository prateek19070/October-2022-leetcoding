class Solution {
    public int findDuplicate(int[] arr) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(!set.contains(arr[i]))set.add(arr[i]);
            else return arr[i];
        }
        return -1;
    }
}