package src;

import java.util.ArrayList;

/**
 * An arraylist of Nodes (waypoints). Used to implement TSP algorithms
 * @author sbend
 *
 */
public class NodeList  {
    private ArrayList<Node> waypoints;

    /** 
     * Constructor for Nodelist; creates an ArrayList
     */
    public NodeList() {
    	waypoints = new ArrayList<Node>();
    }
    
    /**
     * Adds a Node to ArrayList
     * @param pt, the waypoint to be added
     */
    public void add(Node pt) {
    	this.waypoints.add(pt);
    }

    /**
     * Returns the size of the ArrayList
     * @return the number of waypoints
     */
    public int size() {
    	return waypoints.size();
    }
    
    /**
     * Returns the waypoint at specified index
     * @param index, the index of desired waypoint
     * @return the waypoint at specified index
     */
    public Node getAtIndex(int index) {
    	return waypoints.get(index);
    }
    
    /**
     * Formats a toString for all Waypoints in ArrayList
     * @return the toString for all Waypoints in ArrayList
     */
    public String toString(){
        String allPts = "";
    	for(Node e : waypoints) {
        	allPts += e.toString() +"\n";
        }
    	
    	return allPts;
    }

}