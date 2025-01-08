package BinaryTree;

public class Node {
    static final boolean COLOR_RED = false;
    static final boolean COLOR_BLACK = true; 
	int key;
    boolean color;
    Node left;
    Node right;

    public Node(int key, boolean color) {
        this.key = key;
        this.color = color;
        this.left = null;
        this.right = null;
    }

    // Constructor for isValidBST
    public Node(int key) {
        this.key = key;
        this.color = false;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }

    public boolean isColor() {
        return color;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getKey() {
        return key;
    }
}
