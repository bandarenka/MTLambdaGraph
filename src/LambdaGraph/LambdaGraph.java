package LambdaGraph;

import java.util.ArrayList;
import java.util.Collections;
import Expression.*;
import determinzation.SimpleBow;
import determinzation.SimpleGraph;

/**
 * @author Iron Malon
 * @version 1.0
 * @created 05-ноя-2014 21:45:56
 */
public class LambdaGraph {

	private ArrayList<Bow> bows;
	private ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
	private Vertex endVertex;
	private Vertex startVertex;
	public static final int AND = 1;
	public static final int OR = 2;

	public LambdaGraph(String s, int n, boolean isIteration) {

		if (!isIteration) {
			startVertex = new Vertex(0);
			endVertex = new Vertex(1);
			bows = new ArrayList<Bow>();
			Bow bow = new Bow(n, s, startVertex, endVertex);
			bows.add(bow);
			this.fillVertexes();
		} else {

			startVertex = new Vertex(0);
			endVertex = new Vertex(2);
			Vertex median = new Vertex(1);

			bows = new ArrayList<Bow>();
			Bow bow1 = new Bow(-1, "$", startVertex, median);
			Bow bow2 = new Bow(n, s, median, median);
			Bow bow3 = new Bow(-1, "$", median, endVertex);
			bows.add(bow1);
			bows.add(bow2);
			bows.add(bow3);
			this.fillVertexes();
		}

	}

	public LambdaGraph(ArrayList<Bow> bows, Vertex startVertex, Vertex endVertex) {
		super();
		this.bows = bows;
		this.endVertex = endVertex;
		this.startVertex = startVertex;
	}

	public LambdaGraph() {
		// TODO Auto-generated constructor stub
	}

	public void finalize() throws Throwable {

	}

	public void nameVertexes() {
		int i = 0;
		for (Vertex v : vertexes)
			v.setnumber(i++);
	}

	public String toString() {
		ArrayList<String> cal = func();
		StringBuffer sb = new StringBuffer();
		for(String s: cal)
			sb.append(s);
		sb.append("\n");
		for (Bow b : bows)
			sb.append(b.toString()).append('\n');
		return new String(sb);
	}

	public ArrayList<String> func() {
		ArrayList<String> cal = new ArrayList<String>();
		int j = 0;
		for (Bow b : bows)// (int i = 0; i < bows.size(); ++i)
		{
			if (j != b.getNumberName()) {
				cal.add(b.getname());
				++j;
			}
		}
		
		return cal;
	}

	public void printGraph() {
		/*
		 * for (Bow b : bows) System.out.println(b.toString());
		 */
		System.out.print(toString());
	}

	public void iterate() {
		for (Bow b : bows) {
			b.changeVertex(endVertex, startVertex);
		}
		Vertex median = startVertex;
		startVertex = new Vertex(0);
		endVertex = new Vertex(0);
		Bow bow1 = new Bow(-1, "$", startVertex, median);
		Bow bow3 = new Bow(-1, "$", median, endVertex);
		bows.add(bow1);
		bows.add(bow3);
		fillVertexes();
	}

	public void fillVertexes() {
		vertexes = new ArrayList<Vertex>();
		for (Bow b : bows) {
			if (!vertexes.contains(b.getstartVertex()))
				vertexes.add(b.getstartVertex());
			if (!vertexes.contains(b.getendVertex()))
				vertexes.add(b.getendVertex());
		}
	}

	public int maxVertexNum() {
		int max = 0;
		for (Vertex v : vertexes) {
			if (v.getnumber() > max)
				max = v.getnumber();
		}

		return max;
	}

	public void changeVertexes(Vertex vOld, Vertex vNew) {
		for (Bow b : bows) {

			if (b.getstartVertex() == vOld) {
				if (b.getstartVertex() == startVertex)
					startVertex = vNew;
				b.setstartVertex(vNew);
			}

			if (b.getendVertex() == vOld) {
				if (b.getendVertex() == endVertex)
					endVertex = vNew;
				b.setendVertex(vNew);
			}
		}
	}

	public void sort() {
		Collections.sort(bows);
	}

	public static LambdaGraph concat(LambdaGraph g1, LambdaGraph g2,
			int concatWay) {
		LambdaGraph res = new LambdaGraph();
		ArrayList<Bow> bows1 = g1.getbows();
		ArrayList<Bow> bows2 = g2.getbows();
		ArrayList<Bow> resBows = new ArrayList<Bow>(bows1);

		for (Bow b : bows2) {
			resBows.add(b);
		}

		int deltaNum = g1.maxVertexNum();// - 1;

		/*
		 * for (Vertex v : g2.getVertexes()) { if (v != g2.startVertex) { if
		 * (concatWay == AND) v.setnumber(v.getnumber() + deltaNum); else if (v
		 * != g2.endVertex) v.setnumber(v.getnumber() + deltaNum); } }
		 */

		// for (Vertex v : g2.getVertexes())
		// v.setnumber(v.getnumber() + deltaNum);

		if (concatWay == AND) {
			// g2.getstartVertex().setnumber(g1.getendVertex().getnumber());
			Vertex vOld = g1.getendVertex();
			Vertex vNew = g2.getstartVertex();
			g1.changeVertexes(vOld, vNew);
			/*
			 * for (Bow b : g1.getbows()) { b.changeVertex(vOld, vNew); }
			 */
			res = new LambdaGraph(resBows, g1.getstartVertex(),
					g2.getendVertex());

		} else {
			// g2.getstartVertex().setnumber(g1.getstartVertex().getnumber());
			// g2.getendVertex().setnumber(g1.getendVertex().getnumber());

			Vertex vStartOld = g1.getstartVertex();
			Vertex vEndOld = g1.getendVertex();

			Vertex vStartNew = g2.getstartVertex();
			Vertex vEndNew = g2.getendVertex();

			g1.changeVertexes(vStartOld, vStartNew);
			g1.changeVertexes(vEndOld, vEndNew);
			/*
			 * for (Bow b : g1.getbows()) { b.changeVertex(vStartOld,
			 * vStartNew); b.changeVertex(vEndOld, vEndNew); }
			 */
			res = new LambdaGraph(resBows, vStartNew, vEndNew);
		}

		res.fillVertexes();
		return res;
	}

	public static LambdaGraph concat(ArrayList<LambdaGraph> graphs,
			int concatWay) {
		LambdaGraph res = null;
		for (LambdaGraph g : graphs) {
			if (res == null)
				res = g;
			else
				res = concat(res, g, concatWay);

		}
		return res;

	}

	public SimpleGraph convertToSimpleGraph() {
		SimpleGraph sg = new SimpleGraph();
		for (Bow b : bows) {
			int startV = b.getstartVertex().getnumber();
			int endV = b.getendVertex().getnumber();
			char bowChar = b.getname().charAt(0);
			int bowInt = Expression.abstractAlphabet
					.get(new Character(bowChar));
			SimpleBow sb = new SimpleBow(startV, endV, bowInt, bowChar);
			sg.addBow(sb);
		}

		sg.setvCount(vertexes.size());
		return sg;
	}

	public ArrayList<Bow> getbows() {
		return bows;
	}

	public Vertex getendVertex() {
		return endVertex;
	}

	public Vertex getstartVertex() {

		return startVertex;
	}

	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setbows(ArrayList<Bow> newVal) {
		bows = newVal;
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
	public void setstartVertex(Vertex newVal) {
		startVertex = newVal;
	}

}