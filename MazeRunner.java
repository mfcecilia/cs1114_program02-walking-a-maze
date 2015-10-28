import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The jeroo will start at (1,1) holding 10 flowers.
 *  The jeroo will navigate the world picking flowers,
 *  clearing nets, and will stop at the end position.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.09.14
 */
public class MazeRunner extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunner object.
     */
    public MazeRunner()
    {
        super(1, 1, 10);
    }


    //~ Methods ...............................................................
    /**
     * While the world still has flowers and nets, continue navigating.
     * Pick flowers and clear nets.
     */
    public void clearMap()
    {
        /**
         * while the world is populated, keep navigating. 
         * pick flowers and disable nets.
         */
        while (!this.getWorld().getObjects(Net.class).isEmpty() 
            || !this.getWorld().getObjects(Flower.class).isEmpty())
        {
            //navigate along the right side
            if (!this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
            //navigates dead ends
            if (this.seesWater(RIGHT) && this.seesWater(LEFT)
                && this.seesWater(AHEAD))
            {
                this.turn(RIGHT);
                this.turn(RIGHT);
            }
            //navigates unavoidable left turns
            if (this.seesWater(AHEAD) && this.seesWater(RIGHT))
            {
                this.turn(LEFT);
            }
            //clears nets
            while (this.seesNet(AHEAD))
            {
                this.toss();
            }
            //picks flowers
            while (this.seesFlower(HERE))
            {
                this.pick();
            }
            this.hop();
        }
    }
    /**
     * This brings the jeroo to the ending location.
     */
    public void finalDestination()
    {
        this.clearMap();
        while (this.getGridY() != this.getWorld().getHeight() - 2 
            || this.getGridX() != this.getWorld().getWidth() - 2)
        {
            //navigate along the right side
            if (!this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
            //navigates dead ends
            if (this.seesWater(RIGHT) && this.seesWater(LEFT)
                && this.seesWater(AHEAD))
            {
                this.turn(RIGHT);
                this.turn(RIGHT);
            }
            //navigates unavoidable left turns
            if (this.seesWater(AHEAD) && this.seesWater(RIGHT))
            {
                this.turn(LEFT);
            }
            this.hop();
        }
    }
}

