/*
 * Name: Edge.java
 * 
 * Author: Zuhayr
 * 
 * Description: Implementation of an Edge class for 
 * 				the graph
 */

package components.graph;

public class Edge {
	protected Vertex<?> a, b; //the two vertices connected by the edge
	protected Double weight; //the weight of the edge
	
	/**
	 * 
	 * @param a	Vertex connected by the edge
	 * @param b	Vertex connected by the edge
	 * @param i	weight of the edge
	 */
	public Edge(Vertex<?> a, Vertex<?> b, double i){
		this.a = a;
		this.b = b;
		this.weight = i;
		if(i == 0) {
			i = Double.POSITIVE_INFINITY;
		}
	}
	/**
	 * returns the weight of the edge
	 * 
	 * @return weight of the edge
	 */
	public Double getWeight(){
		return this.weight;
	}
	/**
	 * sets the weight of the edge
	 * 
	 * @param weight weight of the graph
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Vertex<?> getVertexA(){
		return this.a;
	}
	
	public Vertex<?> getVertexB(){
		return this.b;
	}
	

}
