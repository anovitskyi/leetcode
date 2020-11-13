class Solution {
//     public Node connect(Node root) {
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(root);
        
//         int counter = 1;
//         while (!queue.isEmpty() && queue.peek() != null) {
//             Node curr = null;
//             Node prev = null;
            
//             for (int i = 0; i < counter; ++i) {
//                 curr = queue.poll();
//                 curr.next = prev;
//                 prev = curr;
//                 queue.offer(curr.right);
//                 queue.offer(curr.left);
//             }
            
//             counter <<= 1;
//         }
        
//         return root;
//     }
    
     public Node connect(Node root) {
         if (root == null) {
             return null;
         }
         
        connectBoth(root.left, root.right); 
        return root;
    }
    
    private void connectBoth(Node left, Node right) {
        if (left == null) {
            return;
        } 
        
        left.next = right;
        
        if (left.right != null) {
            left.right.next = right.left;       
        }
        
        if (right.next != null && right.right != null) {
            right.right.next = right.next.left;
        }
        
        connectBoth(left.left, left.right);
        connectBoth(right.left, right.right);
    }
}