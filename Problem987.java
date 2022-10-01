// Vertical Order Traversal of a Binary Tree

class Pair{
    TreeNode node;
    int hd;
    int level;
    Pair(TreeNode n, int h, int l){
        node = n;
        hd = h;
        level = l;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        while(queue.size() != 0){
            int count = queue.size();
            for(int i = 0 ; i < count; i++){
                Pair p = queue.poll();
                TreeNode temp = p.node;
                int dist = p.hd;
                int lev = p.level;
                if(map.containsKey(dist)){
                    TreeMap<Integer, ArrayList<Integer>> internalMap = map.get(dist);
                    if(internalMap.containsKey(lev)){
                        internalMap.get(lev).add(temp.val);
                        Collections.sort(internalMap.get(lev));
                    }
                    else{
                        ArrayList<Integer> valList = new ArrayList<>();
                        valList.add(temp.val);
                        internalMap.put(lev, valList);
                    }
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(temp.val);
                    TreeMap<Integer, ArrayList<Integer>> internalMap = new TreeMap<>();
                    internalMap.put(lev, list);
                    map.put(dist, internalMap);
                }
                if(temp.left != null){
                    queue.add(new Pair(temp.left, dist - 1, lev+1));
                }
                if(temp.right != null){
                    queue.add(new Pair(temp.right, dist + 1, lev+1));
                }
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(TreeMap<Integer, ArrayList<Integer>> internalMap:map.values()){
            List<Integer> internalList = new ArrayList<>();
            for(ArrayList<Integer> valList:internalMap.values()){
                for(int values:valList){
                    internalList.add(values);
                }
            }
            result.add(internalList);
        }
        return result;
    }
}
