import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Reads in configurations of potential solutions to Skyscraper puzzles and
 * evaluates their validity before printing out both the grids and their status
 * as an answer to the puzzles.
 *
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 * @version final
 */
public class Skyscraper {
    private static int myRows = 6;
    private static int myCols = 6;
    /**
     * The driver method to process Skyscraper puzzle settings
     * The task is to check their validity and then print the grids along with the results of those checks.
     *
     * @param theArgs is used for command line input.
     */
    public static void main(final String[] theArgs) throws FileNotFoundException {
        if (theArgs.length != 1) {
            System.out.println("ERROR: Program must be run using the name of an input file that "
                    + "contains Skyscraper information as a command line argument.");
        }
        else {
            // START FILLING YOUR CODE HERE
            Scanner scan = new Scanner(new File(theArgs[0]));
            while (scan.hasNext()) {
                int[][] skyscrapers = getSkyscrapers(scan);
                boolean isValid = validateSkyscrapers(skyscrapers);
                printSkyscrapers(skyscrapers, isValid);
            }
            scan.close();
        }
        // END FILLING YOUR CODE HERE

        System.out.println("COMPLETED PROCESSING SKYSCRAPERS");

    }
    /**
     *
     * This function takes the file and creates the puzzle board within a
     * 6x6 2D Integer array using the numbers found within the file.
     *
     * @param input		this is the file input that should consist of
     *                  numbers representing the game: Skyscraper
     *
     * @return			returns a 6x6 2D integer array representing the
     * 					full Skyscraper game board.
     */
    public static int[][] getSkyscrapers(final Scanner input) {
        int[][] fullSkyscraperBoard = new int[myRows][myCols];
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myCols; j++) {
                if ((i == 0 && (j == 0 || j == 5)) || (i == 5 && (j == 0 || j == 5))) {
                    fullSkyscraperBoard[i][j] = 0;
                } else {
                    fullSkyscraperBoard[i][j] = input.nextInt();
                }
            }
        }
        return fullSkyscraperBoard;
    }
    /**
     *
     * This takes the 6x6 puzzle board array and creates
     * a 4x4 array with the clue numbers. The column clues
     * are the 1st and 2nd rows and the row clues are the
     * 3rd and 4th rows.
     *
     * @param theFullSkyscrapers	this is a 6x6 2D integer array representing the
     *                              full puzzle board for the game: Skyscrapers.
     *                              It consists of clue numbers and Skyscraper numbers.
     *
     * @return						returns a 4x4 2D integer array consisting of the outer
     * 								"clue" numbers in the original 6x6.
     */
    public static int[][] getClues(final int[][] theFullSkyscrapers) {
        int[][] clues = new int[myRows-2][myCols-2];
        for (int i = 1; i < myRows - 1; i++) {
            clues[0][i-1]=theFullSkyscrapers[0][i];
            clues[1][i-1]=theFullSkyscrapers[5][i];
            clues[2][i-1]=theFullSkyscrapers[i][0];
            clues[3][i-1]=theFullSkyscrapers[i][5];
        }
        return clues;
    }
    /**
     *
     * This takes the 6x6 puzzle board array and
     * creates a 4x4 array with the Skyscraper numbers
     *
     * @param theFullSkyscrapers	this is a 6x6 2D integer array representing the
     *                              full puzzle board for the game: Skyscrapers.
     *                              It consists of clue numbers and Skyscraper numbers.
     *
     * @return 						returns a 4x4 2D integer array consisting of the
     * 								inner 4x4 representing the Skyscrapers
     */
    public static int[][] getSkyscrapersBoard(final int[][] theFullSkyscrapers) {
        int[][] gameBoard = new int[myRows-2][myCols-2];
        for (int i = 1; i < myRows - 1; i++) {
            for (int j = 1; j < myCols - 1; j++) {
                gameBoard[i-1][j-1] = theFullSkyscrapers[i][j];
            }
        }
        return gameBoard;
    }
    /**
     *
     *	This function validates the board by checking if
     *	there are any duplicate numbers and if the clue
     *	numbers are valid to their respective row/column.
     *
     * @param theFullSkyscrapers	this is a 6x6 2D integer array representing the
     *                              full puzzle board for the game: Skyscrapers.
     *                              It consists of clue numbers and Skyscraper numbers.
     *
     * @return					 returns true if the duplicate check returns false and the
     * 							 clue check returns true.
     */
    public static boolean validateSkyscrapers(final int[][] theFullSkyscrapers) {
        int[][] theSkyscrapersBoard = getSkyscrapersBoard(theFullSkyscrapers);
        int[][] theClues = getClues(theFullSkyscrapers);

        if(hasDuplicate(theSkyscrapersBoard)) {
            return false;
        }
        if(clueCheck(theSkyscrapersBoard, theClues)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * This is the logic finding out if the Skyscraper numbers
     * have any duplicates in any of the rows/columns.
     *
     * @param theSkyscrapers	is a 4x4 2D integer array representing the Skyscrapers that
     *                          correspond to the clue numbers.
     *
     * @return					returns true if a duplicate is found, otherwise return false.
     */
    public static boolean hasDuplicate(final int[][] theSkyscrapers) {
        int rows=myRows-2;
        int cols=myCols-2;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols - 1; j++) {
                for (int k = j + 1; k < cols; k++) {
                    if(theSkyscrapers[i][j] == theSkyscrapers[i][k]) {
                        return true;
                    }
                }
            }
        }
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows - 1; j++) {
                for (int k = j + 1; k < cols; k++) {
                    if(theSkyscrapers[i][j] == theSkyscrapers[i][k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    /**
     * This is the logic to check if the clue numbers are valid.
     *
     * @param theSkyscrapers     is a 4x4 2D integer array representing the Skyscrapers that
     *                           correspond to the clue numbers.
     *
     * @param theClues			 is a 4x4 2D integer array representing the clue numbers that
     *                           tell you how many skyscrapers one could see.
     *
     * @return                   if all row/column is valid return true, otherwise return false.
     *
     */
    public static boolean clueCheck(final int[][] theSkyscrapers, final int[][] theClues) {
        int rows=myRows-2;
        int cols=myCols-2;
        boolean isRowValid = false;
        boolean isColValid = false;


        for(int i = 0; i < cols; i++) {
            int count1 = 1;
            int count2 = 1;
            int clue1=theClues[2][i];
            int clue2=theClues[3][i];
            for(int j = 0; j < rows; j++) {
                if(theSkyscrapers[i][j] > theSkyscrapers[i][0]) {
                    count1++;
                    if(theSkyscrapers[i][j] == 4) {
                        break;
                    }
                }
            }
            if((theSkyscrapers[i][0] == 1) && (theSkyscrapers[i][1] == 3) && (theSkyscrapers[i][2] == 2)) {
                count1--;
            }
            for(int j = rows-1; j >= 0; j--) {
                if(theSkyscrapers[i][j] > theSkyscrapers[i][3]) {
                    count2++;
                    if(theSkyscrapers[i][j] == 4) {
                        break;
                    }
                }
            }
            if((theSkyscrapers[i][3] == 1) && (theSkyscrapers[i][2] == 3) && (theSkyscrapers[i][1] == 2)) {
                count2--;
            }
            isRowValid = (count1 == clue1) && (count2 == clue2);
        }

        for(int i = 0; i < rows; i++) {
            int count1 = 1;
            int count2 = 1;
            int clue1=theClues[0][i];
            int clue2=theClues[1][i];
            for(int j = 0; j < cols; j++) {
                if(theSkyscrapers[j][i] > theSkyscrapers[0][i]) {
                    count1++;
                    if(theSkyscrapers[j][i] == 4) {
                        break;
                    }
                }
            }
            if((theSkyscrapers[0][i] == 1) && (theSkyscrapers[1][i] == 3) && (theSkyscrapers[2][i] == 2)) {
                count1--;
            }
            for(int j = cols-1; j >= 0; j--) {
                if(theSkyscrapers[j][i] > theSkyscrapers[3][i]) {
                    count2++;
                    if(theSkyscrapers[j][i] == 4) {
                        break;
                    }
                }
            }
            if((theSkyscrapers[3][i] == 1) && (theSkyscrapers[2][i] == 3) && (theSkyscrapers[1][i] == 2)) {
                count1--;
            }
            isColValid = (count1 == clue1) && (count2 == clue2);
        }
        return isRowValid && isColValid;
    }
    /**
     * Prints the Skyscraper puzzle configuration and whether it is valid or not as
     * a solution.
     *
     * @param theGrid     is a 2D integer array representing a configuration of
     *                    integers as a potential answer to a Skyscraper puzzle.
     * @param theValidity is a boolean value representing whether the 2D integer
     *                    array is an acceptable solution or not.
     */
    public static void printSkyscrapers(final int[][] theGrid, final boolean theValidity)
    {
        final StringBuilder sb = new StringBuilder();
        for (int row = 0; row < theGrid.length; row++)
        {
            for (int col = 0; col < theGrid[0].length; col++)
            {
                if (theGrid[row][col] == 0)
                {
                    sb.append(" ");
                }
                else
                {
                    sb.append(theGrid[row][col]);
                }
            }
            sb.append("\n");
        }
        if (theValidity)
        {
            sb.append("VALID");
        }
        else
        {
            sb.append("NOT VALID");
        }
        System.out.println(sb.toString());
    }
}