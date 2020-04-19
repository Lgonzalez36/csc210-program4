import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * MyGraph Implements Graph210 and Collects
 * the data to be used as Objects for 
 * the other Classes 
 * @author Luis Gonzalez 
 */
public class MyGraph   {
 

    

    public MyGraph() {
    }

	

	public void writeToFile(int[] edgeTo, double[] distTo, int numEdges2, int numVerts2) {
        double total_min_weight = 0.0;
        int numEdges = numEdges2;
        int numVerts = numVerts2;
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\luisg\\OneDrive\\Desktop\\Java\\Programs\\program04\\DATA\\GraphData.txt");
            myWriter.write(String.format("%d",numVerts));
            myWriter.write(System.lineSeparator()); //new line
            myWriter.write(String.format("%d",numEdges));
            myWriter.write(System.lineSeparator()); //new line
            for( int i = 0; i< numVerts; i++){
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