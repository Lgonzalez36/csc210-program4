import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
public class ReadText {
    
    public ReadText(){
    }

    MST compute = new MST();
    final String DELIMS = "[ ]+";
    private int numVerts;
    private int numEdges;

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

    public void file(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        line = read.readLine();
        numVerts = Integer.parseInt(line);
        line = read.readLine();
        numEdges = Integer.parseInt(line);

        AdjacencyList adj = new AdjacencyList(numVerts);

        while ((line = read.readLine()) != null) {
            String[] tokens = line.split(DELIMS);
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);
            Double weight = Double.parseDouble(tokens[2]);
            adj.addEdgeAdj(v1, v2, weight);
            
        }
        read.close();
        adj.printGraph();
        MyGraph g = new MyGraph(numVerts, numEdges, adj);
        compute.PrimMST(g);
    }
}
