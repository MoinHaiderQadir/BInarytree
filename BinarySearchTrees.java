public class BinarySearchTrees {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int root, TreeNode left, TreeNode right) {
            this.data = root;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int root) {
            this.data = root;
            this.left = null;
            this.right = null;
        }

        public static TreeNode Build(TreeNode root, int key) {
            if (root == null) {
                return new TreeNode(key);
            }

            if (root.data > key) {
                root.left = Build(root.left, key);
            } else if (root.data < key) {
                root.right = Build(root.right, key);
            }

            return root;
        }

        public static boolean Search(TreeNode root, int key) {
            if (root == null) {
                return true;
            }

            if (root.data > key) {
                 return Search(root.left, key);
            } else if (root.data == key) {
                return true;
            }
            else{
                 return Search(root.right, key);
            }


        }








        public static String toString(TreeNode node) {
            StringBuilder buf = new StringBuilder();
            if (node.left != null)
                buf.append(toString(node.left)).append(" ");
            buf.append(node.data);
            if (node.right != null)
                buf.append(" ").append(toString(node.right));
            return buf.toString();
        }

        public static String preorder(TreeNode node) {
            StringBuilder buf = new StringBuilder();
            buf.append(node.data);
            if (node.left != null)
                buf.append(" ").append(preorder(node.left));
            if (node.right != null)
                buf.append(" ").append(preorder(node.right));
            return buf.toString();
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = null;



        treeNode = TreeNode.Build(treeNode, 8);
        treeNode = TreeNode.Build(treeNode, 5);
        treeNode = TreeNode.Build(treeNode, 10);
        treeNode = TreeNode.Build(treeNode, 3);
        treeNode = TreeNode.Build(treeNode, 6);
        treeNode = TreeNode.Build(treeNode, 1);
        treeNode = TreeNode.Build(treeNode, 4);
        treeNode = TreeNode.Build(treeNode, 6);
        treeNode = TreeNode.Build(treeNode, 11);
        treeNode = TreeNode.Build(treeNode, 14);
        System.out.println(TreeNode.toString(treeNode));
        System.out.println(TreeNode.preorder(treeNode));
        System.out.println (TreeNode.Search(treeNode,40));

    }
}
