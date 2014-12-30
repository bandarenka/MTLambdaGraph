package determinzation;

public class SimpleBow {

	public SimpleBow(int startV, int endV, int bowInt, char bowChar) {
		super();
		this.startV = startV;
		this.endV = endV;
		this.bowInt = bowInt;
		this.bowChar = bowChar;
	}

	public int move(int startV, int bow) {
		if (this.startV == startV && this.bowInt == bow) {
			return endV;
		}

		return -1;
	}

	public String toString() {
		return new String("[" + startV + ", " + bowInt + ", " + endV + "]");
	}

	private int startV;
	private int endV;
	private int bowInt;
	private char bowChar;
}
