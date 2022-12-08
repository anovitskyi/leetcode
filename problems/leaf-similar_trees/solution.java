class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getAllLeafs(root1, new ArrayList<>());
        List<Integer> list2 = getAllLeafs(root2, new ArrayList<>());
    
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getAllLeafs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
        } else {
            getAllLeafs(node.left, list);
            getAllLeafs(node.right, list);
        }

        return list;
    }
}