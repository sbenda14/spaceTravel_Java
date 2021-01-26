package src;

import java.util.ArrayList;

public class NodeList  {
    private ArrayList<Node> waypoints;

    /* Constructor for Nodelist
     *
     */
    public NodeList() {
    	waypoints = new ArrayList<Node>();
    }
    
    
    public void add(Node pt) {
    	this.waypoints.add(pt);
    }

    public int size() {
    	return waypoints.size();
    }
    
    public Node getAtIndex(int index) {
    	return waypoints.get(index);
    }
    
    public String toString(){
        String allPts = "";
    	for(Node e : waypoints) {
        	allPts += e.toString() +"\n";
        }
    	
    	return allPts;
    }

}