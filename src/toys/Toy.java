package toys;

/**
 * Represents all types of toys
 *
 * @author Tiffany Lee
 */
public abstract class Toy implements IToy{
    /** The toy's product code. */
    private int productCode;
    /** The toy's name. */
    private String name;
    /** The toy's happiness level. */
    private int happiness;
    /** The toy's wear level. */
    private double wear;
    /** The toy's initial happiness level. */
    final static int INITIAL_HAPPINESS = 0;
    /** The toy's max happiness level. */
    final static int MAX_HAPPINESS = 100;
    /** The toy's initial wear level. */
    final static double INITIAL_WEAR = 0.0;

    /**
     * Creates a new toy with the passed product and name,
     * and an initial happiness and wear level
     *
     * @param productCode the toy's product code
     * @param name the toy's name
     */
    protected Toy(int productCode, String name) {
        this.productCode = productCode;
        this.name = name;
        this.happiness = INITIAL_HAPPINESS;
        this.wear = INITIAL_WEAR;
    }

    /**
     * Gets the product code for this toy.
     *
     * @return the toy's product code
     */
    public int getProductCode() {
        return this.productCode;
    }

    /**
     * Gets the name for this toy.
     *
     * @return the toy's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the happiness level for this toy.
     *
     * @return the toy's happiness level
     */
    public int getHappiness() {
        return this.happiness;
    }

    /**
     * Has the toy reached or exceed its max level of happiness and retired?
     *
     * @return true if the toy has reached and/or gone past its max level
     * of happiness, false otherwise
     */
    public boolean isRetired(){
        return this.happiness >= MAX_HAPPINESS;
    }

    /**
     * Gets the wear level for this toy.
     *
     * @return the toy's wear level
     */
    public double getWear() {
        return this.wear;
    }

    /** Increases the wear level of the toy by the amount passed in. */
    public void increaseWear(double amount) {
        this.wear += amount;
    }

    /**
     * The toy is played with the passed amount of time and, no matter
     * the type of toy, its happiness level increases uniformly until
     * the happiness level of the toy has reached or exceeded its
     * max happiness level.
     * Prints out the amount of time played with the type of toy and a
     * retired message when/if the toy reaches or exceeds its max happiness
     * level.
     */
    public void play(int time) {
        System.out.println("\tPLAYING(" + time + "): " + this);
        specialPlay(time);
        this.happiness += time;
        if(isRetired()){
            System.out.println("RETIRED: " + this);
        }
    }

    /**
     * A toy's specified behavior when being played with
     *
     * @param time number of minutes played with the toy
     */
    protected abstract void specialPlay(int time);

    /**
     * Returns the string representation for a toy, which contains its
     * product code, name, happiness level, whether it is retired or not,
     * and its wear level. For example, a non-retried kite with the
     * product code 100, name of Cometa, happiness level of 40, and a
     * wear level of 2.0 would return
     * "Toy{PC:100, N:Cometa, H:0, R:false, W:0.0}"
     *
     * @return the string described above
     */
    @Override
    public String toString(){
        return "Toy{PC:" + getProductCode() + ", N:" + getName() + ", H:"
                + getHappiness() + ", R:" + isRetired() + ", W:"
                + getWear() + "}";
    }

}
