package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
* Driver class for the traveling salesperson problem. Takes in user file of x,y,z coordinates
* and parses into adjacency matrix/list. Sends on to method to solve with dynamic programming.
*/

public class TravelDriver{
	/**
	 * @param args - a file name containing a XYZ coordinates;first coordinate is starting point.
	 * @throws FileNotFoundException   
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//The file name is passed as an argument
		String fileName = args[0];
		File file = new File(fileName);
		if(file.exists()){

			Scanner scan = new Scanner(file);
			NodeList myPoints = new NodeList();
			boolean startFlag = true;
			
			while(scan.hasNextLine()) {
				//read in the transactions
				String point = scan.nextLine();
				StringTokenizer tok = new StringTokenizer(point, ":");
				//should only be 4 tokens...
				//add in error checking later!
				String name = tok.nextToken();
				double xpt = Double.parseDouble(tok.nextToken());
				double ypt = Double.parseDouble(tok.nextToken());
				double zpt = Double.parseDouble(tok.nextToken());
				
				Node newNode = new Node(name, xpt, ypt, zpt, startFlag);
				myPoints.add(newNode);
				startFlag = false;
			}
			scan.close();
			
			/*System.out.println("Original linked list:" );
			System.out.println( myPoints.toString());  
			*/
			
			//Create adjacency list and determine edge weights
			int n = myPoints.size();
			AdjacencyList myList = new AdjacencyList(n);	        
			myList.addAllEdges(myPoints);
			
			//using Nearest Neighbor method:
			Nearest nearPath = new Nearest();
			ArrayList<AdjNode> shortPath = nearPath.getNearestNeighbor(myList);
			System.out.println("\n\nNearest Neighbor method");
			double sumDistance = 0;
			for(AdjNode e: shortPath) {
				System.out.println(e.getInitial());
				sumDistance += e.getWeight();
			}
			AdjNode lastOne = shortPath.get(shortPath.size() -1 ); 
			System.out.print(lastOne.getDest());
			
			DecimalFormat numberFormat = new DecimalFormat("#.00");
			System.out.println("\n\nTotal distance " + numberFormat.format(sumDistance) );
			
			
			//using brute force method:
			Brute brutePath = new Brute();
			ArrayList<AdjNode> naivePath = brutePath.getNaivePath(myList);
			
			
		} else {
			System.err.println(file + " does not exists - please check the file path");
		}
	}
}