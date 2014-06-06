/* Class name: TestGraph
 * 
 * Author: Zuhayr
 * 
 * Description: Check to see if a graph can be created 
 * 
 */

package testGraphAlgorithms;

import components.graph.Edge;
import components.graph.Graph;
import components.graph.Vertex;

import graph.shortest.path.*;


public class TestGraph {

	public static Graph createGraph(){
		double w1 = 2;
		double w2 = 5;
		double w3 = 10;
		double w4 = 7;
		double w5 = 8;
		
		// Create new vertices
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');
		Vertex d = new Vertex('d');
		Vertex e = new Vertex('e');
		
		//Create new Edges
		Edge ab = new Edge(a,b,w1);
		Edge bc = new Edge(b,c,w2);
		Edge ad = new Edge(a,d,w3);
		Edge de = new Edge(d,e,w4);
		Edge be = new Edge(b,e,w5);
		Edge ac = new Edge(a,c,w1);
				
		//Create the graph
		Graph myGraph = new Graph();
		
		//add vertices to the graph
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);
		myGraph.addVertex(e);
		
		//add edges to graph
		myGraph.addEdge(ab);
		myGraph.addEdge(bc);
		myGraph.addEdge(ad);
		myGraph.addEdge(de);
		myGraph.addEdge(be);
		myGraph.addEdge(ac);
		
		myGraph.setunDirected();
		return myGraph;
		
	}
	
	public static void main(String[] args) {
		
		Graph myGraph = createGraph();
		//BellmanFord findShortestPath = new BellmanFord();
		double[][] graphMatrix = myGraph.getAdjacencyMatrix();
		//findShortestPath.BFShortestPath(myGraph, myGraph.getVertexAt(1));
		
		for(int i=0; i < graphMatrix.length; i++){
			for(int j=0; j < graphMatrix.length; j++) {
				System.out.print(graphMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
