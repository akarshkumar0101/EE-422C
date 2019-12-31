package quiz9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST implements Iterable<String> {

    public BSTNode root;

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
        return size(root);
    }
    public static int size(BSTNode node){
        if(node==null){
            return 0;
        }
        else{
            return 1+size(node.getLeft())+size(node.getRight());
        }
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
        return find(data,root)!=null;
    }
    private static BSTNode find(String data, BSTNode node){
        if(node==null){
            return null;
        }
        else if(node.getData().equals(data)){
            return node;
        }
        else{
            //traverse
            if(node.getData().compareTo(data)>0){
                //if my data is bigger, then traverse left
                return find(data,node.getLeft());
            }
            else{
                return find(data,node.getRight());
            }
        }
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
        if(contains(data)){
            return false;
        }
        if(root==null){
            root = new BSTNode(data, null);
        }
        else{
            insert(data,root);
        }
        return true;
    }
    private static void insert(String data, BSTNode node){
        if(node.getData().compareTo(data)>0){
            //im bigger than data
            if(node.getLeft()==null){
                BSTNode newNode = new BSTNode(data,node);
                node.setLeft(newNode);
            }
            else{
                insert(data,node.getLeft());
            }
        }
        else{
            if(node.getRight()==null){
                BSTNode newNode = new BSTNode(data,node);
                node.setRight(newNode);
            }
            else{
                insert(data,node.getRight());
            }
        }
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
        BSTNode node = find(data,root);
        if(node==null){
            return false;
        }
        else{
            delete(node);
        }
        return true;
    }
    private void delete(BSTNode node){
        if(node.getLeft()==null && node.getRight()==null){
            //then simply delete it
            if(node==root){
                root = null;
            }else {
                BSTNode parent = node.getParent();
                if(parent.getLeft()==node){
                    parent.setLeft(null);
                }
                else {
                    parent.setRight(null);
                }
            }
        }
        else if(node.getLeft()==null || node.getRight()==null){
            BSTNode child=null;
            if(node.getRight()!=null){
                child = node.getRight();
            }
            else{
                child = node.getLeft();
            }

            if(node==root){
                root = child;
            }
            else{
               BSTNode parent = node.getParent();
               if(parent.getLeft()==node){
                   parent.setLeft(child);
               }
               else{
                   parent.setRight(child);
               }
               child.setParent(parent);
            }
        }
        else{
            //both are non null
            BSTNode rightChildMin = min(node.getRight());
            //replace the data;
            node.setData(rightChildMin.getData());
            delete(rightChildMin);
        }
    }
    public static BSTNode min(BSTNode node){
        if(node.getLeft()==null){
            return node;
        }
        else{
            return min(node.getLeft());
        }
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

    @Override
    public String toString(){
        return "BST: "+toString(root);
    }
    private String toString(BSTNode node){
        if(node==null){
            return "{}";
        }
        String str ="{";

        str+=" D: "+node.getData();
        str+=" L: "+toString(node.getLeft());
        str+=" R: "+toString(node.getRight());
        return str+"}";
    }
}

/**
 * This is an in-order iterator implementation for your binary search
 * class.
 * The memory size of your iterator should remain O(1).
 * Do NOT worry about any concurrent modification.
 */
class BSTInOrderIterator implements Iterator<String> {

    private final int size;
    private int i;

    private final BSTNode root;

    private BSTNode current;
    BSTInOrderIterator(BSTNode root) {
        size = BST.size(root);
        i=0;
        this.root = root;
        current = BST.min(root);
    }

    /**
     * This method determines whether or not there is more element
     * The complexity of this method should be O(1).
     * You do not have to worry about concurrent modification.
     *
     * @return true iff there are more elements to go.
     */
    public boolean hasNext() {
        return i<size;
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
        if(i>=size){
            throw new NoSuchElementException("Out of items to iterate.");
        }
        i++;

        String ret = current.getData();

        //update current
        if(i<size){
            current = getNextNode(current, true);
        }

        return ret;
    }

    private BSTNode getNextNode(BSTNode current, boolean rightAllowed){
        //we've done everything to the left of current
        //and we JUST finished doing current
        if(rightAllowed && current.getRight()!=null){
            //start traversing the right side now
            return BST.min(current.getRight());
        }
        else{
            //either right not allowed OR we're out of elements to the right
            //so start traversing up.
            BSTNode parent = current.getParent();
            if(parent.getLeft()==current){
                //then we're traversing up from the left side. so now do parent because in order
                return parent;
            }
            else{
                //then we're traversing up from the right side, so parent has been done. traverse further
                return getNextNode(parent, false);
            }
        }
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
