import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  This is a test subclass
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.09.17
 */
public class MazeRunnerTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Tests the clearMap() method.
     */
    public void testClearMap()
    {
        Island island = new MazeIsland();
        MazeRunner mykayla = new MazeRunner();
        island.add(mykayla);
        mykayla.clearMap();
        assertTrue(mykayla.getWorld().getObjects(Net.class).isEmpty());
        assertTrue(mykayla.getWorld().getObjects(Flower.class).isEmpty());
    }
    /**
     * Test the finalDestination method.
     */
    public void testFinalDestination()
    {
        Island island = new MazeIsland();
        MazeRunner mykayla = new MazeRunner();
        island.add(mykayla, 1, 1);
        mykayla.finalDestination();
        assertEquals(mykayla.getGridY(), mykayla.getWorld().getHeight() - 2);
        assertEquals(mykayla.getGridX(), mykayla.getWorld().getWidth() - 2);
    }



}
