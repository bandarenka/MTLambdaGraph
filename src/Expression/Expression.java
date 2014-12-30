package Expression;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.io.Console;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.*;
import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.algorithms.layout3d.FRLayout;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.*;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.EdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import LambdaGraph.Bow;
import LambdaGraph.LambdaGraph;
import LambdaGraph.Vertex;

public class Expression {

/*	public static void main(String[] arg) {

		// Expression e = new Expression("0(0|7)*($|l|u|ul|lu)");
		Expression e = new Expression("0x(0|f)(0|f)*($|l|u|ul|lu)");
		//Expression e = new Expression("ab(iji)*|ji");
		e.fillAlphabet();
		e.recognize(e.getExpress());
		e.buildGraph();
		e.getGraph().nameVertexes();
		e.getGraph().sort();
		e.getGraph().printGraph();

		Graph<Integer, String> g = new DirectedSparseMultigraph<Integer, String>();
		// Add some vertices. From above we defined these to be type Integer.
		g.addVertex((Integer) 1);
		g.addVertex((Integer) 2);
		g.addVertex((Integer) 3);
		// Add some edges. From above we defined these to be of type String
		// Note that the default is for undirected edges.
		g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
		g.addEdge("Edge-B", 2, 3);
		// Let's see what we have. Note the nice output from the
		// SparseMultigraph<V,E> toString() method
		System.out.println("The graph g = " + g.toString());
		// Note that we can use the same nodes and edges in two different
		// graphs.
		Graph<Integer, String> g2 = new DirectedSparseMultigraph<Integer, String>();
		g2.addVertex((Integer) 1);
		g2.addVertex((Integer) 2);
		g2.addVertex((Integer) 3);
		g2.addEdge("Edge-A", 1, 3);
		g2.addEdge("Edge-B", 2, 3, EdgeType.DIRECTED);
		g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
		g2.addEdge("Edge-P", 2, 3); // A parallel edge
		System.out.println("The graph g2 = " + g2.toString());

		Graph<Integer, Edge2> g4Graph;
		
		final int vStartNumber = e.getGraph().getstartVertex().getnumber();
		final int vEndNubmer = e.getGraph().getendVertex().getnumber();
		Graph<Integer, Edge2> g3 = new DirectedSparseGraph<Integer, Edge2>();
		for (Vertex v : e.getGraph().getVertexes()) {
			g3.addVertex(v.getnumber());
		}

		ArrayList<Edge2> edges = new ArrayList<Edge2>();
		Bow[] bows = new Bow[e.getGraph().getbows().size()];
		int k = 0;
		for (Bow b: e.getGraph().getbows())
			bows[k++] = b;
		for (int i = 0; i < bows.length; ++i) {

			Bow bi = bows[i];
			if (bi == null)
				continue;
			int biStart = bi.getstartVertex().getnumber();
			int biEnd = bi.getendVertex().getnumber();
			Edge2 ed = new Edge2(bi.getname(), biStart, biEnd);
			for (int j = i + 1; j < bows.length; ++j) {
				Bow bj = bows[j];
				int bjStart = bj.getstartVertex().getnumber();
				int bjEnd = bj.getendVertex().getnumber();

				if (biStart == bjStart && biEnd == bjEnd) {
					ed.append(bj.getname());
					bows[j] = null;
				}

			}
			edges.add(ed);
		}

		ToStringLabeller<Edge2> tsl = new ToStringLabeller<Edge2>();
		ToStringLabeller tsl2 = new ToStringLabeller();
		
		
		
		for (Edge2 edg : edges) {
	//		tsl.transform(edg);
			g3.addEdge(edg, edg.getStart(), edg.getEnd());
		}
		Layout layout =  new KKLayout(g3);//  DAGLayout(g3);
		layout.setSize(new Dimension(600, 600));
		VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(
				layout);
		vv.setPreferredSize(new Dimension(650, 650));
		// Setup up a new vertex to paint transformer...
		Transformer<Integer, Paint> vertexPaint = new Transformer<Integer, Paint>() {
			public Paint transform(Integer i) {
				if(i == vStartNumber || i == vEndNubmer)
					return Color.PINK;
				return Color.GREEN;
			}
		};
		
		Transformer<Edge2, Paint> edgePaint = new Transformer<Edge2, Paint>() {
			public Paint transform(Integer i) {
				if(i == vStartNumber || i == vEndNubmer)
					return Color.PINK;
				return Color.GREEN;
			}

			public Paint transform(Edge2 arg0) {
				// TODO Auto-generated method stub
				return Color.RED;
			}
		};
		// Set up a new stroke Transformer for the edges

		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
	//	vv.getRenderContext().setEdgeLabelRenderer(null);
		

		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		//vv.getRenderer().getEdgeLabelRenderer().
		DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
		gm.setMode(ModalGraphMouse.Mode.PICKING);
		vv.setGraphMouse(gm); 
		JFrame frame = new JFrame("Simple Graph View 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);

		int u = 0;
	}
*/

	public static void main(String[] arg) {
		TranslationFrame frame = new TranslationFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public Expression() {
		this.orExpressions = new ArrayList<Expression>();
		this.andExpressions = new ArrayList<Expression>();
	}

	public Expression(String expess) {
		this.orExpressions = new ArrayList<Expression>();
		this.andExpressions = new ArrayList<Expression>();
		this.express = expess;
	}

	public Expression(String expess, boolean isIteration) {
		this.orExpressions = new ArrayList<Expression>();
		this.andExpressions = new ArrayList<Expression>();
		this.express = expess;
		this.isIteration = isIteration;
	}

	public ArrayList<Expression> getOrExpressions() {
		return orExpressions;
	}

	public void setOrExpressions(ArrayList<Expression> orExpressions) {
		this.orExpressions = orExpressions;
	}

	public ArrayList<Expression> getAndExpressions() {
		return andExpressions;
	}

	public void setAndExpressions(ArrayList<Expression> andExpressions) {
		this.andExpressions = andExpressions;
	}

	public boolean isIteration() {
		return isIteration;
	}

	public void setIteration(boolean isIteration) {
		this.isIteration = isIteration;
	}

	public void fillAlphabet() {
		absAl.clear();
		abstractAlphabet.clear();
		char[] exp = express.toCharArray();
		abstractAlphabet.put(new Character('$'), new Integer(-1));
		//ArrayList<Character> absAl = new ArrayList<Character>();
		int charNum = 0;
		for (int i = 0; i < exp.length; ++i) {
			char c = exp[i];

			switch (c) {
			case '(':

				break;
			case ')':

				break;
			case '|':

				break;
			case '$':

				break;
			case '*':

				break;

			default:
				if (!absAl.contains(new Character(c)))
					absAl.add(new Character(c));
				break;
			}
		}
		
		Collections.sort(absAl);
		absAl.add('?');
		int i = 0;
		for(Character c: absAl) 
			abstractAlphabet.put(c, i++);
		
		//abstractAlphabet.put(new Character('?'), i);
	}

	public String orParsAdd(String s) {
		char[] exp = s.toCharArray();
		StringBuffer rez = new StringBuffer();
		// rez.append('(');
		boolean isOr = false;
		int par = 0;
		for (int i = 0; i < exp.length; ++i) {
			char c = exp[i];

			switch (c) {
			case '(':
				++par;
				rez.append(c);
				break;

			case ')':
				--par;
				rez.append(c);
				break;

			case '|':
				if (par == 0) {
					if (!isOr) {
						StringBuffer buf = new StringBuffer();
						buf.append('(');
						buf.append(rez);
						rez = buf;
					}
					isOr = true;
					rez.append(')');
					rez.append(c);
					rez.append('(');
				}

				else
					rez.append(c);

				break;

			default:
				rez.append(c);
				break;
			}

			if (i == exp.length - 1 && isOr)
				rez.append(')');
		}

		return new String(rez);

	}

	public void recognize(String regExp) {

		char[] exp = regExp.toCharArray();
		if (exp.length == 1)
			return;

		regExp = orParsAdd(regExp);
		exp = regExp.toCharArray();
		int openPar = 0, closePar = 0;
		int start = -1, end = -1;
		boolean isOr = false;
		char c;
		char[] prev = null;
		boolean isPrevAnd = true;

		for (int i = 0; i < exp.length; ++i) {
			c = exp[i];
			switch (c) {
			case '(':
				if (openPar == 0) {
					start = i + 1;
				}
				++openPar;

				break;

			case ')':
				++closePar;
				if (closePar == openPar) {
					end = i;
					closePar = openPar = 0;

					if (isOr && i == exp.length - 1) {
						String buf = regExp.substring(start, end);
						if (start + 1 < end - 1) {
							if (regExp.substring(start + 1, end - 1).equals(
									buf.substring(1, buf.length() - 1))) {
								buf = buf.substring(1, buf.length() - 1);

							}
						}
						orExpressions.add(new Expression(buf));
					}
				}

				break;

			case '|':
				if (openPar == 0 && closePar == 0) {
					isOr = true;
					orExpressions.add(new Expression(regExp.substring(start,
							end)));
				}

				break;

			default:
				break;
			}
		}

		if (isOr) {
			for (Expression e : orExpressions) {
				e.recognize(e.express);
			}

			return;
		}

		for (int i = 0; i < exp.length; ++i) {

			c = exp[i];

			switch (c) {
			case '(':
				if (openPar == 0) {
					start = i + 1;
				}
				++openPar;

				break;

			case ')':

				++closePar;
				if (closePar == openPar) {
					end = i;
					boolean isIter = false;
					if (i < exp.length - 1 && exp[i + 1] == '*') {
						isIter = true;
					}

					andExpressions.add(new Expression(regExp.substring(start,
							end), isIter));
					closePar = openPar = 0;
					start = end = -1;
				}

				break;

			case '|':
				break;

			case '*':
				break;

			default:
				if (openPar == 0) {

					andExpressions.add(new Expression("" + c));
					/*
					 * if (start < 0) { start = i; }
					 * 
					 * if (i < exp.length - 1 && exp[i + 1] == '(') { end = i +
					 * 1; andExpressions.add(new Expression(regExp.substring(
					 * start, end), false)); start = end = -1; } else if (i ==
					 * exp.length - 1) { end = i + 1; andExpressions.add(new
					 * Expression(regExp.substring( start, end), false)); start
					 * = end = -1; }
					 */
				}
				break;
			}

		}

		for (Expression e : andExpressions) {
			e.recognize(e.express);
		}

		return;

	}

	public void buildGraph() {
		if (orExpressions.isEmpty() && andExpressions.isEmpty()) {
			int n = abstractAlphabet.get(express.charAt(0));
			graph = new LambdaGraph(express, n, isIteration);

			return;
		}

		ArrayList<LambdaGraph> subgraphs = new ArrayList<LambdaGraph>();
		if (!orExpressions.isEmpty()) {
			for (Expression e : orExpressions)
				e.buildGraph();

			for (Expression e : orExpressions)
				subgraphs.add(e.getGraph());
			graph = LambdaGraph.concat(subgraphs, LambdaGraph.OR);
			if (isIteration)
				graph.iterate();
		}

		if (!andExpressions.isEmpty()) {
			for (Expression e : andExpressions)
				e.buildGraph();

			for (Expression e : andExpressions)
				subgraphs.add(e.getGraph());
			graph = LambdaGraph.concat(subgraphs, LambdaGraph.AND);
			if (isIteration)
				graph.iterate();
		}

	}

	private ArrayList<Expression> orExpressions;
	private ArrayList<Expression> andExpressions;
	private String express;

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public LambdaGraph getGraph() {
		return graph;
	}

	public void setGraph(LambdaGraph graph) {
		this.graph = graph;
	}

	private boolean isIteration = false;
	public static Hashtable<Character, Integer> abstractAlphabet = new Hashtable<Character, Integer>();
	public static ArrayList<Character> absAl = new ArrayList<Character>();
	private LambdaGraph graph;

}
