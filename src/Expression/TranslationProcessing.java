package Expression;
import java.util.ArrayList;

import determinzation.SimpleGraph;
import LambdaGraph.Bow;
import LambdaGraph.Vertex;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public class TranslationProcessing {

	public TranslationProcessing(String expression, int width, int height) {
	
		this.DEFAULT_HEIGHT = height;
		this.DEFAULT_WIDTH = width;

		e = new Expression(expression);
		parse();
		sg = createSimpleGraph();
		e.getGraph().printGraph();
		
		int vStartNumber = e.getGraph().getstartVertex().getnumber();
		int vEndNubmer = e.getGraph().getendVertex().getnumber();
		
		vg = new VisualGraph(vStartNumber, vEndNubmer, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		g = vg.getG();
	}

	public void parse() {
		e.fillAlphabet();
		e.recognize(e.getExpress());
		e.buildGraph();
		e.getGraph().nameVertexes();
		e.getGraph().sort();
	}

	public SimpleGraph createSimpleGraph() {
		return e.getGraph().convertToSimpleGraph();
	}
	public void buildVisualGraph() {
		for (Vertex v : e.getGraph().getVertexes()) {
			g.addVertex(v.getnumber());
		}

		ArrayList<Edge2> edges = new ArrayList<Edge2>();

		Bow[] bows = createBowsArray();
		reduceEdgesAndFill(bows, edges);

		for (Edge2 edg : edges) {
			g.addEdge(edg, edg.getStart(), edg.getEnd());
		}
	}

	public VisualGraph process() {
		
		buildVisualGraph();
		return vg;
	}

	
	private Bow[] createBowsArray() {
		Bow[] bows = new Bow[e.getGraph().getbows().size()];
		int k = 0;
		for (Bow b : e.getGraph().getbows())
			bows[k++] = b;
		return bows;
	}

	private void reduceEdgesAndFill(Bow[] bows, ArrayList<Edge2> edges) {

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
	}

	public SimpleGraph getSg() {
		return sg;
	}

	private Expression e;
	private Graph<Integer, Edge2> g;
	private VisualGraph vg;
	private SimpleGraph sg;
	
	public static  int DEFAULT_HEIGHT;
	public static  int DEFAULT_WIDTH;
}
