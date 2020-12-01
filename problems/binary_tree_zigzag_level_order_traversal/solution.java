class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;   
        }
        
        LinkedList<Integer> list = null;
        if (level < result.size()) {
            list = (LinkedList<Integer>) result.get(level);
        } else {
            list = new LinkedList<>();
            result.add(list);
        }
        
        if (level % 2 == 0) {
            list.add(node.val);
        } else {
            list.offerFirst(node.val);
        }
        
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}