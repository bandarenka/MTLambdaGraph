package LambdaGraph;

/**
 * @author Iron Malon
 * @version 1.0
 * @created 05-ноя-2014 21:45:54
 */
public class Vertex {

	private int number;

	public Vertex(int number) {
		super();
		this.number = number;
	}

	public Vertex(){

	}

	public void finalize() throws Throwable {

	}

	public int getnumber(){
		return number;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnumber(int newVal){
		number = newVal;
	}

}