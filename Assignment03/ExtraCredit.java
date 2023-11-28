import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * The class is designed for extra credit
 * The student implements the fibby method using iterative approach
 * and then benchmark with their recursive approach to draw conclusion
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
public class ExtraCredit
{
    /**
     * The method accepts non-negative integer and returns a value as described below
     * @param theDecimalNumber is a non-negative decimal number (n)
     * @return the value in following way:
     * - return 1 when n = 0
     * - return sum of fibby(floor(n/4)) and fibby(floor(3n/4)) when n > 0
     */
    public static int fibby(int theDecimalNumber) {
        if (theDecimalNumber == 0) {
            return 1;
        }
        int[] table = new int[theDecimalNumber + 1];
        table[0] = 1;

        for (int i = 1; i <= theDecimalNumber; ++i) {
            int firstArg = i / 4;
            int secondArg = (3 * i) / 4;
            table[i] = table[firstArg] + table[secondArg];
        }
        return table[theDecimalNumber];
    }

    public static void main(String args[])
    {
        int[] dataset = new int[]
                {
                        10, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, // small dataset
                        500, 1000, 1500, 2000, 2500, 5000, 7500, 10000, 12500, 15000, 17500, // medium dataset
                        25000, 50000, 75000, 100000, 200000, 500000, 1000000, 2000000 // large dataset
                };

        // sanity check the iterative fibby function
        if (fibby(1000000) != MathematicsRec.fibby(1000000))
        {
            System.err.println("Please make sure your iterative fibby correct before doing the benchmark");
            return;
        }

        long sum;
        int count;
        int attempts = 5;
        setContent("iterative_fibby.txt", "");
        setContent("recursive_fibby.txt", "");

        // benchmarking
        for (int value: dataset)
        {
            /**
             * The iterative fibby
             */
            fibby(value);

            // start benchmarking for each value
            sum = 0;
            count = attempts;
            while (count --> 0)
            {
                long startTime = System.nanoTime();
                fibby(value);
                long endTime = System.nanoTime();

                // get the difference
                sum += endTime - startTime;
            }
            // write out the execution time in nanoseconds (/1000000 in milliseconds)
            appendContent("iterative_fibby.txt", (double) sum / attempts + "\n");

            /**
             * The recursive fibby
             */
            MathematicsRec.fibby(value);

            // start benchmarking for each value
            sum = 0;
            count = attempts;
            while (count --> 0)
            {
                long startTime = System.nanoTime();
                MathematicsRec.fibby(value);
                long endTime = System.nanoTime();

                // get the difference
                sum += endTime - startTime;
            }
            // write out the execution time in nanoseconds (/1000000 in milliseconds)
            appendContent("recursive_fibby.txt", (double) sum / attempts + "\n");
        }
    }

    /**
     * The method writes content to file (overwrite if file is existed)
     * @param path the file along with the path
     * @param content the content is written to file
     */
    protected static void setContent(String path, String content) { setContent(new File(path), content); }
    protected static void setContent(File file, String content)
    {
        BufferedWriter bw;

        try
        {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.flush();
            bw.close();
        }
        catch (IOException ex) { System.err.println(ex.getMessage()); }
    }

    /**
     * The method appends content to file (overwrite if file is existed)
     * @param path the file along with the path
     * @param content the content is appended to file
     */
    protected static void appendContent(String path, String content) { appendContent(new File(path), content); }
    protected static void appendContent(File file, String content)
    {
        FileOutputStream fos;

        try
        {
            fos = new FileOutputStream(file, true);

            FileChannel channel = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes("UTF-8"));
            channel.write(buffer);
            channel.close();
        }
        catch (IOException ex) { System.err.println(ex.getMessage()); }
    }
}