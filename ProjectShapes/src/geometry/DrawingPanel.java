package geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;



public class DrawingPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawingPanel () {
		
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		Line line = new Line(new Point(50,50), new Point (50,70));
		Point point = new Point (100,100);
		point.setSelected(true);
		line.setSelected(true);
		line.setSelected(false);
		Rectangle rect = new Rectangle (new Point(200,120),100,50);
		rect.setSelected(true);
		Circle circle = new Circle (50,new Point(150,150));
		circle.setSelected(true);
		Donut donut = new Donut (100,new Point(100,200),50);
		donut.setSelected(true);
		
		
		Object[] objects = new Object[5];
		objects[0] = line;
		objects[1] = point;
		objects[2] = circle;
		objects[3] = donut;
		objects[4] = rect;
		
		ArrayList<Shape> listOfShapes = new ArrayList<Shape>();
		listOfShapes.add(new Point(20,20));
		listOfShapes.add(new Line(new Point(30,30), new Point(50,50)));
	
		Iterator<Shape> it = listOfShapes.iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			shape.moveBy(10, 0);
			if(shape instanceof Line || shape instanceof Point) {
				shape.draw(g);
			}
	}

	}
}
