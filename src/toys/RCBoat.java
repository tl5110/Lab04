package toys;

/**
 * A concrete class that inherits from BatteryPowered.
 * Represents RC boats.
 *
 * @author Tiffany Lee
 */
public class RCBoat extends BatteryPowered{
    /** The RC boat's product code. */
    private static int code = 300;
    /** The RC boat's speed. */
    private static int speed;
    /** The RC boat's starting speed. */
    final static int STARTING_SPEED = 10;
    /** The amount in which the RC boat's speed increases. */
    final static int SPEED_INCREASE = 5;

    /**
     * Creates a new RC Boat that takes the passed name and number of batteries.
     * Additionally, there is a unique product code that starts at 300 and
     * increases by one each time a new one is created. The speed is also
     * set to the STARTING_SPEED.
     *
     * @param name the name of the RC Boat
     * @param numBatteries the number of batteries in the RC Boat
     */
    protected RCBoat(String name, int numBatteries) {
        super(code, name, numBatteries);
        code += 1;
        speed = STARTING_SPEED;
    }

    /**
     * Gets the speed of the RC Boat
     * @return the speed of the RC Boat
     */
    public static int getSpeed() {
        return speed;
    }

    /**
     * The way RC Boat is played with the passed amount of time,
     * with its batteries used for the amount of time, the wear increasing
     * by the current speed, and the speed increasing by the SPEED_INCREASE.
     * Prints out the name and speed of the RC Boat.
     *
     * @param time number of minutes played with the toy
     */
    @Override
    protected void specialPlay(int time){
        System.out.println("\t" + getName() + " races around at "
                + getSpeed() + "knots!");
        useBatteries(time);
        increaseWear(getSpeed());
        speed += SPEED_INCREASE;
    }

    /**
     * Returns the string representation for a RC Boat, which
     * contains its product code, name, happiness level, whether it is
     * retired or not, its wear level, battery level, number of batteries,
     * and speed. For example, a non-retried RC Boat with the product code
     * 300, name of BlackPearl, happiness level of 40, a wear level of 10.0,
     * battery level of 56, 4 batteries, and speed of 15 would return
     *      "Toy{PC:300, N:BlackPearl, H:40, R:false, W:10.0},
     *      BatteryPowered{BL:56, NB:4}, RCBoat(S:15}"
     *
     * @return the string described above
     */
    @Override
    public String toString() {
        return super.toString() + ", RCBoat{S:" + getSpeed() + "}";
    }
}
