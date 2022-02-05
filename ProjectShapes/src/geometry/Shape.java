package geometry;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape implements Moveable,Comparable<Object>{
	protected boolean selected;
	protected Color color;
	
	public abstract boolean contains (int x, int y);
	public abstract void draw (Graphics g);

	public Shape () {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
