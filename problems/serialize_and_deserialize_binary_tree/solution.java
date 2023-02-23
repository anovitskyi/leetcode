public class Codec {

    private static final String SEPARATOR = ",";
    private static final String NULL = "null";

    public String serialize(TreeNode root) {
        StringBuilder b = new StringBuilder();
        serializePreOrder(root, b);
        return b.toString();
    }

    private void serializePreOrder(TreeNode root, StringBuilder b) {
        if (root == null) {
            if (!b.isEmpty()) {
                b.append(SEPARATOR);
            }
            b.append(NULL);
            return;
        }

        if (!b.isEmpty()) {
            b.append(SEPARATOR);
        }
        b.append(root.val);
        serializePreOrder(root.left, b);
        serializePreOrder(root.right, b);
    }

    public TreeNode deserialize(String data) {
        String[] tab = data.split(SEPARATOR);
        int[] index = new int[] {0};
        return deserializePreOrder(tab, index);
    }

    private TreeNode deserializePreOrder(String[] data, int[] index) {
        if (index[0] >= data.length || data[index[0]].equals(NULL)) {
            ++index[0];
            return null;
        }

        int val = Integer.parseInt(data[index[0]]);
        ++index[0];

        TreeNode node = new TreeNode(val);
        node.left = deserializePreOrder(data, index);
        node.right = deserializePreOrder(data, index);

        return node;
    }
}