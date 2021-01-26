package src;

public class AdjNode { 
    	  
    // Stores destination vertex in adjacency list 
	private String dest; 
	private String initial;
	
    // Stores weight of a vertex in the adjacency list 
    private double weight; 
  
    /*
     * Constructor to create adjacency node
     * @param d, the destination vertex
     * @param wt, the weight    
     */
    public AdjNode(String in, String des, double wt) { 
    	initial = in;
    	dest = des; 
    	weight = wt; 
    } 
    
    public double getWeight() {
    	return weight;
    }
    
    public String getDest() {
    	return dest;
    }
    
    public String getInitial() {
    	return initial;
    }
    
  } 