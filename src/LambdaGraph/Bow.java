package LambdaGraph;

/**
 * @author Iron Malon
 * @version 1.0
 * @created 05-ноя-2014 21:45:55
 */
public class Bow implements Comparable<Bow> {

	private Vertex endVertex;
	private String name;
	private int numberName;
	private Vertex startVertex;

	public Bow() {

	}

	public Bow(int numberName, String name, Vertex startVertex, Vertex endVertex) {
		super();
		this.endVertex = endVertex;
		this.name = name;
		this.startVertex = startVertex;
		this.numberName = numberName;
	}

	public void changeVertex(Vertex vOld, Vertex vNew) {
		if (startVertex == vOld)
			startVertex = vNew;

		if (endVertex == vOld)
			endVertex = vNew;
	}

	public String toString() {
		String s = "[" + startVertex.getnumber();
		s += ", " + name + "("+numberName+")";
		s += ", " + endVertex.getnumber() + "]";
		return s;
	}

	public void finalize() throws Throwable {

	}

	public Vertex getendVertex() {
		return endVertex;
	}

	public String getname() {
		return name;
	}

	public Vertex getstartVertex() {
		return startVertex;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setendVertex(Vertex newVal) {
		endVertex = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setname(String newVal) {
		name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstartVertex(Vertex newVal) {
		startVertex = newVal;
	}

	public int getNumberName() {
		return numberName;
	}

	public void setNumberName(int numberName) {
		this.numberName = numberName;
	}

	
	
	
	public int compareTo(Bow b) {
		int n = startVertex.getnumber() - b.getstartVertex().getnumber();
		int m = endVertex.getnumber() - b.getendVertex().getnumber();
		if (n != 0)
			n = n / Math.abs(n);
		if (m != 0)
			m = m / Math.abs(m);
		switch (n) {
		case 1:
			return 1;

		case -1:
			return -1;

		case 0:
			return m;
		default:
			break;
		}
		return 0;
	}

}