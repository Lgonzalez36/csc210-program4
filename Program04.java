import java.io.IOException;

/**
 * The main() class for Program04, CSC 210 Spring 2020.
 * 
 * Including this, just to make sure the code we share compiles and runs (and
 * does nothing).
 * 
 * @author Prof Bill
 */
public class Program04 {
  /**
   * This main() method just says hello.
   * 
   * @param args unused
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    System.out.println( "Hello, P4");
        /**
         * Ctor for Freq
         */
        ReadText run = new ReadText();
        run.readTxt();
    }
}
