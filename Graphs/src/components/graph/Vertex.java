package components.graph;

/**
 * Vertex.java
 * 
 * @author zuhayr
 *
 * @param <T> data held by the vertex
 */
public class Vertex<T> implements Comparable<Vertex<T>> {
	protected T data;
	protected boolean visited;
	public Integer index = null;
	public Integer lowlink = null;
	public Double distance = Double.POSITIVE_INFINITY;
	public Vertex<T> predecessor = null;
	
	/**
	 * Constructor class
	 * 
	 * @param data 	information held in the vertex
	 */
	public Vertex(T data){
		this.data = data;
	}
	/**
	 * default constructor
	 */
	public Vertex() {
		
	}
	/**
	 * 
	 * @return 	checks to see if we visited the vertex
	 */
	public boolean isVisited(){
		return visited;
	}
	/**
	 * sets the vertex to have been visited
	 */
	public void visit(){
		visited = true;
	}
	/**
	 * sets the vertex to not visited
	 */
	public void unvisited() {
		visited = false;
	}
	
	/**
	 * @param vertex that we want to check
	 * 
	 * @return the result of comparing two vertices
	 */
	public int compareTo(Vertex<T> v) {
		String tempA = this.toString();
		String tempB = v.toString();
		
		return tempA.compareTo(tempB);
	}
	
	/**
	 * @return converts data in vertex to a string
	 */
	public String toString() {
		return data.toString();
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance(){
		return this.distance;
	}

}
