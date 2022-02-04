package geometry;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperLeft;
	private int width;
	private int height;
	//private boolean selected;
	
public Rectangle () {
		
	}
	
	public Rectangle(Point upperLeft,int width,int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft,int width,int height,boolean selected) {
		this(upperLeft,width,height);
		this.selected = selected;
	}
	
	public int area() {
		int area = height*width;
		return area;
	}
	
	public int circumference() {
		int circumference = 2*height+2*width;
		return circumference;
	}
	
	@Override
	public String toString() {
		return " Upper left point:(" + this.upperLeft.getX() + " , " + this.upperLeft.getY() + "), width = "+ this.width + " height = "+ this.height;
				
				
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if(this.upperLeft.equals(temp.upperLeft) && this.width == temp.width && this.height == temp.height) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void moveOn(int x, int y) {
		upperLeft.moveOn(x, y);
		
	}

	@Override
	public void moveBy(int dx, int dy) {
		upperLeft.moveBy(dx, dy);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return area() - ((Rectangle)o).area();
		}
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return this.upperLeft.getX() <= x && this.upperLeft.getX() + width >=x && this.upperLeft.getY() <= y && this.upperLeft.getY() + height >= y;
	}
	
	public boolean contains(Point p) {
		return contains (p.getX(),p.getY());
	}
	
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void draw (Graphics g) {
		g.drawRect (this.getUpperLeft().getX(),this.getUpperLeft().getY(),this.width,this.height);
		if (selected) {
			g.drawRect (upperLeft.getX()-3,upperLeft.getY()-3,6,6);
			g.drawRect (upperLeft.getX()+ width -3,upperLeft.getY()-3,6,6);
			g.drawRect (upperLeft.getX() -3,upperLeft.getY()+ height - 3,6,6);
			g.drawRect (upperLeft.getX() + width -3,upperLeft.getY() + height - 3,6,6);
		}
	}

	
}
