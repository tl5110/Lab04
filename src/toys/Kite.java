package toys;

/**
 * Concrete class that inherits from Toy.
 * Represents different types of kites
 *
 * @author Tiffany Lee
 */
public class Kite extends Toy{
    /**
     * An enumerated type for some common type of kites.
     * To specify a type, e.g. DIAMOND:  Type.DIAMOND;
     * When displayed to standard output, the toString(): "DIAMOND"
     */
    public enum Type{
        CELLULAR,
        DELTA,
        DIAMOND,
        PARAFOIL,
        ROKKAKUS,
        SLED,
        STUNT
    }
    /** The kite's product code. */
    private static int code = 100;
    /** The kite's color. */
    private final Color color;
    /** The kite's type. */
    private final Type type;
    /**
     * How much a kite's wear level increases with this factor of the
     * time it was played with.
     */
    final static double WEAR_MULTIPLIER = 0.05;

    /**
     * Creates a new kite with the passed name, color, and type
     * along with its unique product code, which starts at 100 and
     * increases by one each time a new one is created
     *
     * @param name the name of the kite
     * @param color the color of the kite
     * @param type the type of kite
     */
    protected Kite(String name, Color color, Type type) {
        super(code, name);
        code += 1;
        this.color = color;
        this.type = type;
    }

    /**
     * Gets the color of the kite
     *
     * @return the color of the kite
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the type of the kite
     *
     * @return the type of kite
     */
    public Type getType() {
        return type;
    }

    /**
     * Prints out the amount of time played with the type of toy/kite
     * or a retired message when/if the kite reaches or exceeds
     * its max happiness level. For example:
     *      "PLAYING(40): Toy{PC:100, N:Cometa, H:0, R:false, W:0.0}, Kite{C:GREEN, T:DELTA}"
     *      or
     *      "RETIRED: Toy{PC:100, N:Cometa, H:101, R:true, W:5.050000000000001}, Kite{C:GREEN, T:DELTA}"
     * The way a kite is played with the passed amount of time, with
     * its happiness level increasing by multiple of WEAR_MULTIPLIER
     * multiplied by the passed time until the kite has reached or
     * exceeded its max happiness level.
     *
     * @param time number of minutes played with the toy
     */
    @Override
    protected void specialPlay(int time){
        System.out.println("\tFlying the " + getColor() + ", " + getType()
                + " kite " + super.getName());
        super.increaseWear(time*WEAR_MULTIPLIER);
    }

    /**
     * Returns the string representation for a kite, which contains its
     * product code, name, happiness level, whether it is retired or not,
     * its wear level, color, and type. For example, a non-retried kite
     * with the product code 100, name of Cometa, happiness level of 40,
     * a wear level of 2.0, color green, and type delta would return
     *      "Toy{PC:100, N:Cometa, H:0, R:false, W:0.0}, Kite{C:GREEN, T:DELTA}"
     *
     * @return the string described above
     */
    @Override
    public String toString(){
        return super.toString() + ", Kite{C:" + getColor() + ", T:"
                + getType() + "}";
    }
}
