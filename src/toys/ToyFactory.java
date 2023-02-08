package toys;

/**
 * The ToyFactory follows the "factory method pattern" and is used to create
 * and return new toys.
 *
 * @author RIT CS
 */
public class ToyFactory {
    /** The types of toys */
    private enum ToyType {
        ACTION_FIGURE,
        DOLL,
        KITE,
        RC_BOAT,
        ROBOT
    }

    /**
     * Given a line of toy data, create and return the specific type of toy.
     *
     * @param toyLine a line of data from the toy data file
     * @return a new IToy
     */
    public static IToy makeToy(String toyLine) {
        String[] fields = toyLine.split("\\s++");
        switch (ToyType.valueOf(fields[0])) {
            case KITE -> {
                return new Kite(fields[1], Color.valueOf(fields[2]), Kite.Type.valueOf(fields[3]));
            }
            case DOLL -> {
                return new Doll(fields[1], Color.valueOf(fields[2]), Integer.parseInt(fields[3]), fields[4]);
            }
            case ACTION_FIGURE -> {
                return new ActionFigure(fields[1], Integer.parseInt(fields[2]), fields[3]);
            }
            case RC_BOAT -> {
                return new RCBoat(fields[1], Integer.parseInt(fields[2]));
            }
            case ROBOT -> {
                return new Robot(fields[1], Integer.parseInt(fields[2]), Boolean.parseBoolean(fields[3]));
            }
            default -> {
                System.out.println("Unrecognized toy: " + toyLine);
                return null;
            }
        }
    }
}
