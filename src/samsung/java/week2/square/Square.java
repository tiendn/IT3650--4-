package samsung.java.week2.square;

public class Square {
	/** Set class Square : describe a square
	 * @param att edge : the edge of square
	 *  
	 */
	
	private float edge;
	public Square(float edge){
		/**
		 *  The constructor with float argument
		 */
		setEdge(edge);
	}
	public float getEdge() {
		return edge;
	}
	public void setEdge(float edge) {
		if ( edge > 0 && Float.isFinite(edge))
			this.edge = edge;
	}
	/**
	 *  Display length of square edge
	 */
	public void displayLength(){
		
		System.out.println("Length of square edge is : "+ getEdge());
	}
	public void displayPerimeter(){
		/**
		 *  Display the perimeter of square
		 */
		System.out.println("The perimeter of square is : "+ getEdge()*4);
	}
	public void displayArea(){
		/**
		 * Display the area of square
		 */
		System.out.println("The area of square is : " + Math.pow(getEdge(), 2));
	}
	public void displayAllInfo(){
		/** 
		 * Display the length of square edge, 
		 * Display the perimeter,area of square
		 */
		displayLength();
		displayPerimeter();
		displayArea();
	}
}
