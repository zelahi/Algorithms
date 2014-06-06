/*
 * Class Name: Graph
 * 
 * Author: Zuhayr
 * 
 * Description: Creating a graph based on the Edge and Java classes
 * 				 
 */

package components.graph;

import java.util.Vector;

public class Graph {
	/**
	 * @param verticies vector to store the vertices
	 * @param edges vector to store the edges
	 * @param directed tells us if the graph is a directed graph
	 */
	protected Vector<Vertex> vertices = new Vector<Vertex>();
	protected Vector<Edge> edges = new Vector<Edge>();
	protected boolean directed = false;
	
	/**
	 * Create an adjacency Matrix representation of the graph
	 * 
	 * @return adjacencyMatrix of the graph
	 */
	public double[][]getAdjacencyMatrix() {
		double adjMatrix[][] = new double[vertices.size()][vertices.size()];
		
		for(int incr = 0; incr < vertices.size(); incr++) {
			Vertex<?> vertex = vertices.elementAt(incr);
		
			for(int incr2 = 0; incr2 < edges.size(); incr2++ ) {
			Edge edge = edges.elementAt(incr2);
			
			if (edge.a == vertex) {
				int indexOfNeighbor = vertices.indexOf(edge.b);
				adjMatrix[incr][indexOfNeighbor] = edge.weight;
			}
				
			}	
		}
		return adjMatrix;
	}
	/**
	 * sets the graph as a directed graph
	 */
	public void setDirected() {
		directed = true;
	}
	/**
	 * sets a graph as undirected
	 */
	public void setunDirected() {
		directed = false;
	}
	
	/**
	 * checks if graph is directed
	 * @return 
	 */
	public boolean isDirected() {
		return directed;
	}
	
	/**
	 * 
	 * @param a vertex for which we are looking for the index
	 * @return the index of a vertex
	 */
	public int indexOf(Vertex<?> a){ 
		for(int incr = 0; incr < vertices.size(); incr++){
			if(vertices.elementAt(incr).data.equals(a.data)){
				return incr;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @return vector of vertices in the array
	 */
	public Vector<Vertex> getVertices(){
		return vertices;
	}
	
	/**
	 * 
	 * @return vector of edges
	 */
	public Vector<Edge> getEdges() {
		return edges;
	}
	
	/**
	 * 
	 * @param loc index of vertex for which you are looking
	 * @return the vertex at the specified location
	 */
	public Vertex<?> getVertexAt(int loc) {
		return vertices.elementAt(loc);
	}
	
	/** 
	 * unvisits all vertices in the graph
	 */
	public void unvistAllVerticies() {
		for(int incr = 0; incr < vertices.size(); incr++ ){
			vertices.elementAt(incr).unvisited();
		}
	}
	
	/**
	 * creates a vector of the neighbors for vertex a
	 * 
	 * @param a vertex for which we need to find the neighbors
	 * @return a vector of the neighbors for that vertex
	 */
	public Vector<Vertex> getNeighbors(Vertex a){
		Vector<Vertex> neighbors = new Vector<Vertex>();
		
		for(int incr = 0; incr < edges.size(); incr++){
			Edge edge = edges.elementAt(incr);
			if(edge.a == a){
				neighbors.add(edge.b);
			}
			if(!directed && edge.b == a) {
				neighbors.add(edge.a);
			}	
		}
		return neighbors;
	}
	
	/**
	 * adds a vertex to the graph
	 * 
	 * @param a vertex to be added
	 * @return count of vertices
	 */
	public int addVertex(Vertex a){
		vertices.add(a);
		
		return vertices.size()-1;
	}
	
	/**
	 * adds a new edge to the graph
	 * 
	 * @param a edge to be added to graph
	 */
	public void addEdge(Edge a) {
		edges.add(a);
		if(!directed){
			edges.add(new Edge(a.b,a.a,a.weight));
		}
	}
	
	/**
	 * prints out vertices in the graph
	 */
	public void printVertices(){
		System.out.println(vertices);
	}
	
	/**
	 * prints the edges in a graph
	 */
	public void printEdges() {
		System.out.println(edges);
	}	
	
	/**
	 * {@code add multiple vertices to the graph}
	 * @param vertices stores vertices to be added to graph
	 */
	public void addVertices(Vector<Vertex> vertices) {
		for(Vertex v : vertices){
			addVertex(v);
		}
	}
	
	/**
	 * {@code add multiple edges to the graph}
	 * @param edges edges that need to be added to the graph
	 */
	public void addEdges(Vector<Edge> edges){
		for(Edge e : edges){
			addEdge(e);
		}
	}
	
	/**
	 * {@code add multiple Edges and Vertices to the graph}
	 * @param vertices contains vertices of the graph
	 * @param edges contains edges of the graph
	 */
	public void addEdgesAndVertices(Vector<Vertex> vertices, Vector<Edge> edges){
		addEdges(edges);
		addVertices(vertices);
	}
}
