/*
 * Name: Zuhayr Elahi
 * 
 * Class Name: Bellman-Ford 
 * 
 * Description: The Bellman-Ford algorithm computes the shortest distance
 * 				from a vertex to every other vertex in a weighted graph.
 */
package graph.shortest.path;

import java.util.Vector;

import components.graph.Edge;
import components.graph.Graph;
import components.graph.Vertex;
/**
 * Implementation of a Bellman-Ford algorithm
 * 
 * @author zuhayr
 *
 */
public class BellmanFord {
	
	/**
	 * {@code Calculates the shortest path from one vertex to all the other vertices}
	 * 
	 * @param myGraph graph being analyzed to find the shortest path 
	 * @param startVertex The vertex on which we are performing BellmanFord
	 */
	@SuppressWarnings("rawtypes")
	public void BFShortestPath(Graph myGraph, Vertex startVertex) {
		
		//Does not execute algorithm if the graph is not directed
		if(myGraph.isDirected() == false){
			return;
		}
		
		//Step 1: Initialize Graph
		Vector<Vertex> vertices = myGraph.getVertices(); 
		Vector<Edge> edges = myGraph.getEdges();  
		//initialize distance, which converges to shortest-path value
		for(Vertex v : vertices) {
			v.setDistance(Double.POSITIVE_INFINITY);
		}
		startVertex.setDistance(0);
		
		//Step 2: Relax each edge
		for(Edge e : edges){
			for(int i =0; i < edges.size(); i++){
				System.out.print("Vertex for distance being set = " + e.getVertexB() + "  ");
				printDistance(e.getVertexA().distance,i);
			}
			relax(e);
		}
		
		//Step 3: Check for negative weight cycles
		for(Edge e : edges){
			Vertex vertex1 = e.getVertexA();
			Vertex vertex2 = e.getVertexB();
			
			if(vertex1.distance > vertex2.distance + e.getWeight()){
				System.out.println("No Solution");
			}
		}
	}
	
/**
 * {@code relaxes each edge by setting the appropriate distance}
 * 
 * @param myEdge edge which needs to be relaxed
 */
	@SuppressWarnings("rawtypes")
	private void relax(Edge myEdge) {
		Vertex vertex1 = myEdge.getVertexA();
		Vertex vertex2 = myEdge.getVertexB();
		
		if(vertex1.distance > vertex2.distance + myEdge.getWeight()){
			vertex1.distance = vertex2.distance + myEdge.getWeight();
		}
	}
	
	/**
	 * {@code print out the distance and the iteration of the vertex}
	 * 
	 * @param distance
	 * @param iterationNumber
	 */
	public void printDistance(double distance, int iterationNumber){
		System.out.println("Iteration #:" + iterationNumber + "  " + "Distance = " + distance);
	} 
}
