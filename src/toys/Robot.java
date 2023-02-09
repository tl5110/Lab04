package toys;

/**
 * A concrete class that inherits from BatteryPowered.
 * Represents Robots.
 *
 * @author Tiffany Lee
 */
public class Robot extends BatteryPowered{
    /** The robot's product code. */
    private static int code = 400;
    /** Is the robot flying? */
    private boolean flying;
    /** The robot's distance. */
    private int distance;
    /** The robot's flying speed. */
    final static int FLY_SPEED = 25;
    /** The robot's running speed. */
    final static int RUN_SPEED = 10;
    /** The robot's initial flying or running speed. */
    final static int INITIAL_SPEED = 0;

    /**
     * Creates a new Robot that takes the passed name, number of batteries,
     * and whether it flies or not. Additionally, there is a unique product
     * code that starts at 400 and increases by one each time a new one is
     * created. The distance is also set to the INITIAL_SPEED.
     *
     * @param name the name of the robot
     * @param numBatteries the number of batteries of the robot
     * @param flying whether the robot flies
     */
    protected Robot(String name, int numBatteries, boolean flying) {
        super(code, name, numBatteries);
        code += 1;
        this.flying = flying;
        this.distance = INITIAL_SPEED;
    }

    /**
     * Does the Robot fly?
     * @return true if it flies, false otherwise
     */
    public boolean isFlying() {
        return flying;
    }

    /**
     * Gets the total distance the Robot travels.
     * @return the total distance the Robot travels
     */
    public int getDistance() {
        return distance;
    }

    /**
     * The way Robot is played with the passed amount of time. If the robot
     * flies its distance is increase by the product of [time*FLY_SPEED] and
     * prints out the name and distance traveled by the robot vis FLY_SPEED.
     * Otherwise, the robot's distance is increased by the product of
     * [time*RUN_SPEED] and prints out the name and distance traveled by
     * the robot via RUN_SPEED. The batteries are used for teh amount of time
     * regardless of whether the robot flies or not.
     *
     * @param time number of minutes played with the toy
     */
    @Override
    protected void specialPlay(int time){
        if(isFlying()) {
            distance += (time * FLY_SPEED);
            System.out.println("\t" + getName() + " is flying around with "
                    + "total distance: " + getDistance());
            increaseWear(FLY_SPEED);
        } else {
            distance += (time*RUN_SPEED);
            System.out.println("\t" + getName() + " is running around with "
                    + "total distance: " + getDistance());
            increaseWear(RUN_SPEED);
        }
        useBatteries(time);
    }

    /**
     * Returns the string representation for a Robot, which
     * contains its product code, name, happiness level, whether it is
     * retired or not, its wear level, battery level, number of batteries,
     * whether it flies or not, and distance. For example, a retried
     * Robot with the product code 403, name of IronGiant, happiness level
     * of 73, a wear level of 50.0, battery level of 3, 12 batteries,
     * ablity to fly, and distance of 1825 would return
     *      "Toy{PC:403, N:IronGiant, H:73, R:false, W:50.0},
     *      BatteryPowered{BL:3, NB:12}, Robot(F:true, D:1825}"
     *
     * @return the string described above
     */
    @Override
    public String toString() {
        return super.toString() + ", Robot{F:" + isFlying() + ", D:"
                + getDistance() + "}";
    }
}
