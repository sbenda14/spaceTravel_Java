package src;

import java.util.Hashtable;
import java.util.LinkedList;
import java.text.DecimalFormat;

/**
 * Creates an adjacency list for the imported nodes. This will be a complete graph (every point to 
 * every other point) for TSP.  
 * source: https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
 */

public class AdjacencyList {

    // Number of vertices in the graph 
	private int V; 
  
    // List of adjacent nodes of a given vertex 
    private LinkedList<AdjNode>[] adj;
    
    //Hashtable of weights
    private Hashtable<String, Double> weightLookup;
      
    /**
     * Constructs Adjacency list given # of nodes 
     * @param numVertices, the number of vertices in graph
     */
    public AdjacencyList(int numVertices) { 
        V = numVertices; 
        adj = new LinkedList[V]; 
        for (int i = 0; i < V; i++) { 
            adj[i] = new LinkedList<>();
        }  
        
        weightLookup = new Hashtable<String, Double>();
        
    } 
   
    /**Add an edge between two vertices
     * @param srcInd, the source point index
     * @param destInd, the destination point index
     * @param src, the source waypoint name
     * @param dest, the destination waypoint name
     * @param weight, the weight of the edge (symmetric)
     * */
   private void addEdge(int srcInd, int destInd,String src, String dest, double weight) 
    { 
    	AdjNode node0 = new AdjNode(src, dest, weight); 
        AdjNode node1 = new AdjNode(dest, src, weight); 
        adj[srcInd].addLast(node0); 
        adj[destInd].addLast(node1); 
        
        //add weight to hashtable
        
    } 
    
   /**
    * Cycles through NodeList, creates edges from one point to all other points
    * @param points, the points to create AdjacencyList for
    */
    public void addAllEdges(NodeList points) { 
    	//cycle through all vertices in points, add edges to adj list
    	
    	for(int i = 0; i < V; i++) {
    		for(int j=i+1; j < V; j++) {
    			
				Node first = points.getAtIndex(i);
				Node second = points.getAtIndex(j);
				
				double distance = getWeight(first, second);
				
				addEdge(i, j, first.getWaypoint(), second.getWaypoint(), distance);
				
    		}
    	}
    	
    	//print adjacency list
    	/*
    	DecimalFormat numberFormat = new DecimalFormat("#.00");
    	
    	for(int i=0; i < adj.length; i++) {
    		for(AdjNode e : adj[i]) {
    			System.out.println(e.getInitial() +"->"+ e.getDest() + ": "+ numberFormat.format(e.getWeight()));
    		}
    	}
		*/
    }
    
	/**Determine weight between two vertices
	 * @param first, the first vertex
	 * @param second, the second vertex
	 * */
    private double getWeight(Node first, Node second) {

        	double x1 = first.getX();
        	double y1 = first.getY();
        	double z1 = first.getZ();
        	
        	double x2 = second.getX();
        	double y2 = second.getY();
        	double z2 = second.getZ();
        		
        	double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2) + Math.pow(z2-z1,2));
        
        	return distance;
    }
    
    
    /**
     * Returns the neighbors for indicated node index 
     * @param index, the index of the specified AdjNode
     * @return all neighbors of specified AdjNode
     */
    public LinkedList<AdjNode> getNeighbors(int index){
    	return adj[index];
    }
    
    /**
     * Returns the index of requested node in linkedList[] adj
     * @param initial, the waypoint name we need an index for
     * @return the index of the requested node
     */
    public int getIndex(String initial) {
    	int index = 0;
    	for(int i=0; i < adj.length; i++) {
    		if(adj[i].getFirst().getInitial().equals(initial)) {
    			index = i;
    			break;
    		}
    	}
    	return index;
    }
    
    
    /**
     * Returns the size of the AdjacencyList, i.e. # of waypoints
     * @return the size of the Adjacency list
     */
    public int getSize() {
    	return V;
    }
    
}