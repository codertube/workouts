import java.util.HashSet;
import java.util.Set;

public class TreeDepthImpl implements TreeDepth {

    /**
     * Finds out if all the leaves in the given binary tree are in the same depth measured from the root node.
     * The tree is represented by a node pointing to its left and right child nodes.
     * @param root Root of the input tree to be checked. Must not be null.
     * @throws IllegalArgumentException if the root is null.
     * @return True if all the leaves of the input tree are in the same depth, otherwise false.
     */
    @Override
    public boolean areLeavesInSameDepth(final Node root) {

        if (root == null) throw new IllegalArgumentException("root is null");

        checkLeafs(root);
        return false;
    }

    private void checkLeafs(final Node root) {

    }
	
}
