public class Codec {

    private static final String sep = ",";
    private static final String nullVal = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(nullVal);
            return;
        }
        
        builder.append(node.val);
        
        builder.append(sep);
        dfs(node.left, builder);
        
        builder.append(sep);
        dfs(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tab = data.split(sep);
        return rdfs(tab, new int[] {0});
    }
    
    private TreeNode rdfs(String[] tab, int[] index) {
        if (tab[index[0]].equals(nullVal)) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(tab[index[0]]));
        ++index[0];
        node.left = rdfs(tab, index);
        ++index[0];
        node.right = rdfs(tab, index);
        return node;
    }
    
    // 1,2,null,null,3,4,null,null,5,null,null
}