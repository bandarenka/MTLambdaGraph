package Expression;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import determinzation.Determinazation;
import determinzation.SimpleGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public class TranslationFrame extends JFrame {

	public TranslationFrame() {

		super("Translation");

		// Location and size of frame

		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getCenterPoint();
		center.x -= DEFAULT_WIDTH / 2;
		center.y -= DEFAULT_HEIGHT / 2;
		setLocation(center);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

		setLayout(new GridLayout(1, 2));
		menuBar = new JMenuBar();
		inExpMenu = new JMenuItem("Input Regular Expression");
		menuBar.add(inExpMenu);
		setJMenuBar(menuBar);

		graphPanel = new JPanel();
		tablePanel = new JPanel();
		
		JPanel rPanel = new JPanel();
		rPanel.setLayout(new GridLayout(3, 1));
		rPanel.add(new JPanel());
		rPanel.add(tablePanel);
		add(graphPanel);
		add(rPanel);

		inExpMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (prevExpression == null)
					prevExpression = "9(0|9)*($|u|l|ul|lu)";
				else if (expression != null)
					prevExpression = new String(expression);

				expression = JOptionPane.showInputDialog(
						"Input Regular Expression:", prevExpression);
				if (expression != null) {
					vg = null;
					buildGraph();
					graphPanel.removeAll();
					graphPanel.add(vg.getVv());
					
					tablePanel.removeAll();
					//tablePanel.add(table);

				}

			}
		});

	}

	private void buildGraph() {
		TranslationProcessing tp = new TranslationProcessing(expression,
				this.getWidth(), this.getHeight());
		sg = tp.getSg();
		vg = tp.process();
		d = new Determinazation(sg);
		d.process();
		table = d.getTable();
		
		d.print(); 
	}

	void myRepaint() {
		repaint();
	}

	private VisualGraph vg = null;
	private String expression;
	private String prevExpression;
	private SimpleGraph sg;
	private Determinazation d;

	private JMenuBar menuBar;
	private JMenuItem inExpMenu;

	private JPanel graphPanel;
	private JPanel tablePanel;
	private JTable table;

	private TranslationFrame fThis = this;

	public static final int DEFAULT_HEIGHT = 630;
	public static final int DEFAULT_WIDTH = 1000;

}
