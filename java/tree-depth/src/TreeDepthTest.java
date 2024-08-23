import org.junit.Assert;
import org.junit.Test;

public class TreeDepthTest {
    final TreeDepth algorithm = new TreeDepthImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTree() {
        algorithm.areLeavesInSameDepth(null);
    }

    @Test
    public void testOnlyRoot() {
        Assert.assertTrue( algorithm.areLeavesInSameDepth(new Node()) );
    }

    @Test
    public void testRootWithLeftChild() {
        final Node tree = new Node(new Node(), null);
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }

    @Test
    public void testRootWithRightChild() {
        final Node tree = new Node(null, new Node());
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }

    @Test
    public void testRootWithBothChildren() {
        final Node tree = new Node(new Node(), new Node());
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }

    /**
     * Leaves on different levels.
     * n---n
     * |
     * n
     * |
     * n
     */
    @Test
    public void testChildrenOnDifferentLevels() {
        final Node rightBranch = new Node();
        final Node leftBranch = new Node(new Node(), null);
        final Node tree = new Node(leftBranch, rightBranch);
        Assert.assertFalse( algorithm.areLeavesInSameDepth(tree) );
    }

    /**
     * Leaves on different levels.
     * n---n---n
     * |
     * n
     */
    @Test
    public void testChildrenOnDifferentLevelsRightBranch() {
        final Node rightBranch = new Node(null, new Node());
        final Node leftBranch = new Node();
        final Node tree = new Node(leftBranch, rightBranch);
        Assert.assertFalse( algorithm.areLeavesInSameDepth(tree) );
    }

    /**
     * Leaves on the same level (2).
     * n---n---n
     * |   |
     * n   n
     * |
     * n
     */
    @Test
    public void testChildrenOnSameLevel2() {
        final Node rightBranch = new Node(new Node(), new Node());
        final Node leftBranch = new Node(new Node(), null);
        final Node tree = new Node(leftBranch, rightBranch);
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }

    /**
     * Leaves on the same level (2).
     * n---n---n
     * |    \
     * n     n
     * | \
     * n  n
     */
    @Test
    public void testAllChildrenOnSameLevel2() {
        final Node rightBranch = new Node(new Node(), new Node());
        final Node leftBranch = new Node(new Node(), new Node());
        final Node tree = new Node(leftBranch, rightBranch);
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }

    /**
     * One leaf on the left.
     * n
     * |
     * n
     * |
     * n
     * |
     * n
     */
    @Test
    public void testChildrenOnSameLevelLeftLongBranch() {
        final Node tree = new Node(new Node(new Node(new Node(new Node(), null), null), null), null);
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }


    /**
     * One leaf on the right.
     * n
     * |
     * n
     * |
     * n
     * |
     * n
     */
    @Test
    public void testChildrenOnSameLevelRightLongBranch() {
        final Node tree = new Node(null, new Node(null, new Node(null, new Node(null, new Node()))));
        Assert.assertTrue( algorithm.areLeavesInSameDepth(tree) );
    }

}