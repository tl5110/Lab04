package toys;

/**
 * A concrete class that inherits from Toy.
 * Represents different types of dolls.
 *
 * @author Tiffany Lee
 */
public class Doll extends Toy{
    /** The doll's product code. */
    private static int code = 200;
    /** The doll's hair color. */
    private Color hairColor;
    /** The doll's age. */
    private int age;
    /** The doll's spoken catchphrase. */
    private String speak;

    /**
     * Creates a new doll with the passed name, hair color, age, and
     * spoken catchphrase. Additionally, there is a unique product code
     * that starts at 200 and increases by one each time a new one is
     * created.
     *
     * @param name the doll's name
     * @param hairColor the doll's hair color
     * @param age the doll's age
     * @param speak the doll's spoken catchphrase
     */
    protected Doll(String name, Color hairColor, int age, String speak) {
        super(code, name);
        code += 1;
        this.hairColor = hairColor;
        this.age = age;
        this.speak = speak;
    }

    /**
     * Creates a new doll with the passed product code, name, hair color,
     * age, and spoken catchphrase.
     *
     * @param productCode the doll's product code
     * @param name the doll's name
     * @param hairColor to doll's hair color
     * @param age the doll's age
     * @param speak the doll's spoken catchphrase
     */
    protected Doll(int productCode, String name, Color hairColor, int age, String speak) {
        super(productCode, name);
        this.hairColor = hairColor;
        this.age = age;
        this.speak = speak;
    }

    /**
     * Gets the doll's hair color.
     * @return the hair color
     */
    public Color getHairColor() {
        return this.hairColor;
    }

    /**
     * Gets the doll's age.
     * @return the doll's age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the doll's catchphrase
     * @return the doll's catchphrase
     */
    public String getSpeak() {
        return this.speak;
    }

    /**
     * The way a doll is played with the passed amount of time, with
     * its happiness level increasing by its age until the kite has
     * reached or exceeded its max happiness level.
     * Prints out the amount of time played with the type of toy and doll
     * as well as a retired message when/if the doll reaches or exceeds
     * its max happiness level.
     *
     * @param time number of minutes played with the toy
     */
    @Override
    protected void specialPlay(int time){
        System.out.println("\t" + super.getName() + " brushes their "
                + getHairColor() + " hair and says, " + "\""
                + getSpeak() +"\"");
        increaseWear(age);
    }

    /**
     * Returns the string representation for a doll, which contains its
     * product code, name, happiness level, whether it is retired or not,
     * its wear level, hair color, age, and spoken catchphrase. For example,
     * a retried doll with the product code 200, name of GabbyGabby,
     * happiness level of 101, a wear level of 18.0, red hair color,
     * age of six, and spoken catchphrase "Will_you_be_my_friend?" would
     * return
     * "Toy{PC:200, N:GabbyGabby, H:101, R:true, W:18.0}, Doll{HC:RED, A:6, S:Will_you_be_my_friend?}"
     *
     * @return the string described above
     */
    @Override
    public String toString(){
        return super.toString() + ", Doll{HC:" + getHairColor() + ", A:"
                + getAge() + ", S:" + getSpeak()+ "}";
    }
}
