package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileImporter {
	
	public FileImporter() {}
	
	public AdjacencyList importFile(String fileName) throws FileNotFoundException{
			//The file name is passed as an argument
			File file = new File(fileName);
			if(file.exists()){

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
				
				/*
				System.out.println("Original linked list:" );
				System.out.println( myPoints.toString());  
				*/
				
				//Create adjacency list and determine edge weights
				int n = myPoints.size();
				AdjacencyList myList = new AdjacencyList(n);	        
				myList.addAllEdges(myPoints);
				return myList;
			} else {
				System.err.println(file + " does not exists - please check the file path");
			}
			//dummy list. shouldn't get here
			AdjacencyList myList = new AdjacencyList(1);
			return myList;
	}
}
