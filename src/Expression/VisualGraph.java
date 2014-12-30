package Expression;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;

import javax.swing.JMenuBar;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class VisualGraph {

	public VisualGraph(int vStartNumber, int vEndNubmer, int width, int height) {
		super();
		this.vStartNumber = vStartNumber;
		this.vEndNubmer = vEndNubmer;
		this.DEFAULT_HEIGHT = height;
		this.DEFAULT_WIDTH = width;

		g = new DirectedSparseGraph<Integer, Edge2>();
		layout = new KKLayout<Integer, Edge2>(g);// Dimension - ?
	//	layout.setSize(new Dimension(DEFAULT_WIDTH - 100, DEFAULT_HEIGHT - 100));
		vv = new VisualizationViewer<Integer, String>(layout);// Dimension - ?
		//vv.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setStyle();
	}

	private void setStyle() {
		Transformer<Integer, Paint> vertexPaint = new Transformer<Integer, Paint>() {
			public Paint transform(Integer i) {
				if (i == vStartNumber || i == vEndNubmer)
					return Color.PINK;
				return Color.GREEN;
			}
		};

		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);

		DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
		gm.setMode(ModalGraphMouse.Mode.PICKING);
		vv.setGraphMouse(gm);
	}

	public Graph<Integer, Edge2> getG() {
		return g;
	}

	

	public VisualizationViewer<Integer, String> getVv() {
		return vv;
	}


	public void setDimension(int widht, int height) {
		layout.setSize(new Dimension(widht, height));
		vv.setPreferredSize(new Dimension(widht, height));
	}

	private Layout layout;
	private VisualizationViewer<Integer, String> vv;
	private Graph<Integer, Edge2> g;
	private int vStartNumber;
	private int vEndNubmer;
	
	public static  int DEFAULT_HEIGHT;
	public static  int DEFAULT_WIDTH;
}
