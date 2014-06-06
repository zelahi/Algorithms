package mst.graphs;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

import components.graph.*;

/**
 * {@code The following class defines the methods for creating a MST using Prim's algorithm}
 * @author zuhayr
 *
 */
@SuppressWarnings("rawtypes")
public class Prims {
	/**
	 * {@code runs prims algorithm to find the shortest path from one vertex to every other vertex in the graph}
	 * @param myGraph Graph to find the shortest path
	 * @param startVertex starting point for Prims
	 */
		public void Prims_MST(Graph myGraph,Vertex startVertex){
			
			Queue x = new PriorityQueue<Vertex>(myGraph.getVertices());
			
			
		}

}
