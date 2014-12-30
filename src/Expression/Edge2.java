package Expression;
public class Edge2 {
	private String label;
	private int start;
	private int end;

	public Edge2(String label, int start, int end) {
		super();
		this.label = label;
		this.start = start;
		this.end = end;
	}

	public String toString() {
		return label;
	}

	public void append(String s) {
		label = label + "|" + s;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
