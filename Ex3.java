package BinaryTree;

public class Ex3 {

    static final boolean COLOR_RED = false;
    static final boolean COLOR_BLACK = true;

    public static void main(String[] args) {
    	
    	        BinaryTree2 tree = new BinaryTree2();

    	        // Creating nodes
    	        Node node1 = new Node(4, Node.COLOR_BLACK);
    	        Node node2 = new Node(2, Node.COLOR_RED);
    	        Node node3 = new Node(6, Node.COLOR_RED);
    	        Node node4 = new Node(1, Node.COLOR_BLACK);
    	        Node node5 = new Node(3, Node.COLOR_BLACK);
    	        Node node6 = new Node(5, Node.COLOR_BLACK);
    	        Node node7 = new Node(7, Node.COLOR_BLACK);

    	        // Setting child nodes
    	        node1.setLeft(node2);
    	        node1.setRight(node3);
    	        node2.setLeft(node4);
    	        node2.setRight(node5);
    	        node3.setLeft(node6);
    	        node3.setRight(node7);

    	        // Setting root node
    	        tree.setRoot(node1); // Set the root node of the binary tree

    	        // Testing validateBST method
    	        boolean isBSTValid = Ex3.validateBST(tree);
    	        System.out.println("Is the binary tree a valid BST? " + isBSTValid);
    	        // Expected output: Is the binary tree a valid BST? true

    	        // Testing hasValidHeight method
    	        boolean hasValidHeight = Ex3.hasValidHeight(tree);
    	        System.out.println("Does the binary tree have a valid black height? " + hasValidHeight);
    	        // Expected output: Does the binary tree have a valid black height? true
    	    }
    	


    // Ex3.1
    public static boolean validateBST(BinaryTree2 tree) {
        return isBSTValid(tree.getRoot(), null, null);
    }

    public static boolean isBSTValid(Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((max != null && node.getKey() >= max) || (min != null && node.getKey() <= min)) {
            return false;
        }

        return isBSTValid(node.getLeft(), min, node.getKey()) && isBSTValid(node.getRight(), node.getKey(), max);
    }

    // Ex3.2
    public static boolean hasValidHeight(BinaryTree2 tree) {
        return checkBlackHeight(tree.getRoot());
    }

    public static boolean checkBlackHeight(Node node) {
        if (node == null) {
            return true;
        }

        if (getBlackHeight(node.getLeft()) != getBlackHeight(node.getRight())) {
            return false;
        }

        return checkBlackHeight(node.getLeft()) && checkBlackHeight(node.getRight());
    }

    public static int getBlackHeight(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.isColor() == COLOR_BLACK) {
            return Math.max(getBlackHeight(node.getLeft()), getBlackHeight(node.getRight())) + 1;
        }

        return Math.max(getBlackHeight(node.getLeft()), getBlackHeight(node.getRight()));
    }
}
