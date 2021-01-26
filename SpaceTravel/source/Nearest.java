package source;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Nearest Neighbor solution to TSP. Assumes that the first waypoint is the starting point.
 * Selects the shortest path to neighbor...repeat.
 * Should be within ~25% of exact solution on average... 
 */
public class Nearest{
	
	 /*
     * Constructs instance of Nearest 
     * 
     */
    public Nearest() { 
        
    }
	
	public ArrayList<AdjNode> getNearestNeighbor(AdjacencyList myList){
		ArrayList<AdjNode> ordered = new ArrayList<>();
		ArrayList<String> addedNodes = new ArrayList<>();
		
		//take first linked list off of mylist
		//choose shortest distance
		//add AdjNode to arraylist ordered
		int count = 0;
		int index = 0;
		
		while(count < myList.getSize()-1) {
			LinkedList<AdjNode> tmp = myList.getNeighbors(index);
			AdjNode minimum = new AdjNode("","",999999999);
			for(AdjNode e : tmp) {
				if(!addedNodes.contains(e.getDest())) {
					if(e.getWeight() < minimum.getWeight()) {
						minimum = e;
					}
				}
			}
			 
			//add minimum node to ordered list
			ordered.add(minimum);
			addedNodes.add(minimum.getInitial());
			
			//get destination linked list to visit
			index = myList.getIndex(minimum.getDest());
			
			count++;
		}
		
		//add starting point to end
		LinkedList<AdjNode> tmp = myList.getNeighbors(index);
		for(AdjNode e : tmp) {
			if(e.getDest() == ordered.get(0).getInitial()) {
				ordered.add(e);
			}
		}
		
		return ordered;
	}
	
	
}