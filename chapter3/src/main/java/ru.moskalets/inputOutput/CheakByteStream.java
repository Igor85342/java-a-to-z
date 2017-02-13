package ru.moskalets.inputOutput;
import java.io.*;

/**
 * CheakByteStream - checks whether the number is in the thread even.
 * @author Igor Moskalets
 * @since 12.02.2017
 */
public class CheakByteStream {
    /**
     * Method checks whether the number is in the thread even.
     * @param InputStream in.
     * @return bollean result.
     */
    public boolean isNumber(InputStream in) throws IOException {

        int number;
        boolean result = false;
        BufferedReader br = new BufferedReader (new InputStreamReader(in));
        try  {
            number = br.read();
            if (number % 2 == 0) {
                result = true;
            }
        }
        catch (IOException e) {
        }
        finally {
            br.close();
        }
        return result;
    }
}
