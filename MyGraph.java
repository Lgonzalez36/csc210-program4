import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/** 
 * MyGraph Writes final data to a file
 * @author Luis Gonzalez 
 */
public class MyGraph   {

    /**
     * Ctor of MyGraph
     */
    public MyGraph() {
    }

    /**
     * Method writes the given completed data to a file
     * Also keeps track of the total amount of distance in MST
     * @param edgeTo The vertex parent
     * @param distTo The weight between vertices
     * @param numEdges2 The Total amount of edges from given file
     * @param numVerts2 The Total amount of edges from given file
     */
	public void writeToFile(int[] edgeTo, double[] distTo, int numEdges, int numVerts) {
        double total_min_weight = 0.0;
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\luisg\\OneDrive\\Desktop\\Java\\Programs\\program04\\DATA\\GraphData.txt");
            myWriter.write(String.format("%d",numVerts));
            myWriter.write(System.lineSeparator()); //new line
            myWriter.write(String.format("%d",numEdges));
            myWriter.write(System.lineSeparator()); //new line
            for (int i = 0; i< numVerts; i++){
                myWriter.write(String.format("Edge: %d - %d   %.2f", i, edgeTo[i], distTo[i]));
                total_min_weight += distTo[i];
                myWriter.write(System.lineSeparator()); //new line

            }
            myWriter.write(String.format("Total minimum key:  %.2f", total_min_weight));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
     * Creates file to write data in
     * Will mention to console if file 
     * already exist, been created, or an error
     */
	public void createFile() {
        try {
            File myObj = new File("C:\\Users\\luisg\\OneDrive\\Desktop\\Java\\Programs\\program04\\DATA\\GraphData.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }
}