/*
* This program prints out
* the Magic Sqaures.
*
* @author  Jonathan Pasco-Arnone
* @version 1.0
* @since   2021-12-10
*/

final class MagicNumber {
    private MagicNumber() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }


    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;
    public static int done = 0;



    public static void genSquare(final int[] magicSquare, final int nextNumber) {
        // generate the magic sqaure
        final int theNumber = nextNumber + 1;
        final String theNumberStr = Integer.toString(theNumber);
        int[] theNumberArray = new int[NINE];

        // First, make the new number
        for (int counterOne = 0; counterOne < NINE; counterOne++) {
            theNumberArray[counterOne] =  Character.getNumericValue(theNumberStr.charAt(counterOne));
        }
        for (int counterFour = 0; counterFour < NINE; counterFour++) {
            magicSquare[counterFour] = theNumberArray[counterFour];
        }

        final boolean result = isMagic(magicSquare);

        if (result) {
            printMagicSquare(magicSquare);
        }
        genSquare(magicSquare, theNumber);
        
    }


    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];


        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }


    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }


    public static void main(final String[] args) {
        // main stub, get user input here
        int[] magicSquare = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        // The 111111110 represents all 9 slots of the square
        genSquare(magicSquare, 111111110);
    }
}
