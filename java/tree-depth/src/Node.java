/** A tree node pointing to its left and right child nodes represents a binary tree. */
public class Node {

    private final Node left;

    private final Node right;

    public Node(final Node left, final Node right){
        this.left = left;
        this.right = right;
    }

    public Node(){
        this(null, null);
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
