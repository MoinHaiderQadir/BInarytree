class TreeNode {
    Object data;
    TreeNode left, right;

    public TreeNode(Object root, TreeNode left, TreeNode right) {
        this.data = root;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Object root) {
        this.data = root;
        this.left = null;
        this.right = null;
    }

    public static TreeNode build(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        // Assuming data is of type Integer for comparison
        int rootValue = (Integer) root.data;
        if (rootValue > key) {
            root.left = build(root.left, key);
        } else if (rootValue < key) {
            root.right = build(root.right, key);
        }

        return root;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (left != null)
            buf.append(left).append(" ");
        buf.append(data);
        if (right != null)
            buf.append(" ").append(right);
        return buf.toString();
    }

    public String preorder() {
        StringBuilder buf = new StringBuilder();
        buf.append(data);
        if (left != null)
            buf.append(" ").append(left.preorder());
        if (right != null)
            buf.append(" ").append(right.preorder());
        return buf.toString();
    }

    public Object search(TreeNode root, Object key) {
        if (root == null)
            return null;

        // Assuming data is of type Integer for comparison
        int keyValue = (Integer) key;
        int rootValue = (Integer) root.data;

        if (keyValue == rootValue)
            return root.data;
        else if (keyValue < rootValue)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5); // Example root node with data 5
        root = TreeNode.build(root, 3); // Adding a new node with data 3
        root = TreeNode.build(root, 7); // Adding a new node with data 7
        root = TreeNode.build(root, 4); // Adding a new node with data 4
        root = TreeNode.build(root, 6); // Adding a new node with data 6

        // Printing preorder traversal of the tree
        System.out.println("Preorder Traversal:");
        System.out.println(root.preorder());

        // Searching for a node in the tree
        System.out.println("Search result for '4': " + root.search(root, 4));
    }
}
