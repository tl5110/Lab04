package toys;

/**
 * Abstract subclass of Toy.
 * Represents battery powered toys.
 *
 * @author Tiffany Lee
 */
public abstract class BatteryPowered extends Toy{
    /** The battery powered toy's battery level. */
    private int batteryLevel;
    /** The number of batteries in the battery powered toy. */
    private int numBatteries;
    /** The battery powered toy's initial fully charged battery level. */
    final static int FULLY_CHARGED = 100;
    /** The battery powered toy's depleted battery level. */
    final static int DEPLETED = 0;

    /**
     * Creates a battery powered toy with the passed product code, name, and
     * number of batteries.
     * @param productCode the battery powered toy's product code
     * @param name the battery powered toy's name
     * @param numBatteries the number of batteries in the battery powered toy
     */
    public BatteryPowered(int productCode, String name, int numBatteries) {
        super(productCode, name);
        this.batteryLevel = FULLY_CHARGED;
        this.numBatteries = numBatteries;
    }

    /**
     * Gets the battery powered toy's battery level.
     * @return the battery powered toy's battery level
     */
    public int getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Gets the number of batteries in the battery powered toy
     * @return the number of batters in the battery powered toy
     */
    public int getNumBatteries() {
        return numBatteries;
    }

    /**
     * When played, the battery level is reduced by the sum of
     * [time + number-of-batteries] until the battery level is capped at
     * DEPLETED and then after the battery level is restored to FULLY_CHARGED.
     * When the battery level is capped at DEPLETED a depletion message
     * is displayed. For example:
     *      DEPLETED:toy-toString
     * Afterwards a recharged message is displayed after the battery
     * level is restored to FULLY_CHARGED. For example:
     *      RECHARGED:toy-toString
     *
     * @param time number of minutes played with the toy
     */
    public void useBatteries(int time){
        batteryLevel -= (time + getNumBatteries());
        if(batteryLevel <= DEPLETED){
            batteryLevel = DEPLETED;
            System.out.println("\tDEPLETED:" + this);
            batteryLevel = FULLY_CHARGED;
            System.out.println("\tRECHARGED:" + this);
        }
    }

    /**
     * Returns the string representation for a battery powered toy, which
     * contains its product code, name, happiness level, whether it is
     * retired or not, its wear level, battery level, and number of batteries
     * in the battery powered toy. For example, a retired battery powered to
     * with a product code 300, name of Herbie, happiness level of 101, a wear
     * level of 45.0, battery level of 100, and 4 batteries would return
     * the following on one line:
     *      "Toy{PC:300, N:Herbie, H:101, R:true, W:45.0},
     *      BatteryPowered{BL:100, NB:4}"
     *
     * @return the string described above
     */
    @Override
    public String toString() {
        return super.toString() + ", BatteryPowered{BL:" + getBatteryLevel()
                + ", NB:" + getNumBatteries() + "}";
    }
}
