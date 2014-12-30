package determinzation;

import java.util.*;

import javax.swing.JTable;

import Expression.*;
import LambdaGraph.LambdaGraph;

public class Determinazation {

	public Determinazation(SimpleGraph sg) {
		super();
		this.sg = sg;
		Q = new ArrayList<LinkedHashSet<Integer>>();
		q = new int[sg.getvCount()];
		for (int i = 0; i < q.length; ++i) {
			q[i] = i;
		}
		g = new Object[q.length][Expression.abstractAlphabet.size() - 1];
	}

	/*
	 * public static void main(String[] arg) {
	 * 
	 * ArrayList<LinkedHashSet<Integer>> q = new
	 * ArrayList<LinkedHashSet<Integer>>(); LinkedHashSet<Integer> s1 = new
	 * LinkedHashSet<Integer>(); LinkedHashSet<Integer> s2 = new
	 * LinkedHashSet<Integer>(); LinkedHashSet<Integer> s3 = new
	 * LinkedHashSet<Integer>();
	 * 
	 * s1.add(4); s1.add(1); s1.add(2);
	 * 
	 * s2.add(1); s2.add(4); s2.add(2);
	 * 
	 * s3.add(2); s3.add(1); s3.add(4);
	 * 
	 * q.add(s1);
	 * 
	 * System.out.println(q.indexOf(s1)); System.out.println(q.indexOf(s2));
	 * System.out.println(q.indexOf(s3)); System.out.println(q.contains(s3));
	 * 
	 * }
	 */
	public void process() {
		LinkedHashSet<Integer> q0 = new LinkedHashSet<Integer>();
		q0.add(q[0]);
		q0 = sg.closingBuild(q0);
		Q.add(q0);

		for (int h = 0; h < q.length; ++h) {
			for (int i = 0; i < g[h].length; ++i) {
				if(h >= Q.size())
					break;
				LinkedHashSet<Integer> s = sg.move(Q.get(h), i);
				s = sg.closingBuild(s);
				if (Q.contains(s))
					g[h][i] = Q.indexOf(s);
				else {
					Q.add(s);
					g[h][i] = Q.size() - 1;

				}
			}

		}
	}

	public JTable getTable(){
		Object[] ch = Expression.absAl.toArray();
		String[] s = {"s1", "s2", "s3", "s4", "s5"};
		JTable table = new JTable(g, s);
		
		return table;
	}
	public void print() {
		for (Character c : Expression.absAl)
			System.out.print(c + " ");
		System.out.println();
		for (int i = 0; i < g.length; ++i) {
			for (int j = 0; j < g[i].length; ++j)
				System.out.print(g[i][j] + " ");
			System.out.println();
		}
	}

	private ArrayList<LinkedHashSet<Integer>> Q;

	private SimpleGraph sg;
	private int[] q;
	private Object[][] g;
}
