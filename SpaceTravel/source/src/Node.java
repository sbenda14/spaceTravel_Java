package src;
/**
* Node class. Holds a GPS point name and its XYZ coordinates	
*/

public class Node {        
	private String waypoint;
	private double X;
	private double Y;
	private double Z;
	private boolean start;
	
	 /** Constructor for waypoint, assigns name, XYZ coordinates, and indicates start point based on five parameters
     * @param point, waypoint name
     * @param Xpt, the X coordinate
     * @param Ypt, the Y coordinate
     * @param Zpt, the Z coordinate 
     * @param startpt, true if starting coordinate
     */ 
    public Node(String point, double Xpt, double Ypt, double Zpt, boolean startpt) {
    	this.waypoint = point;
    	this.X = Xpt;
    	this.Y = Ypt;
    	this.Z = Zpt;
    	this.start = startpt;
    }
    
    /**
     * Returns a string of waypoints name
     * @return waypoint name
     */
    public String getWaypoint() {
    	return waypoint;
    }
    
    /**
     * Returns X coordinate of waypoint
     * @return X
     */
    public double getX() {
    	return X;
    }
    
    /**
     * Returns Y coordinate of waypoint
     * @return Y 
     */
    public double getY() {
    	return Y;
    }
    
    /**
     * Returns Z coordinate of waypoint
     * @return Z 
     */
    public double getZ() {
    	return Z;
    }
    
    /**
     * Returns true if waypoint is the starting point
     * @return True if starting point
     */
    public boolean isStart() {
    	return start;
    }
    
    /**
     * Formats and returns string of Waypoint Name, XYZ coordinates
     * @return waypoint toString
     */
    public String toString(){
        return "[" + this.waypoint + " => " + this.X +":" + this.Y +":" + this.Z + "]";
    }
}