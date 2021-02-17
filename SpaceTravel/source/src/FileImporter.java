package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Scans the txt file and creates an AdjacencyList from provided GPS points.
 * @author sbend
 *
 */
public class FileImporter {
	
	/**
	 * FileImporter Constructor
	 */
	public FileImporter() {}
	
	/**
	 * Given a .txt file of GPS points, parses XYZ coordinates and creates an adjacency list for each point.
	 * 
	 * @return AdjacencyList of provided GPS points
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 */
	public AdjacencyList importFile(String fileName) throws FileNotFoundException, NumberFormatException{
			//The file name is passed as an argument
			File file = new File(fileName);


			Scanner scan = new Scanner(file);
			NodeList myPoints = new NodeList();
			boolean startFlag = true;
			
			while(scan.hasNextLine()) {
				//read in the transactions
				String point = scan.nextLine();
				StringTokenizer tok = new StringTokenizer(point, ":");
				//add in error checking!
				tok.nextToken(); //this is GPS, not needed
				String name = tok.nextToken();
				double xpt = Double.parseDouble(tok.nextToken());
				double ypt = Double.parseDouble(tok.nextToken());
				double zpt = Double.parseDouble(tok.nextToken());
				
				Node newNode = new Node(name, xpt, ypt, zpt, startFlag);
				myPoints.add(newNode);
				startFlag = false;
			}
			scan.close();
								
			//Create adjacency list and determine edge weights
			int n = myPoints.size();
			AdjacencyList myList = new AdjacencyList(n);	        
			myList.addAllEdges(myPoints);
			return myList;
			
	}
}
