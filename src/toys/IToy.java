package toys;

/**
 * An interface for the public behaviors of Toy.
 *
 * @author Tiffany Lee
 */
public interface IToy {
    /**
     * Gets the product code of a toy
     * @return the product code of a toy
     */
    public int getProductCode();

    /**
     * Gets the name of a toy
     * @return the name of a toy
     */
    public String getName();

    /**
     * Gets the happiness level of a toy
     * @return the happiness level of a toy
     */
    public int getHappiness();

    /**
     * Checks if the toy is retired or not; in other words
     * it checks if the toy has reached or exceeded its happiness level
     * @return true if retired, false otherwise
     */
    public boolean isRetired();

    /**
     * Gets the wear level of a toy
     * @return the wear level of a toy
     */
    public double getWear();

    /** Increases the wear level of a toy by the amount passed in. */
    public void increaseWear(double amount);

    /**
     * A toy is played with the passed amount of time and, no matter
     * the type of toy, its happiness level increases uniformly until
     * the happiness level of the toy has reached or exceeded its
     * max happiness level.
     * Prints out the amount of time played with the type of toy and a
     * retired message when/if the toy reaches or exceeds its max happiness
     * level.
     */
    public void play(int time);

}
