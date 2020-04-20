import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
/** 
 * ReadText has a menue and has a user
 * select a file to read and proccess
 * @author Luis Gonzalez 
 */
public class ReadText {
    /** Final delims to extract only vertices */
    final String DELIMS = "[ ]+";
    /** Class variable to store total numbers of vertices */
    private int numVerts;
    /** Class variable to store total numbers of edges */
    private int numEdges;

    /**
     * Ctor for the main menue
     */
    public ReadText(){
    }

    /**
     * Method to read the a file from user input
     * then the file ULR will send it to the next method
     * Will loop until user wants to exit
     * files are found online and are not stored
     * @throws IOException
     */
	public void readTxt() throws IOException {
        while (true){
            System.out.println();
            System.out.println("We will read a file and find its MST from Prim's algorithm     ");
            System.out.println("Pick one of the five files to find its MST                     ");
            System.out.println("********************Main Menu**********************************");
            System.out.println("File 1 contains 8 vertices and 16 edges---------------------(1)");
            System.out.println("File 2 contains 250 vertices and 1,273 edges----------------(2)");
            System.out.println("File 3 contains 1,000 vertices and 8,433 edges--------------(3)");
            System.out.println("File 4 contains 10,000 vertices and 61,731 edges------------(4)");
            System.out.println("File 5 contains one million vertices and 7,586,063 edges----(5)");
            System.out.println("Exit Program04 :( ------------------------------------------(6)");
            System.out.println("***************************************************************");

            Scanner scanner = new Scanner(System.in);
            int commands = scanner.nextInt();
            
            System.out.println("------------------------------------------------------------------------------------------");

            if (commands == 1){
                String urlString1 = "https://algs4.cs.princeton.edu/43mst/tinyEWG.txt";
                file(urlString1);
            }
            else if (commands == 2){ 
                String urlString2 = "https://algs4.cs.princeton.edu/43mst/mediumEWG.txt";
                file(urlString2);
            }
            else if (commands == 3){
                String urlString3 = "https://algs4.cs.princeton.edu/43mst/1000EWG.txt";
                file(urlString3);
            }
            else if (commands == 4){
                String urlString4 = "https://algs4.cs.princeton.edu/43mst/10000EWG.txt";
                file(urlString4);
            }
            else if (commands == 5){
                String urlString5 = "https://algs4.cs.princeton.edu/43mst/largeEWG.txt";
                file(urlString5);
            }
            else if (commands == 6){
                break;
            }
            System.out.println("------------------------------------------------------------------------------------------");
        }
	}

    /**
     * Gets file and reads it line by line and sends info to 
     * The first two lines are to read the number of Verts and Edges first
     * then the rest of the data is automated
     * the AdjacencyList Class for further processing
     * After file is read, data is sent to MST Class
     * @param urlString
     * @throws IOException
     */
    public void file(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
        AdjacencyList adj = new AdjacencyList();
        String line;
        line = read.readLine();
        numVerts = Integer.parseInt(line);
        line = read.readLine();
        numEdges = Integer.parseInt(line);
        adj.makeAdjList(numVerts);

        while ((line = read.readLine()) != null) {
            String[] tokens = line.split(DELIMS);
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);
            Double weight = Double.parseDouble(tokens[2]);
            adj.addEdgeAdj(v1, v2, weight);
        }
        read.close();
        spin();
        MST compute = new MST(numVerts, numEdges, adj);
        compute.PrimMST();
    }

    /**
     * Method maks a cool loading effect
     */
    public void spin() {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};
    
        for (int i = 0; i <= 100; i++) {
            System.out.print("  Processing Data: " + i + "% " + animationChars[i % 4] + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // https://kodejava.org/how-do-i-create-a-console-progress-bar/
    }
}
