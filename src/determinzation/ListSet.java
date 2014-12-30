package determinzation;
import java.util.*;
public class ListSet {

	public ListSet() {
		super();
		set = new ArrayList<Integer>();
	}

	public void add(Integer i) {
		if (!set.contains(i))
		set.add(i);
	}
	private ArrayList<Integer> set;
}
