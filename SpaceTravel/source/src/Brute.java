package src;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Brute force (naive) solution to TSP. Assumes that the first waypoint is the starting point.
 * Determines cost of *all* permutations of path, chooses the path with minimum cost.
 * Exact solution, but not feasible for large data sets, e.g. 2 weeks for 15 waypoints 
 * (source: https://www.baeldung.com/java-array-permutations)
 * 
 * Heap's algorithm: https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
 */
public class Brute{
	private double minimumCost;
	
	 /*
     * Constructs instance of Brute to use with TravelDriver
     */
    public Brute() { 
        
    } 
	
	public ArrayList<AdjNode> getNaivePath(AdjacencyList myList){
		ArrayList<AdjNode> ordered = new ArrayList<>();
		
		String[] permList = new String[myList.getSize()];
		for(int i = 0; i < myList.getSize(); i++) {
			permList[i] = myList.getNeighbors(i).getFirst().getInitial();
		}
		
		heapPermutation(permList, permList.length, permList.length);
		
		return ordered;
	}
	
	/** Prints the array */
    void printArr(String a[], int n){
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
 
    /** Generating permutation using Heap's Algorithm
     * @param a[], the array to be permuted
     * @param size, the size of the array
     * @param n, 
     *  */
    void heapPermutation(String a[], int size, int n){
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            printArr(a, n);
 
        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);
 
            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                String temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }
 
            // If size is even, swap ith 
            // and (size-1)th i.e last element
            else {
                String temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }
	
	
}