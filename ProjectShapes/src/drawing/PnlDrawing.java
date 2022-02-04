package drawing;

import javax.swing.JPanel;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;


public class PnlDrawing extends JPanel {
	private DrawingFrame frm;
	private ArrayList<Shape> shapes = new ArrayList<> ();
	private Point startPoint;
	private Shape selected;
	
	public PnlDrawing (DrawingFrame frm) {
		this.frm = frm;
		addMouseListener(new MouseAdapter () {
			public void mouseClicked(MouseEvent mE) {
				thisMouseClicked(mE);
			}
		});
		
		
	}
	protected void thisMouseClicked (MouseEvent e) {
		Shape newShape = null;
		if (frm.getTglbtnSelected().isSelected()) {
		
		}
		else if (frm.getTglbtnPoint().isSelected()) {
			
		}
		else if (frm.getTglbtnLine().isSelected()) {
			
		}
		else if (frm.getTglbtnRectangle().isSelected()) {
			Rectangle r = new Rectangle(new Point(65,86),45,78);
			shapes.add(r);
			repaint();
			System.out.println("SSSSSSSSS");
		}
		else if(frm.getTglbtnCircle().isSelected()) {
			
		}
		else if(frm.getTglbtnDonut().isSelected()) {
			
		}
		
	}
	
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			shape.draw(g);
			System.out.println("AAAAAAAAAAA");
		}
	}
	
	


}
