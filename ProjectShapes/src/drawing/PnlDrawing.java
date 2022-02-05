package drawing;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;


import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;


public class PnlDrawing extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingFrame frm;
	private ArrayList<Shape> shapes = new ArrayList<> ();
	private Point startPoint;
	private Shape selected;
	
	public PnlDrawing() {

	}
	
	public PnlDrawing (DrawingFrame frm) {
		setBackground(Color.WHITE);
		setSize(200,200);
		setVisible(true);
		this.frm = frm;
		addMouseListener(new MouseAdapter () {
			@Override
			public void mouseClicked(MouseEvent mE) {
				thisMouseClicked(mE);
			}
		});
		
		
	}
	protected void thisMouseClicked (MouseEvent e) {
		Shape newShape = null;
		if (frm.getTglbtnSelected().isSelected()) {
			selected = null;
			Iterator<Shape> it = shapes.iterator();
			while (it.hasNext()) {
				Shape shape = it.next();
				shape.setSelected(false);
				if (shape.contains(e.getX(), e.getY())) {
					selected = shape;
				}
			}
			
			if (selected != null) {
				selected.setSelected(true);
			}
		
		}
		else if (frm.getTglbtnPoint().isSelected()) {
			newShape = new Point(e.getX(), e.getY(), false);
			
		}
		else if (frm.getTglbtnLine().isSelected()) {
			if (startPoint == null) {
				startPoint = new Point(e.getX(), e.getY());
			} 
			else {
				newShape = new Line(startPoint, new Point(e.getX(), e.getY()), false);
				startPoint = null;
			}
			
		}
		else if (frm.getTglbtnRectangle().isSelected()) {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setModal(true);
			dialog.setRectangle(new Rectangle(new Point(e.getX(),e.getY()), -1, -1));
			dialog.setVisible(true);
			if(!dialog.isCheckAll()) {
				return;
			}
				try {
					newShape = dialog.getRectangle();
				}
				catch (Exception ex){
					JOptionPane.showMessageDialog(frm, "Wrong data type.", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}
		else if(frm.getTglbtnCircle().isSelected()) {
			CircleDialog cdialog = new CircleDialog();
			cdialog.setModal(true);
			cdialog.setCircle(new Circle(-1,new Point(e.getX(),e.getY())));
			cdialog.setVisible(true);
			if(!cdialog.isCheckAll()) {
				return;
			}
				try {
					newShape = cdialog.getCircle();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frm, "Wrong data type.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
		}
		else if(frm.getTglbtnDonut().isSelected()) {
			DonutDialog ddialog = new DonutDialog();
			ddialog.setModal(true);
			ddialog.setDonut(new Donut(-1,new Point(e.getX(),e.getY()),-1));
			ddialog.setVisible(true);
			if(!ddialog.isCheckAll()) {
				return;
			}
			try {
				newShape = ddialog.getDonut();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(frm, "Wrong data type.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (newShape != null) {
			shapes.add(newShape);
		}

		repaint();

			
			
		}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			g.setColor(shape.getColor());
			shape.draw(g);
		}
	}
	public DrawingFrame getFrm() {
		return frm;
	}
	public void setFrm(DrawingFrame frm) {
		this.frm = frm;
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Shape getSelected() {
		return selected;
	}
	public void setSelected(Shape selected) {
		this.selected = selected;
	}
	
	
	


}
