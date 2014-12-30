package determinzation;

import java.util.*;

public class SimpleGraph {

	public SimpleGraph() {
		super();
		bows = new ArrayList<SimpleBow>();
	}

	public LinkedHashSet<Integer> move(LinkedHashSet<Integer> s, int a) {

		LinkedHashSet<Integer> s1 = new LinkedHashSet<Integer>();
		for (Integer i : s) {
			for (SimpleBow b : bows) {
				if (b.move(i, a) >= 0)
					s1.add(b.move(i, a));
			}
		}

		return s1;
	}

	public LinkedHashSet<Integer> closingBuild(LinkedHashSet<Integer> s) {

		
		ArrayList<Integer> sa = new ArrayList<Integer>(s);
		int n = sa.size();
		for(int j = 0; j < n; ++j) {
			int i = sa.get(j);
			for (SimpleBow b : bows) {
				int k = b.move(i, -1);
				if (k >= 0 && !sa.contains(new Integer(k))){
					sa.add(b.move(i, -1));
					++n;
				}
				
			}
		}
		

		return new LinkedHashSet<Integer>(sa);
	}

	public void addBow(SimpleBow b) {
		bows.add(b);
	}

	public int getvCount() {
		return vCount;
	}

	public void setvCount(int vCount) {
		this.vCount = vCount;
	}

	private ArrayList<SimpleBow> bows;
	private int vCount;
}
