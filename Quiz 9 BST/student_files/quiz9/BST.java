package quiz9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST implements Iterable<String> {

    private BSTNode root;

    /**
     * Constructs an empty binary search tree with an initial root of
     * null.
     * Remember, there should be no dummy root. In other words
     * size()==0 iff root=null.
     */
    BST() {
        root = null;
    }

    /**
     * Returns the number of elements in this binary search tree
     *
     * @return the number of elements in this binary search tree
     */
    public int size() {
        //TODO: implement
        return 0;
    }

    /**
     * Checks if a node with the value of data is in the tree
     * The complexity of this method should be O(h) where h is
     * the height of the tree
     *
     * @param  data  the searching data.
     * @return true iff for a node n in the tree,
     *         n.getData().equals(data).
     */
    public boolean contains(String data) {
        //TODO: implement
        return false;
    }

    /**
     * Inserts a new node with the value data in the tree iff the
     * value does not already exist in the tree (no node n
     * s.t. n.getData().equals(data))
     * The complexity of this method should be O(h) where h is the
     * height of the tree
     *
     * @param  data  the inserting data. Not null.
     * @return true iff a new node with value of data is inserted to
     *         the tree
     */
    public boolean insert(String data) {
        //TODO: implement
        return false;
    }

    /**
     * Deletes the node with the value of data from the tree iff
     * there is a node n which n.getData().equals(data)
     * The complexity of this method should be O(h) where h is
     * the height of the tree
     *
     * @param  data  the deleting data.
     * @return true iff a the node with value of data is deleted from
     *         the tree
     */
    public boolean delete(String data) {
        //TODO: implement
        return false;
    }

    /**
     * Returns a new in-order iterator on this binary search tree.
     * Do NOT change this method at all.
     *
     * @return a new in-order iterator on this binary search tree
     */
    public final Iterator<String> iterator() {
        return new BSTInOrderIterator(root);
    }

    /**
     * This method is going to be used by your TA to verify the
     * underlying structure of your binary search tree implementation.
     * Do NOT change this method at all.
     *
     * @return true iff the binary search tree instance is internally
     *         OK
     */
    public final boolean correctInternalStructure() {
        return BSTWhiteBoxVerfier.repOk(this, this.root);
    }
}

/**
 * This is an in-order iterator implementation for your binary search
 * class.
 * The memory size of your iterator should remain O(1).
 * Do NOT worry about any concurrent modification.
 */
class BSTInOrderIterator implements Iterator<String> {

    BSTInOrderIterator(BSTNode root) {
        //TODO: implement
    }

    /**
     * This method determines whether or not there is more element
     * The complexity of this method should be O(1).
     * You do not have to worry about concurrent modification.
     *
     * @return true iff there are more elements to go.
     */
    public boolean hasNext() {
        //TODO: implement
        return false;
    }

    /**
     * This method retrieves the next element.
     * The complexity of this method should be O(1) on average; it
     * means if your next method is called n times, the overall
     * complexity should be O(n) which means O(1) per call on average.
     * It means you have to return the next element based on the
     * current location of the iterator. Some possible wrong
     * approaches are storing the number of returned elements
     * somewhere and doing the in-order traversal again until we reach
     * the index.
     * You must throw NoSuchElementException if there is no more
     * element.
     * You do NOT have to worry about concurrent modification.
     *
     * @throws NoSuchElementException if there is no more element.
     * @return the next value of next element in the in-order traversal.
     */
    public String next() {
        //TODO: implement
        return null;
    }

    /**
     * This method is just here to implement Iterator interface. You
     * should not implement this method as its meaning is vague in
     * this context.
     * Do NOT change this method at all.
     *
     * @throws UnsupportedOperationException this method should not be
     *         implemented.
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
