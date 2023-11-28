import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The main class of the program
 *
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
public class RadixSortMain {
    /**
     * The main method of the program
     *
     * @param theArguments the arguments of the program
     * @throws FileNotFoundException
     */
    public static void main(String[] theArguments) throws IOException {
        Deque<Integer> master = new LinkedDeque<Integer>();
        readFileIntoDeque("input100.txt", master);
        RadixSort.sort(master);
        writeDequeToFile("output100.txt", master);
    }

    /**
     * The method reads all elements from the input file into queue
     *
     * @param filename the input file
     * @param queue    the queue
     * @throws FileNotFoundException
     */
    public static void readFileIntoDeque(String filename, Deque<Integer> queue) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        while (scan.hasNext()) {
            int num = scan.nextInt();
            queue.addFront(num);
        }
        scan.close();
    }

    /**
     * The method removes all elements in queue and writes them to output file
     *
     * @param filename the output file name
     * @param queue    the queue
     * @throws FileNotFoundException
     */
    public static void writeDequeToFile(String filename, Deque<Integer> queue) throws IOException {
        PrintStream ps = new PrintStream(new File(filename));
        while (!queue.isEmpty()) {
            ps.println(queue.removeFront().toString());
        }
    }
}
