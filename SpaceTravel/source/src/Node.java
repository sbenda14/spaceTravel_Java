package src;
/*
* Node class. Holds a GPS point name and its XYZ coordinates	
*/

public class Node {        
	private String waypoint;
	private double X;
	private double Y;
	private double Z;
	private boolean start;
	
	 /* Constructor for waypoint, assigns name, XYZ coordinates, and indicates start point based on five parameters
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
    
    public String getWaypoint() {
    	return waypoint;
    }
    
    public double getX() {
    	return X;
    }
    
    public double getY() {
    	return Y;
    }
    
    public double getZ() {
    	return Z;
    }
    
    public boolean isStart() {
    	return start;
    }
    
    public String toString(){
        return "[" + this.waypoint + " => " + this.X +":" + this.Y +":" + this.Z + "]";
    }
}