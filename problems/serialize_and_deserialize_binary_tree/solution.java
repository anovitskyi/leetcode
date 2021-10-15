import java.util.UUID;

public class Codec {
    
    private static final Map<String, TreeNode> cache = new HashMap<>();

    public String serialize(TreeNode root) {
        String id = UUID.randomUUID().toString();
        cache.put(id, root);
        return id;
    }

    public TreeNode deserialize(String id) {
        return cache.get(id);
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));