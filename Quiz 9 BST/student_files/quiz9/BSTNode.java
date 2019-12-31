package quiz9;

/**
 * A binary search node class with a string as its data.
 * Do not modify this code at all.
 * In order to compare strings, you can use the method compareTo.
 * All of the links left, right, and parent should be valid.
 * Parent of root should be null.
 * No data should be null.
 * For children of every node n, parent should be n.
 */
public final class BSTNode {

    private String data;
    private BSTNode parent, left, right;

    public BSTNode(String data, BSTNode parent) {
        this.data = data;
        this.parent = parent;
        left = right = null;
    }

    public String getData() {
        return data;
    }

    public BSTNode getParent() {
        return parent;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
