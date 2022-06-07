class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<long[]> levels = new ArrayList<>();
        traverseTree(root, levels, 0);
        
        List<Double> result = new ArrayList<>(levels.size());
        for (long[] levelData : levels) {
            result.add(levelData[1] * 1.0d / levelData[0]);
        }
        return result;
    }
    
    private void traverseTree(TreeNode node, List<long[]> levels, int level) {
        if (node == null) {
            return;
        }
        
        if (levels.size() <= level) {
            levels.add(new long[] {1, node.val});
        } else {
            long[] levelData = levels.get(level);
            ++levelData[0];
            levelData[1] += node.val;
        }
        
        traverseTree(node.left, levels, level + 1);
        traverseTree(node.right, levels, level + 1);
    }
}