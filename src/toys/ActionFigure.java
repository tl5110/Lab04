package toys;

/**
 * A concrete class that inherits from Doll.
 * Represents action figures.
 *
 * @author Tiffany Lee
 */
public class ActionFigure extends Doll{
    /** The action figure's product code. */
    private static int code = 500;
    /** The action figure's energy level. */
    private int energyLevel;
    /** The action figure's min and initial energy level. */
    final static int MIN_ENERGY_LEVEL= 1;
    /** The action figure's hair color, which is always orange. */
    final static Color HAIR_COLOR = Color.ORANGE;

    /**
     * Creates a new action figure with the passed name, age, and
     * spoken catchphrase. Additionally, there is a unique product code
     * that starts at 500 and increases by one each time a new one is
     * created.
     *
     * @param name the action figure's name
     * @param age the action figure's age
     * @param speak the action figure's spoken phrase
     */
    public ActionFigure(String name, int age, String speak) {
        super(code, name, HAIR_COLOR, age, speak);
        code += 1;
        this.energyLevel = MIN_ENERGY_LEVEL;
    }

    /**
     * Gets the action figure's energy level
     * @return the action figure's energy level
     */
    public int getEnergyLevel() {
        return energyLevel;
    }

    /**
     * The way an action figure is played with the passed amount of time,
     * with its energy level being multiplied by the time and increasing
     * by one until the action figure has reached or exceeded its
     * max happiness level.
     * Prints out the amount of time played with the type of toy, doll,
     * and action figure as well as a retired message when/if the action
     * figure reaches or exceeds its max happiness level.
     *
     * @param time number of minutes played with the toy
     */
    @Override
    protected void specialPlay(int time){
        System.out.println("\t" + super.getName() + " kung foo chops with "
                + getEnergyLevel()*time + " energy!");
        energyLevel += 1;
        super.specialPlay(time);
    }

    /**
     * Returns the string representation for an action figure, which
     * contains its product code, name, happiness level, whether it is
     * retired or not, its wear level, hair color, age, spoken catchphrase,
     * and energy level. For example, a non-retried action figure with the
     * product code 200, name of He-man, happiness level of 63, a wear level
     * of 60.0, orange hair color, age of thirty, spoken catchphrase
     * "By_the_power_of_Grayskull!", and energy level of 3 would return
     *      "Toy{PC:200, N:He-man, H:63, R:false, W:60.0},
     *       Doll{HC:ORANGE, A:30, S:By_the_power_of_Grayskull!},
     *       ActionFigure{E:3}"
     *
     * @return the string described above
     */
    @Override
    public String toString() {
        return super.toString() + ", ActionFigure{E:" + getEnergyLevel() + "}";
    }
}
