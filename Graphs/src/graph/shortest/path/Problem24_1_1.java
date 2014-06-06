/*
 * Class Name: Problem24_1_1
 * 
 * Author: Zuhayr Elahi
 * 
 * Description: Problem 24.1-1 from CLRS Introduction to Algorithms
 */

package graph.shortest.path;

import components.graph.*;

public class Problem24_1_1 {
	
	//Graph created is from Figure 24.4
	public static Graph createGraph(){
		
		//Create Vertices
		Vertex s = new Vertex('s');
		Vertex t = new Vertex('t');
		Vertex x = new Vertex('x');
		Vertex z = new Vertex('z');
		Vertex y = new Vertex('y');
		
		//Create Edges
		
		//Edges from s to other vertices
		Edge st = new Edge(s,t,6);
		Edge sy = new Edge(s,y,7);
		
		//Edges from t to other vertices
		Edge tx = new Edge(t,x,5);
		Edge ty = new Edge(t,y,8);
		Edge tz = new Edge(t,z,-4);
		
		//Edges from x to other vertices
		Edge xt = new Edge(x,t,-2);
		
		//Edges from y to other vertices
		Edge yx = new Edge(y,x,-3);
		Edge yz = new Edge(y,z,9);
		
		//Edges from z to other vertices
		Edge zs = new Edge(z,s,2);
		
		//Create graph
		Graph myGraph = new Graph();
		myGraph.setDirected();  //set graph as directed
		
		//Add vertices to the graph
		myGraph.addVertex(s);
		myGraph.addVertex(t);
		myGraph.addVertex(x);
		myGraph.addVertex(y);
		myGraph.addVertex(z);
		
		//Add edges to the graph
		myGraph.addEdge(st);
		myGraph.addEdge(sy);
		myGraph.addEdge(tx);
		myGraph.addEdge(ty);
		myGraph.addEdge(tz);
		myGraph.addEdge(xt);
		myGraph.addEdge(yz);
		myGraph.addEdge(yx);
		myGraph.addEdge(zs);

		
		
		return myGraph;
		
	}
	
	public static void main(String args[]) {
		Graph myGraph = createGraph();
		
		BellmanFord findShortestPath = new BellmanFord();
		findShortestPath.BFShortestPath(myGraph, myGraph.getVertexAt(1));
		
		
	}

}
