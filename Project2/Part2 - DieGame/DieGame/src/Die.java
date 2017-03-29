import java.util.Random;

/**
 * Program that is simulating Dice with Objects
 * This is service class
 *
 * @version: 10/11/14
 */
public class Die
{
    // These two statements declare two instance variables: numberOfSides and face
    // The numberOfSides field will hold the number of sides that the die has.
    // The face field will hold the value of face that was last rolled
    private int numberOfSides;
    private int face;
    // This constant holds the default value of number of sides
    private final int DEFAULT_SIDES = 6;

    /**
     * The constructor creates the die object and performs the initial
     * roll of the die
     *
     * @param numberOfSides the number of sides for this die
     */
    public Die(int numberOfSides)
    {
        // This is a constructor. Notice that the constructor has a parameter
        // for the number of sides that is passed by the client. Since the input must
        // be validated constructor calls the mutator method setNumberOfSides to set the value
        // of the numberOfSides field. The value of the face field is generated and set
        // by the roll method
        setNumberOfSides(numberOfSides);
        roll();
    }

    /**
     * Mutator method
     * Validates that the passed numberOfSides is either:
     * four, six, eight,  ten, twelve, or twenty sides.
     * If not sets to the default value
     *
     * @param numberOfSides
     */
    public void setNumberOfSides(int numberOfSides)
    {
        // This is a mutator method for the numberOfSides field.
        // It validates the input first. If the input is valid
        // uses it to set the value of numberOfSides field. If the input
        // is invalid sets the numberOfSides field to DEFAULT_SIDES
        switch (numberOfSides)
        {
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
            case 20:
                this.numberOfSides = numberOfSides;
                break;
            default:
                this.numberOfSides = DEFAULT_SIDES;
                break;
        }
    }

    /**
     * Accessor method
     *
     * @return the current value of sides
     */
    public int getNumberOfSides()
    {
        return this.numberOfSides;
    }

    /**
     * Mutator method
     * Generates randomly the face of the roll of the die
     */
    public void roll()
    {
        // This is a mutator method for the face field. First it creates a Random object
        // which is referenced by the rand variable. It uses the rand object to get
        // a random number that is in the appropriate range for this particular die.
        // For example, if the field numberOfSides is set to 6, field face will be set to an integer
        // in the range of 1 through 6
        Random rand = new Random();
        this.face = rand.nextInt(this.numberOfSides) + 1;
    }

    /**
     * Accessor method
     *
     * @return the current face of the roll of the die
     */
    public int getFace()
    {
        return this.face;
    }
}
